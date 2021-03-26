package com.brunoIgarzabal.invcontrol.domain.users.dto;

import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;
import com.brunoIgarzabal.invcontrol.services.validations.user.UserUpdate;

import javax.validation.constraints.Email;
import java.io.Serializable;

@UserUpdate
public final class UpdateUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;

    @Email(message = "E-mail inválido")
    private String email;

    private String userName;

    private UserType userType;

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
}
