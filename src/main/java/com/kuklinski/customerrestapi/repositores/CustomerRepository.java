package com.kuklinski.customerrestapi.repositores;

import com.kuklinski.customerrestapi.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {

    private Map<String ,Customer> customerMap;

    public CustomerRepository() {
        this.customerMap = new HashMap<>();
    }

    public Customer getCustomerById(String id) {
        return customerMap.get(id);
    }

    public Customer addCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }
}
