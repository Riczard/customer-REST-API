package com.kuklinski.customerrestapi.services;

import com.kuklinski.customerrestapi.domain.Customer;

public interface CustomerServiceInterface {

    Customer getCustomerById(long id);
    Customer addCustomer(Customer customer);
}
