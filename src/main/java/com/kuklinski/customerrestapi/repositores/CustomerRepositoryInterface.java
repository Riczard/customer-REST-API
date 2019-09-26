package com.kuklinski.customerrestapi.repositores;

import com.kuklinski.customerrestapi.domain.Customer;

public interface CustomerRepositoryInterface {

    Customer getCustomerById(String id);
    Customer addCustomer(Customer customer);
}
