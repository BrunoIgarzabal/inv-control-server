package com.brunoIgarzabal.invcontrol.domain.providers.dto;

import com.brunoIgarzabal.invcontrol.domain.address.dto.CreateAddressDTO;
import com.brunoIgarzabal.invcontrol.domain.contacts.dto.CreateContactDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public final class CreateProviderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ie;
    @NotEmpty(message = "CNPJ é obrigatório")
    private String cnpj;

    @NotEmpty(message = "Razão Social é obrigatório")
    private String companyName;

    @NotEmpty(message = "Nome Fantasia é obrigatório")
    private String fantasyName;

    @NotNull(message = "Dados de Contato são obrigatórios")
    private CreateContactDTO contact;

    @NotNull(message = "Dados de Endereço são obrigatórios")
    private CreateAddressDTO address;

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

    public CreateContactDTO getContact() {
        return contact;
    }

    public CreateAddressDTO getAddress() {
        return address;
    }
}
