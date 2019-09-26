package com.kuklinski.customerrestapi.repositores;

import com.kuklinski.customerrestapi.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryInterface {

    private Map<String, Customer> customersMap;

    public CustomerRepositoryImpl() {
        this.customersMap = new HashMap<>();
    }

    public Customer getCustomerById(String id) {
        return customersMap.get(id);
    }

    public Customer addCustomer(Customer customer) {
        customersMap.put(customer.getId(), customer);
        return customer;
    }

    public Map<String, Customer> getCustomersMap() {
        return customersMap;
    }
}
