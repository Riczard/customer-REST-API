package com.kuklinski.customerrestapi.domain;

import javax.validation.constraints.NotNull;

public class CustomerDTO {

    private long id;

    @NotNull
    private String name;

    private AddressDTO address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
