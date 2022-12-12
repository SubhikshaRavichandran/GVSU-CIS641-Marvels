package org.gvsu.BadmintonCourtBackend.repository;

import org.gvsu.BadmintonCourtBackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUserName(String username);
}
