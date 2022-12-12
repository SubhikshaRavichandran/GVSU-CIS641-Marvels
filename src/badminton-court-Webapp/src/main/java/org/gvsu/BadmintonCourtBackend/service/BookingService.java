package org.gvsu.BadmintonCourtBackend.service;

import org.gvsu.BadmintonCourtBackend.model.BadmintonCourt;
import org.gvsu.BadmintonCourtBackend.model.Booking;
import org.gvsu.BadmintonCourtBackend.model.BookingConfirmation;
import org.gvsu.BadmintonCourtBackend.model.BookingCourtSearchBody;
import org.gvsu.BadmintonCourtBackend.model.Payment;

import java.text.ParseException;
import java.util.List;

public interface BookingService {
  List<BadmintonCourt> getAvailableCourts(BookingCourtSearchBody searchBody) throws ParseException;
  Booking createBooking(BookingConfirmation confirmation);
  Booking confirmBooking(Payment payment);
  List<Booking> getAllBookings();
}
