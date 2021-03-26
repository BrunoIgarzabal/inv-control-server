package com.brunoIgarzabal.invcontrol.domain.categories.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public final class CreateCategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome da categoria é obrigatória")
    @Size(max = 80, message = "Nome da categoria é muito grande")
    private String name;

    public String getName() {
        return name;
    }
}
