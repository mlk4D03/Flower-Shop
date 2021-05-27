package com.udacity.jdnd.course3.data.dao;

import com.udacity.jdnd.course3.data.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CandyDAOImpl implements CandyDAO{

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_CANDY_DATA = "SELECT * FROM CANDY";

    private static final String ADD_CANDY_TO_DELIVERY = "INSERT INTO CANDY_DELIVERY (candy_id,delivery_id) VALUES(:candyId,:deliveryId)";

    private static final String SELECT_CANDY_BY_DELIVERY_ID = "SELECT * FROM CANDY_DELIVERY d WHERE d.delivery_id = :deliveryId";

    @Override
    public List<CandyData> list() {
        List<CandyData> candyData = jdbcTemplate.query(SELECT_ALL_CANDY_DATA, new BeanPropertyRowMapper<>(CandyData.class));

        return candyData;
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryid) {
        jdbcTemplate.update(ADD_CANDY_TO_DELIVERY,new MapSqlParameterSource("candyId",candyId).addValue("deliveryId",deliveryid));

    }

    @Override
    public List<CandyData> findByDelivery(Long deliveryId) {
        return jdbcTemplate.query(SELECT_CANDY_BY_DELIVERY_ID, new MapSqlParameterSource().addValue("deliveryId",deliveryId),new BeanPropertyRowMapper<>(CandyData.class));
    }
}
