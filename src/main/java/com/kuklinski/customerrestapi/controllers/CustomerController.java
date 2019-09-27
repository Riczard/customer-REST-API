package com.kuklinski.customerrestapi.controllers;

import com.kuklinski.customerrestapi.domain.Customer;
import com.kuklinski.customerrestapi.domain.CustomerDTO;
import com.kuklinski.customerrestapi.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    private final ModelMapper modelMapper;

    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable long id) {
        CustomerDTO customerDTO = convertCustomerToDTO(customerService.getCustomerById(id));
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = convertToEntity(customerDTO);
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    private CustomerDTO convertCustomerToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private Customer convertToEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }

}
