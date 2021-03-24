package com.brunoIgarzabal.invcontrol.domain.sellers;

import com.brunoIgarzabal.invcontrol.domain.Base;
import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_sellers")
public final class Seller extends Base<Seller> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;
    private String cpf;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private Address address;

    private Seller() {}

    public Seller(Long id, String fullName, String cpf, Contact contact, Address address) {
        this.id = id;
        this.fullName = fullName;
        this.cpf = cpf;
        this.contact = contact;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
