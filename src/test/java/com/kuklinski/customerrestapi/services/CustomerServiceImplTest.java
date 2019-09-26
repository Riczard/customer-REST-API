package com.kuklinski.customerrestapi.services;

import com.kuklinski.customerrestapi.domain.Customer;
import com.kuklinski.customerrestapi.exceptions.ResourceNotFoundException;
import com.kuklinski.customerrestapi.repositores.CustomerRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl customerService;

    @MockBean
    private CustomerRepositoryImpl customerRepository;

    @Test
    public void shouldGetCustomerByIdIfExist() {
        when(customerRepository.getCustomerById(0)).thenReturn(new Customer());
        assertNotNull(customerService.getCustomerById(0));
    }

    @Test
    public void shouldGetCustomerByIdThrowExceptionWhenIdDontExist() {
        assertThrows(ResourceNotFoundException.class,
                () -> customerService.getCustomerById(10)
        );
    }
}