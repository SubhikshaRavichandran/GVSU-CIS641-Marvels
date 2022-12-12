package org.gvsu.BadmintonCourtBackend.service;

import org.gvsu.BadmintonCourtBackend.model.Customer;

public interface CustomerService {
    void save(Customer customer);

    Customer findByUsername(String username);
}
