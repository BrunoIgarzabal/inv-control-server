package com.brunoIgarzabal.invcontrol.domain.clients.dto;

import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.clients.Client;
import com.brunoIgarzabal.invcontrol.domain.clients.enums.ClientType;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;

import java.io.Serializable;

public final class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    private String cpfCnpj;
    private ClientType clientType;

    private Contact contact;
    private Address address;

    public ClientDTO() {}

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpfCnpj = client.getCpfCnpj();
        this.clientType = client.getClientType();
        this.contact = client.getContact();
        this.address = client.getAddress();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }
}
