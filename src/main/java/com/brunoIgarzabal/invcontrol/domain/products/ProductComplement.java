package com.brunoIgarzabal.invcontrol.domain.products;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductComplement {

    @Column(nullable = false, length = 14)
    private String sellingPrice;

    @Column(nullable = false, length = 14)
    private String costPrice;

    @Column(nullable = false, length = 8)
    private String stock;

    @Column(nullable = false, length = 8)
    private String minStock;

    @Column(nullable = false, length = 40)
    private String unity;

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getMinStock() {
        return minStock;
    }

    public void setMinStock(String minStock) {
        this.minStock = minStock;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
}
