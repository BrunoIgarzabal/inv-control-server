package com.brunoIgarzabal.invcontrol.domain.contact.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public final class CreateContactDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O número de telefone é obrigatório")
    private String phone;

    private String cellPhone;

    @NotEmpty(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
}
