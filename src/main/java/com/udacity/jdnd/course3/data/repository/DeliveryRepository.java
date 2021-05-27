package com.udacity.jdnd.course3.data.repository;

import com.udacity.jdnd.course3.data.RecipentAndPrice;
import com.udacity.jdnd.course3.data.delivery.Delivery;
import com.udacity.jdnd.course3.data.inventory.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id){
        return entityManager.find(Delivery.class,id);
    }

    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    public void delete(Long id){
        Delivery delivery = entityManager.find(Delivery.class,id);
        entityManager.remove(delivery);
    }

    public List<String> getRecipents(String name) {
        TypedQuery<String> query = entityManager.createNamedQuery("Delivery.findByName",String.class);
        query.setParameter("name",name);
        return query.getResultList();
    }

    public RecipentAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipentAndPrice> criteria = cb.createQuery(RecipentAndPrice.class);
        Root<Plant> root = criteria.from(Plant.class);

        criteria.select(cb.construct(RecipentAndPrice.class,
                root.get("delivery").get("name"),
                cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"),deliveryId));
        return entityManager.createQuery(criteria).getSingleResult();
    }


}
