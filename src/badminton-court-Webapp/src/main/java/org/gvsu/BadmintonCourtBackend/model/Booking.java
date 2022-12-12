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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "date")
  private Date bookingDate;

  @ManyToOne
  @JoinColumn(name="customer", nullable=false)
  private Customer customer;

  @ManyToOne
  @JoinColumn(name="court", nullable=false)
  private BadmintonCourt court;

  @Column(name = "payment_status", length = 10)
  private String paymentStatus;

  @Column(name = "price", nullable=false)
  private Double price;

  @OneToOne(mappedBy="booking")
  private CustomerHistory customerHistory;
}
