package com.udacity.jdnd.course3.service;

import com.udacity.jdnd.course3.data.inventory.Plant;
import com.udacity.jdnd.course3.data.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public Plant getPlantByName(String name){
        return plantRepository.findByName(name);
    }

    public boolean hasBeenDelivered(Long plantId) {
        return plantRepository.deliveryCompleted(plantId);
    }

    public List<Plant> getAllPlantsCheaperThan(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }


}
