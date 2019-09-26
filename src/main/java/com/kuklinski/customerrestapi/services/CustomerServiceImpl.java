package com.kuklinski.customerrestapi.services;

import com.kuklinski.customerrestapi.domain.Customer;
import com.kuklinski.customerrestapi.repositores.CustomerRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {

    private final CustomerRepositoryImpl customerRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return customerRepository.getCustomerById(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }
}
