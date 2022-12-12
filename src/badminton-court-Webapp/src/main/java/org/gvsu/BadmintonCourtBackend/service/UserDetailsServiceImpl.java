package org.gvsu.BadmintonCourtBackend.service;

import org.gvsu.BadmintonCourtBackend.model.Customer;
import org.gvsu.BadmintonCourtBackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayDeque;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUserName(username);
        return new User(customer.getUserName(), customer.getPassword(), new ArrayDeque<>());
    }
}
