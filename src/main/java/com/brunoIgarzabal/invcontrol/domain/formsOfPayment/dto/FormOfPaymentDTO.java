package com.brunoIgarzabal.invcontrol.domain.formsOfPayment.dto;

import com.brunoIgarzabal.invcontrol.domain.formsOfPayment.FormOfPayment;

import java.io.Serializable;

public final class FormOfPaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    private Boolean canParcel;

    public FormOfPaymentDTO() {}

    public FormOfPaymentDTO(FormOfPayment formOfPayment) {
        this.id = formOfPayment.getId();
        this.name = formOfPayment.getName();
        this.canParcel = formOfPayment.getCanParcel();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getCanParcel() {
        return canParcel;
    }
}
