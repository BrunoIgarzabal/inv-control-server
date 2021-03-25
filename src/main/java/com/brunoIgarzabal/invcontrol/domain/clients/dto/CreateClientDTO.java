package com.brunoIgarzabal.invcontrol.domain.clients.dto;

import com.brunoIgarzabal.invcontrol.domain.address.dto.CreateAddressDTO;
import com.brunoIgarzabal.invcontrol.domain.clients.enums.ClientType;
import com.brunoIgarzabal.invcontrol.domain.contacts.dto.CreateContactDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public final class CreateClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome é obrigatório")
    private String fullName;

    private String cpfCnpj;

    private ClientType clientType;

    @NotNull(message = "Dados de Contato são obrigatórios")
    private CreateContactDTO contact;

    @NotNull(message = "Dados de Endereço são obrigatórios")
    private CreateAddressDTO address;

    public String getFullName() {
        return fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public CreateContactDTO getContact() {
        return contact;
    }

    public CreateAddressDTO getAddress() {
        return address;
    }
}
