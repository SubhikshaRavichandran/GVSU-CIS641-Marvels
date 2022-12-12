package org.gvsu.BadmintonCourtBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 225)
    private String password;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 10)
    private String phone;

    @Transient
    private String passwordConfirm;

    @OneToMany(mappedBy="customer")
    private Set<Booking> bookings;

    @OneToMany(mappedBy="customer")
    private Set<CustomerHistory> customerHistory;
}
