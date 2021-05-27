package com.udacity.jdnd.course3.data.inventory;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Flower extends Plant {

    private String color;

    public Flower(String name, BigDecimal price,String color) {
        super(name, price);
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
