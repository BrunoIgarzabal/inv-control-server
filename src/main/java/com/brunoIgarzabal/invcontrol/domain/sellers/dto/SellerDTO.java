package com.brunoIgarzabal.invcontrol.domain.sellers.dto;

import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;
import com.brunoIgarzabal.invcontrol.domain.sellers.Seller;

import java.io.Serializable;

public final class SellerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String fullName;
    private String cpf;

    private Contact contact;

    private Address address;

    public SellerDTO() {}

    public SellerDTO(Seller seller) {
        this.id = seller.getId();
        this.fullName = seller.getFullName();
        this.cpf = seller.getCpf();
        this.contact = seller.getContact();
        this.address = seller.getAddress();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }
}
