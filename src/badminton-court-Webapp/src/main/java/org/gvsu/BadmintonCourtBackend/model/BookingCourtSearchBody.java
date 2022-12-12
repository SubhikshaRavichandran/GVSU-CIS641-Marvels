package org.gvsu.BadmintonCourtBackend.model;

import lombok.Data;

@Data
public class BookingCourtSearchBody {
  private String place;
  private String date;
  private String time;
}
