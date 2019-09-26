package com.kuklinski.customerrestapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuklinski.customerrestapi.domain.Customer;
import com.kuklinski.customerrestapi.repositores.CustomerRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    private MockMvc mockMvc = null;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;


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

    @Test
    public void testGetCustomerByIdWhenCustomerNotExistExpectedStatusNotFound() throws Exception {
        MockHttpServletRequestBuilder builder = get("/customer/10");
        ResultActions resultActions = mockMvc.perform(builder);
        resultActions.andExpect(status().isNotFound());
    }

    @Test
    public void testAddCustomerExpectedStatusCreated() throws Exception {
        Customer customer = new Customer();
        customer.setName("John");
        MockHttpServletRequestBuilder builder = post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer));
        ResultActions resultActions = mockMvc.perform(builder);
        resultActions.andExpect(status().isCreated());
    }
}