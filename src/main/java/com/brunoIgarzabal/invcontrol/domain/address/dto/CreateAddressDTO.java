package com.brunoIgarzabal.invcontrol.domain.address.dto;

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

}
