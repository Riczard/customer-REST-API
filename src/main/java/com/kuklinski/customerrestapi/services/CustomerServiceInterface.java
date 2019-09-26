package com.kuklinski.customerrestapi.services;

import com.kuklinski.customerrestapi.domain.Customer;

public interface CustomerServiceInterface {

    Customer getCustomerById(String id);
    Customer addCustomer(Customer customer);
}
