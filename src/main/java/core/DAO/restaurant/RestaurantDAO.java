package core.DAO.restaurant;

import core.domain.model.restaurant.Restaurant;

import java.util.List;

public interface RestaurantDAO {

    Restaurant save(Restaurant restaurant);

    Restaurant get(int id);

    List<Restaurant> getAll();

    void delete(int id);

    void deleteAll();
}
