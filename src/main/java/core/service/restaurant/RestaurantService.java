package core.service.restaurant;

import core.domain.model.restaurant.Restaurant;
import core.util.NotFoundException;

import java.util.List;

public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    Restaurant update(int id, Restaurant restaurant) throws NotFoundException;

    List<Restaurant> updateBulk(List<Restaurant> restaurantList) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void deleteAll();

    Restaurant get(int id) throws NotFoundException;

    List<Restaurant> getAll();

}
