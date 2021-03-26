package com.brunoIgarzabal.invcontrol.domain.formsOfPayment.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public final class CreateFormOfPaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome da forma de pagamento é obrigatória")
    @Size(max = 50, message = "Nome da forma de pagamento é muito grande")
    private String name;

    @NotNull(message = "Aceita parcelamento é obrigatório")
    private Boolean canParcel;

    public String getName() {
        return name;
    }

    public Boolean getCanParcel() {
        return canParcel;
    }
}
