package org.gvsu.BadmintonCourtBackend.model;

import lombok.Data;

@Data
public class BookingConfirmation {
  private Long playerCount;
  private Long racketCount;
  private Long courtId;
  private String userName;
  private String bookingDate;
}
