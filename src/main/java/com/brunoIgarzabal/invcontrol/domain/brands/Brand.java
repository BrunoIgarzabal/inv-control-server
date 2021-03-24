package com.brunoIgarzabal.invcontrol.domain.brands;

import com.brunoIgarzabal.invcontrol.domain.Base;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_brands")
public final class Brand extends Base<Brand> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public Brand() {}

    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
