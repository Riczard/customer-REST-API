package com.kuklinski.customerrestapi.services;

import com.kuklinski.customerrestapi.domain.Customer;
import com.kuklinski.customerrestapi.domain.CustomerDTO;
import com.kuklinski.customerrestapi.repositores.CustomerRepositoryImpl;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerServiceImplTest {


    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepositoryImpl customerRepository;

    @Mock
    private Customer customer;

    @BeforeAll
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    public void shouldGetCustomerByIdWhenExist() {
        when(customerRepository.getCustomerById(0)).thenReturn(customer);

        assertNotNull(customerService.getCustomerById(0));
    }
}