package org.gvsu.BadmintonCourtBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "customer_history")
@Getter
@Setter
public class CustomerHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "date")
  private Date bookingDate;

  @ManyToOne
  @JoinColumn(name="customer", nullable=false)
  private Customer customer;

  @OneToOne
  @JoinColumn(name="booking", nullable=false)
  private Booking booking;
}
