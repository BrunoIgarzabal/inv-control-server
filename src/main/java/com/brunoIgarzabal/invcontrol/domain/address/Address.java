package com.brunoIgarzabal.invcontrol.domain.address;

import com.brunoIgarzabal.invcontrol.domain.Base;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_address")
public final class Address extends Base<Address> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String number;
    private String cep;
    private String street;
    private String district;
    private String complement;

    private String city;
    private String state;

    public Address() {}

    public Address(String number, String cep, String street, String district, String complement, String city, String state) {
        this.number = number;
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.complement = complement;
        this.city = city;
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
