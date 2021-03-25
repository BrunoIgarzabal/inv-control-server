package com.brunoIgarzabal.invcontrol.domain.clients;

import com.brunoIgarzabal.invcontrol.domain.Base;
import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.clients.enums.ClientType;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_clients")
public final class Client extends Base<Client> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String cpfCnpj;

    private Integer clientType;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private Address address;

    public Client() {}

    public Client(Long id, String name, String cpfCnpj, ClientType clientType, Contact contact, Address address) {
        this.id = id;
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.clientType = clientType.getCod();
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public ClientType getClientType() {
        return ClientType.toEnum(clientType);
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType.getCod();
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
