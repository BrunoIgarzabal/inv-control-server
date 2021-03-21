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
    private String razaoSocial;

    @NotEmpty(message = "Nome Fantasia é obrigatório")
    private String nomeFantasia;

    @NotNull(message = "Dados de Contato são obrigatórios")
    private CreateContactDTO contact;

    @NotNull(message = "Dados de Endereço são obrigatórios")
    private CreateAddressDTO address;
}
