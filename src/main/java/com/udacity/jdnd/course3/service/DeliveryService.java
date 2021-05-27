package com.udacity.jdnd.course3.service;

import com.udacity.jdnd.course3.data.RecipentAndPrice;
import com.udacity.jdnd.course3.data.delivery.Delivery;
import com.udacity.jdnd.course3.data.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipentAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

}