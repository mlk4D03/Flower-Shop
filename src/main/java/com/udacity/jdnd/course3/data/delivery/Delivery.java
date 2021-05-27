package com.udacity.jdnd.course3.data.delivery;

import com.udacity.jdnd.course3.data.inventory.Plant;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(
     name = "Delivery.findByName",
     query = "select d from Delivery d where d.name = :name"
)

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    Long id;

    @Nationalized
    private String name;

    private LocalDateTime deliveryTime;

    @Column(name = "address_full", length = 500)
    private String address;

    @Type(type = "yes_no")
    private Boolean completed = false;

    public Delivery(String name, LocalDateTime deliveryTime, String address) {
        this.name = name;
        this.deliveryTime = deliveryTime;
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "delivery",cascade = CascadeType.ALL)
    private List<Plant> plants;

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", recipentName='" + name + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", address='" + address + '\'' +
                ", completed=" + completed +
                ", plantList=" + plants +
                '}';
    }
}
