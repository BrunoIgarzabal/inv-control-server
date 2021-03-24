package com.brunoIgarzabal.invcontrol.domain.brands.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public final class CreateBrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome da marca é obrigatório")
    private String name;

    public String getName() {
        return name;
    }
}
