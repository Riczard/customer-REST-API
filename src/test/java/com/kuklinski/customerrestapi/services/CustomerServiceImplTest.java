package com.kuklinski.customerrestapi.services;

import com.kuklinski.customerrestapi.domain.Customer;
import com.kuklinski.customerrestapi.repositores.CustomerRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        Customer customer = new Customer();
        when(customerRepository.getCustomerById(0)).thenReturn(customer);
        assertNotNull(customerService.getCustomerById(0));
    }

    @Test
    public void shouldGetCustomerByIdThrowExceptionWhenIdDontExist() {
        assertThrows(IllegalArgumentException.class,
                () -> customerService.getCustomerById(10)
        );
    }
}