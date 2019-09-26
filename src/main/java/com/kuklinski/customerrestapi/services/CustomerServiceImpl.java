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

    public Customer getCustomerById(long id) {
        Customer customer= customerRepository.getCustomerById(id);
        if(customer == null) {
            throw new IllegalArgumentException("Any customer with this id");
        }
        return customer;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }
}
