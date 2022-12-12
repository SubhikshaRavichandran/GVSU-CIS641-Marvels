package org.gvsu.BadmintonCourtBackend.model;

import lombok.Data;

@Data
public class Payment {
  private Long bookingId;
  private String cardName;
  private String cardNumber;
  private String cvv;
  private String expiry;
}
