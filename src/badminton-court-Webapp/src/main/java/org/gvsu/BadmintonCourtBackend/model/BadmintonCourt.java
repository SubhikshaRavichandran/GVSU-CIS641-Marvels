package org.gvsu.BadmintonCourtBackend.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "badminton_court")
@Getter
@Setter
public class BadmintonCourt {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 50, unique = true)
  private String name;

  @Column(nullable = false, length = 50)
  private String type;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "fee", referencedColumnName = "id")
  private BadmintonCourtFee fee;

  @Column(nullable = false, length = 50)
  private String location;

  @Column(name = "open_time", nullable = false, length = 5)
  private String openTime;

  @Column(name = "close_time", nullable = false, length = 5)
  private String closeTime;

  @OneToMany(mappedBy="court")
  private Set<Booking> bookings;
}
