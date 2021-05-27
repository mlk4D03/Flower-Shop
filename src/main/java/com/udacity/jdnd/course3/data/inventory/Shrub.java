package com.udacity.jdnd.course3.data.inventory;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Shrub extends Plant {

    private Double weight;

    private Double height;

    public Shrub(String name, BigDecimal price, Double weight, Double height) {
        super(name, price);
        this.height = height;
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
