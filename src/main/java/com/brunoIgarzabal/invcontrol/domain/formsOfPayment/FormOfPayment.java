package com.brunoIgarzabal.invcontrol.domain.formsOfPayment;

import com.brunoIgarzabal.invcontrol.domain.Base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_forms_of_payment")
public final class FormOfPayment extends Base<FormOfPayment> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(columnDefinition = "boolean default false")
    private Boolean canParcel;

    public FormOfPayment() {}

    public FormOfPayment(Long id, String name, Boolean canParcel) {
        this.id = id;
        this.name = name;
        this.canParcel = canParcel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCanParcel() {
        return canParcel;
    }

    public void setCanParcel(Boolean canParcel) {
        this.canParcel = canParcel;
    }
}
