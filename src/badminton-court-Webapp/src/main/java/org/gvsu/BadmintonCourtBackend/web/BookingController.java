package org.gvsu.BadmintonCourtBackend.web;

import org.gvsu.BadmintonCourtBackend.model.BadmintonCourt;
import org.gvsu.BadmintonCourtBackend.model.Booking;
import org.gvsu.BadmintonCourtBackend.model.BookingConfirmation;
import org.gvsu.BadmintonCourtBackend.model.BookingCourtSearchBody;
import org.gvsu.BadmintonCourtBackend.model.Payment;
import org.gvsu.BadmintonCourtBackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @RequestMapping(value = {"/browse"}, method = RequestMethod.GET)
  public String browse(Model model) {
    return "browse";
  }

  @RequestMapping(value = {"/browse"}, method = RequestMethod.POST)
  public String getCourts(@ModelAttribute("searchBody") BookingCourtSearchBody searchBody, Model model) throws ParseException {
    List<BadmintonCourt> courtList = bookingService.getAvailableCourts(searchBody);
    model.addAttribute("courts", courtList);
    model.addAttribute("bookingDate",  searchBody.getDate() + " " + searchBody.getTime());
    return "browse";
  }

  @RequestMapping(value = {"/book"}, method = RequestMethod.GET)
  public String book(@RequestParam("courtId") Long courtId, @RequestParam("bookingDate") String bookingDate, Model model)  {
    model.addAttribute("courtId", courtId);
    model.addAttribute("bookingDate", bookingDate);
    return "booking";
  }

  @RequestMapping(value = {"/payment"}, method = RequestMethod.POST)
  public String createBooking(@ModelAttribute("bookingBody") BookingConfirmation confirmation, Model model)  {
    Booking booking = bookingService.createBooking(confirmation);
    model.addAttribute("booking", booking);
    return "payment";
  }

  @RequestMapping(value = {"/confirmPayment"}, method = RequestMethod.POST)
  public String confirmBooking (@ModelAttribute("payment") Payment payment, Model model)  {
    bookingService.confirmBooking(payment);
    return oldBooking(model);
  }

  @RequestMapping(value = "/oldBookings", method = RequestMethod.GET)
  public String oldBooking(Model model) {
    model.addAttribute("bookings", bookingService.getAllBookings());
    return "oldBookings";
  }
}
