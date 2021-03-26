package com.brunoIgarzabal.invcontrol.domain.brands.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public final class CreateBrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome da marca é obrigatório")
    @Size(max = 50, message = "Nome da marca é muito grande")
    private String name;

    public String getName() {
        return name;
    }
}
