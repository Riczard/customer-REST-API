package com.kuklinski.customerrestapi.repositores;

import com.kuklinski.customerrestapi.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository implements CustomerRepositoryInterface {

    private static long id = 0;

    private Map<String, Customer> customersMap;

    public CustomerRepository() {
        this.customersMap = new HashMap<>();
    }

    public Customer getCustomerById(long id) {
        return customersMap.get(String.valueOf(id));
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(id);
        customersMap.put(String.valueOf(id++), customer);
        return customer;
    }

}
