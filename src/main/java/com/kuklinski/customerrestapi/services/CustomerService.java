package com.kuklinski.customerrestapi.services;

import com.kuklinski.customerrestapi.domain.Customer;
import com.kuklinski.customerrestapi.exceptions.ResourceNotFoundException;
import com.kuklinski.customerrestapi.repositores.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceInterface {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(long id) {
        Customer customer= customerRepository.getCustomerById(id);
        if(customer != null) {
            return customer;
        }
        throw new ResourceNotFoundException(String.format("Customer with ID = %s does not exist!", id));
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }
}
