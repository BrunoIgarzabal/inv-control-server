package com.brunoIgarzabal.invcontrol.domain.providers.dto;

import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;
import com.brunoIgarzabal.invcontrol.domain.providers.Provider;

import java.io.Serializable;

public final class ProviderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String ie;
    private String cnpj;

    private String companyName;
    private String fantasyName;

    private Contact contact;

    private Address address;

    public ProviderDTO() {}

    public ProviderDTO(Provider provider) {
        this.id = provider.getId();
        this.ie = provider.getIe();
        this.cnpj = provider.getCnpj();
        this.companyName = provider.getCompanyName();
        this.fantasyName = provider.getFantasyName();
        this.contact = provider.getContact();
        this.address = provider.getAddress();
    }

    public Provider toProvider() {
        return new Provider(
                this.id, this.ie, this.cnpj,
                this.companyName, this.fantasyName,
                this.contact, this.address);
    }

    public Long getId() {
        return id;
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
}
