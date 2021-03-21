package com.brunoIgarzabal.invcontrol.domain.contacts.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public final class CreateContactDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Número de telefone é obrigatório")
    private String phone;

    private String cellPhone;

    @NotEmpty(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
}
