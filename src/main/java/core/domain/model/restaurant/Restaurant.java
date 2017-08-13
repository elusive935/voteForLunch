package core.domain.model.restaurant;

import core.domain.model.NamedEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Restaurant.QUERY_GET_ALL, query = "SELECT r FROM Restaurant r"),
        @NamedQuery(name = Restaurant.QUERY_GET_BY_ID, query = "SELECT r FROM Restaurant r WHERE r.id=:restaurantId"),
        @NamedQuery(name = Restaurant.QUERY_DELETE_DISHES, query = "DELETE FROM Dish d WHERE d.restaurant.id=?1"),
        @NamedQuery(name = Restaurant.QUERY_DELETE_ALL, query = "DELETE FROM Restaurant"),
        @NamedQuery(name = Restaurant.QUERY_DELETE, query = "DELETE FROM Restaurant r WHERE r.id=?1")
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {

    public static final String QUERY_GET_ALL = "Restaurant.getAll";
    public static final String QUERY_GET_BY_ID = "Restaurant.getById";
    public static final String QUERY_DELETE_DISHES = "Restaurant.deleteDishes";
    public static final String QUERY_DELETE_ALL = "Restaurant.deleteAll";
    public static final String QUERY_DELETE = "Restaurant.delete";

//    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private List<Dish> dishes = new ArrayList<>();

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
