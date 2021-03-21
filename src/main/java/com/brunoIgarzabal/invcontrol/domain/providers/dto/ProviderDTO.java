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
    private String razaoSocial;

    private String nomeFantasia;

    private Contact contact;

    private Address address;

    public ProviderDTO() {}

    public ProviderDTO(Provider provider) {
        this.id = provider.getId();
        this.ie = provider.getIe();
        this.cnpj = provider.getCnpj();
        this.razaoSocial = provider.getRazaoSocial();
        this.nomeFantasia = provider.getNomeFantasia();
        this.contact = provider.getContact();
        this.address = provider.getAddress();
    }
}
