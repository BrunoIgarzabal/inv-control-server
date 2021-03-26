package com.brunoIgarzabal.invcontrol.domain.orders.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public final class CreateOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Descrição do serviço é obrigatório")
    @Size(max = 1000, message = "Descrição do serviço deve ter no máximo 1000 caracteres")
    private String description;

    @NotEmpty(message = "Preço do serviço é obrigatório")
    @Size(max = 20, message = "Preço é muito grande")
    private String price;

    @NotNull(message = "Status do serviço é obrigatório")
    private Boolean finished;

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public Boolean getFinished() {
        return finished;
    }
}
