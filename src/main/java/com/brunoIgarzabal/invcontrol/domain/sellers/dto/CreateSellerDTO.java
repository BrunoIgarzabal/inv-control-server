package com.brunoIgarzabal.invcontrol.domain.sellers.dto;

import com.brunoIgarzabal.invcontrol.domain.address.dto.CreateAddressDTO;
import com.brunoIgarzabal.invcontrol.domain.contacts.dto.CreateContactDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public final class CreateSellerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome é obrigatório")
    private String fullName;

    private String cpf;

    @NotNull(message = "Dados de Contato são obrigatórios")
    private CreateContactDTO contact;

    @NotNull(message = "Dados de Endereço são obrigatórios")
    private CreateAddressDTO address;

    public String getFullName() {
        return fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public CreateContactDTO getContact() {
        return contact;
    }

    public CreateAddressDTO getAddress() {
        return address;
    }
}
