package com.brunoIgarzabal.invcontrol.domain.address.dto;

import com.brunoIgarzabal.invcontrol.domain.address.Address;

import java.io.Serializable;

public final class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String number;
    private String cep;
    private String street;
    private String district;
    private String complement;

    private String city;
    private String state;

    public AddressDTO() {}

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.number = address.getNumber();
        this.cep = address.getCep();
        this.street = address.getStreet();
        this.district = address.getDistrict();
        this.complement = address.getComplement();
        this.city = address.getCity();
        this.state = address.getState();
    }

}
