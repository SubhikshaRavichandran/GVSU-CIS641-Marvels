package org.gvsu.BadmintonCourtBackend.service;

import lombok.SneakyThrows;
import org.gvsu.BadmintonCourtBackend.model.BadmintonCourt;
import org.gvsu.BadmintonCourtBackend.model.Booking;
import org.gvsu.BadmintonCourtBackend.model.BookingConfirmation;
import org.gvsu.BadmintonCourtBackend.model.BookingCourtSearchBody;
import org.gvsu.BadmintonCourtBackend.model.Customer;
import org.gvsu.BadmintonCourtBackend.model.CustomerHistory;
import org.gvsu.BadmintonCourtBackend.model.Payment;
import org.gvsu.BadmintonCourtBackend.model.PaymentStatus;
import org.gvsu.BadmintonCourtBackend.repository.BadmintonCourtRepository;
import org.gvsu.BadmintonCourtBackend.repository.BookingRepository;
import org.gvsu.BadmintonCourtBackend.repository.CustomerHistoryRepository;
import org.gvsu.BadmintonCourtBackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
  public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

  @Autowired
  private BadmintonCourtRepository badmintonCourtRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private CustomerHistoryRepository customerHistoryRepository;

  public List<BadmintonCourt> getAvailableCourts(BookingCourtSearchBody searchBody) throws ParseException {
    Date startDate = dateFormat.parse(searchBody.getDate() + " " + searchBody.getTime());

    // Each session is 59 minutes
    Date endDate = new Date(startDate.getTime() + (3540 * 1000));
    String location = "%" + searchBody.getPlace() + "%";
    List<BadmintonCourt> courtList =
        badmintonCourtRepository.findByLocationAndStartDateAndEndDate(location, startDate, endDate);

    return courtList.stream()
        .filter(c -> isAllowedTime(c, searchBody.getTime()))
        .collect(Collectors.toList());
  }

  @SneakyThrows
  @Override
  public Booking createBooking(BookingConfirmation confirmation) {
    BadmintonCourt court = badmintonCourtRepository.findOne(confirmation.getCourtId());
    Double totalPrice = (confirmation.getPlayerCount() - 1) * court.getFee().getAdditionalPlayerFee() +
        (confirmation.getRacketCount() * court.getFee().getRacketRentalFee()) +
        court.getFee().getCourtRentalFee();
    Customer customer = customerRepository.findByUserName(confirmation.getUserName());
    Booking booking = new Booking();
    booking.setBookingDate(dateFormat.parse(confirmation.getBookingDate()));
    booking.setCourt(court);
    booking.setPrice(totalPrice);
    booking.setCustomer(customer);
    booking.setPaymentStatus(PaymentStatus.PENDING.name());
    booking = bookingRepository.save(booking);

    CustomerHistory customerHistory = new CustomerHistory();
    customerHistory.setCustomer(customer);
    customerHistory.setBooking(booking);
    customerHistory.setBookingDate(booking.getBookingDate());
    customerHistoryRepository.save(customerHistory);
    return booking;
  }

  @Override
  public Booking confirmBooking(Payment payment) {
    Booking booking = bookingRepository.findOne(payment.getBookingId());
    booking.setPaymentStatus(PaymentStatus.COMPLETE.name());
    return bookingRepository.save(booking);
  }

  @Override
  public List<Booking> getAllBookings() {
    Customer customer = customerRepository.findByUserName(getUserName());
    return bookingRepository.findByCustomerIdAndPaymentStatus(customer.getId(),
        PaymentStatus.COMPLETE.name());
  }


  @SneakyThrows
  private boolean isAllowedTime(BadmintonCourt badmintonCourt, String timeInput) {
    Date startDate = timeFormat.parse(badmintonCourt.getOpenTime());
    Date endDate = timeFormat.parse(badmintonCourt.getCloseTime());
    Date inputDate = timeFormat.parse(timeInput);
    return inputDate.before(endDate) && inputDate.after(startDate);
  }

  private String getUserName() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
      return ((UserDetails)principal).getUsername();
    }
    return principal.toString();
  }
}
