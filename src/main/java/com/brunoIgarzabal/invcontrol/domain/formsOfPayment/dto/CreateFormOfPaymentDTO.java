package com.brunoIgarzabal.invcontrol.domain.formsOfPayment.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public final class CreateFormOfPaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome é obrigatório")
    private String name;

    private Boolean canParcel;

    public String getName() {
        return name;
    }

    public Boolean getCanParcel() {
        return canParcel;
    }
}
