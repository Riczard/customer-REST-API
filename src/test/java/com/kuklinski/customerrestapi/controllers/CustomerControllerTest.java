package com.kuklinski.customerrestapi.controllers;

import com.kuklinski.customerrestapi.domain.Customer;
import com.kuklinski.customerrestapi.repositores.CustomerRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    private MockMvc mockMvc = null;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    @Before
    public void before() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void after() {
        this.mockMvc = null;
    }

    @Test
    public void testGetCustomerByIdExpectedStatusIsOk() throws Exception {
        customerRepository.addCustomer(new Customer());
        MockHttpServletRequestBuilder builder = get("/customer/0");
        ResultActions resultActions = mockMvc.perform(builder);
        resultActions.andExpect(status().isOk());
    }

}