package com.brunoIgarzabal.invcontrol.domain.providers;

import com.brunoIgarzabal.invcontrol.domain.Base;
import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_fornecedores")
public final class Provider extends Base<Provider> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ie;
    private String cnpj;
    private String razaoSocial;

    private String nomeFantasia;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Provider() {}

    public Provider(Long id,String ie, String cnpj, String razaoSocial, String nomeFantasia, Contact contact, Address address) {
        this.id = id;
        this.ie = ie;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.contact = contact;
        this.address = address;
    }

    public String getIe() {
        return ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }
}
