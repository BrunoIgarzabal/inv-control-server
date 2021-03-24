package com.brunoIgarzabal.invcontrol.domain.categories;

import com.brunoIgarzabal.invcontrol.domain.Base;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_categories")
public final class Category extends Base<Category> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public Category() {}

    public Category(Long id, String name) {
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
