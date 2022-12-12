package org.gvsu.BadmintonCourtBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "badminton_court_fee")
@Getter
@Setter
public class BadmintonCourtFee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name="court_rental_fee")
  private Double courtRentalFee;

  @Column(name="racket_rental_fee")
  private Double racketRentalFee;

  @Column(name="additional_player_fee")
  private Double additionalPlayerFee;

  @OneToOne(mappedBy = "fee")
  private BadmintonCourt badmintonCourt;
}
