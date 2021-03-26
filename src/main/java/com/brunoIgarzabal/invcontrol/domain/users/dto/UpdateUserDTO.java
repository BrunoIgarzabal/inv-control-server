package com.brunoIgarzabal.invcontrol.domain.users.dto;

import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;
import com.brunoIgarzabal.invcontrol.services.validations.user.UserUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@UserUpdate
public final class UpdateUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;

    @Email(message = "E-mail inválido")
    private String email;

    private String userName;

    private UserType userType;

    @NotEmpty(message = "Senha é obrigatória")
    private String password;

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }
}
