package core.service.restaurant;

import core.DAO.restaurant.RestaurantDAO;
import core.domain.model.restaurant.Restaurant;
import core.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDAO restaurantDAO;

    @Autowired
    public RestaurantServiceImpl(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantDAO.save(restaurant);
    }

    @Override
    public Restaurant update(int id, Restaurant restaurant) throws NotFoundException {
        return restaurantDAO.save(restaurant);
    }

    @Override
    public List<Restaurant> updateBulk(List<Restaurant> restaurantList) throws NotFoundException {
        for (Restaurant restaurant : restaurantList) {
            restaurantDAO.save(restaurant);
        }
        return restaurantList;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        restaurantDAO.delete(id);
    }

    @Override
    public void deleteAll() {
        restaurantDAO.deleteAll();
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return restaurantDAO.get(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantDAO.getAll();
    }
}
