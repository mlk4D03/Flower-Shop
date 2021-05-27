package com.udacity.jdnd.course3.data.dao;

import com.udacity.jdnd.course3.data.CandyData;

import java.util.List;

public interface CandyDAO {

    List<CandyData> list();

    void addToDelivery(Long candyId, Long deliveryid);

    List<CandyData> findByDelivery(Long deliveryId);

}
