package core.DAO.restaurant;

import core.domain.model.restaurant.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public final class RestaurantDAOImpl implements RestaurantDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            entityManager.persist(restaurant);
            saveAllDishes(restaurant);
            return restaurant;
        } else {
            removeAllDishes(restaurant);
            saveAllDishes(restaurant);
            return entityManager.merge(restaurant);
        }
    }

    @Override
    public Restaurant get(int id) {
        return entityManager.find(Restaurant.class, id);
//        return entityManager.createNamedQuery(Restaurant.QUERY_GET_BY_ID, Restaurant.class)
//                .setParameter("restaurantId", id)
//                .getSingleResult();
    }

    @Override
    public List<Restaurant> getAll() {
        return entityManager.createNamedQuery(Restaurant.QUERY_GET_ALL, Restaurant.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.createNamedQuery(Restaurant.QUERY_DELETE)
                .setParameter(1, id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createNamedQuery(Restaurant.QUERY_DELETE_ALL)
                .executeUpdate();
    }

    private void saveAllDishes(Restaurant restaurant) {
        restaurant.getDishes().forEach(d -> {
            d.setDate(LocalDate.now());
            d.setRestaurant(restaurant);
            entityManager.persist(d);
        });
    }

    private void removeAllDishes(Restaurant restaurant) {
        entityManager.createNamedQuery(Restaurant.QUERY_DELETE_DISHES)
                .setParameter(1, restaurant.getId())
                .executeUpdate();
    }
}
