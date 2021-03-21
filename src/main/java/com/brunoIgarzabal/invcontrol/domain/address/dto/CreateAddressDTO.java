package com.brunoIgarzabal.invcontrol.domain.address.dto;

import com.brunoIgarzabal.invcontrol.domain.address.Address;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public final class CreateAddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Número do logradouro é obrigatório")
    private String number;

    @NotEmpty(message = "CEP é obrigatório")
    private String cep;
    @NotEmpty(message = "Logradouro é obrigatório")
    private String street;
    @NotEmpty(message = "Bairro é obrigatório")
    private String district;

    private String complement;

    @NotEmpty(message = "Cidade é obrigatória")
    private String city;
    @NotEmpty(message = "UF é obrigatório")
    private String state;

    public Address toAddress() {
        return new Address(null, this.number, this.cep, this.street, this.district, this.complement, this.city, this.state);
    }

    public String getNumber() {
        return number;
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
