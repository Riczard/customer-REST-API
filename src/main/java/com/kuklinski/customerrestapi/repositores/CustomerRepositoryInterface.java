package com.kuklinski.customerrestapi.repositores;

import com.kuklinski.customerrestapi.domain.Customer;

public interface CustomerRepositoryInterface {

    Customer getCustomerById(long id);
    Customer addCustomer(Customer customer);
}
