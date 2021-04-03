package com.brunoIgarzabal.invcontrol.domain.providers;

import com.brunoIgarzabal.invcontrol.domain.Base;
import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_providers")
public final class Provider extends Base<Provider> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ie;
    private String cnpj;
    private String companyName;

    private String fantasyName;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private Address address;

    public Provider() {}

    public Provider(Long id,String ie, String cnpj, String companyName, String fantasyName, Contact contact, Address address) {
        this.id = id;
        this.ie = ie;
        this.cnpj = cnpj;
        this.companyName = companyName;
        this.fantasyName = fantasyName;
        this.contact = contact;
        this.address = address;
    }

    public Provider(Long id, String companyName, String fantasyName) {
        this.id = id;
        this.companyName = companyName;
        this.fantasyName = fantasyName;
    }

    public String getIe() {
        return ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
