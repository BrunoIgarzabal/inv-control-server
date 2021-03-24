package com.brunoIgarzabal.invcontrol.domain.categories.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public final class CreateCategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome da categoria é obrigatória")
    private String name;

    public String getName() {
        return name;
    }
}
