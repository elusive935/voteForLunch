package core.domain.model.restaurant;

import core.domain.model.NamedEntity;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends NamedEntity {

    List<Dish> dishes = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String name) {
        this(null, name);
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
