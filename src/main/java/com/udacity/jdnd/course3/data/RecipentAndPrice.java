package com.udacity.jdnd.course3.data;

import java.math.BigDecimal;

public class RecipentAndPrice {

    private String recipentName;

    private BigDecimal price;

    public RecipentAndPrice(String recipentName, BigDecimal price) {
        this.recipentName = recipentName;
        this.price = price;
    }

    public String getRecipentName() {
        return recipentName;
    }

    public void setRecipentName(String recipentName) {
        this.recipentName = recipentName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
