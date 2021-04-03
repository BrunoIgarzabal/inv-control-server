package com.brunoIgarzabal.invcontrol.domain.orders;

import com.brunoIgarzabal.invcontrol.domain.Base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_orders")
public final class Order extends Base<Order> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(length = 15, nullable = false)
    private String price;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;

    public Order() {}

    public Order(Long id, String description, String price, Boolean isActive) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        isActive = isActive;
    }
}
