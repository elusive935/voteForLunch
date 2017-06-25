package core.DAO.restaurant;

import core.domain.model.restaurant.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public final class RestaurantDAOImpl implements RestaurantDAO {

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurant;
    }

    @Override
    public Restaurant get(int id) {
        return new Restaurant(2, "RestaurantGot");
    }

    @Override
    public List<Restaurant> getAll() {
        return new ArrayList<>(Arrays.asList(new Restaurant(3, "RestaurantList1"),
                                            new Restaurant(4, "RestaurantList2")));
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }
}
