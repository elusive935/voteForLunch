package core.domain.model.restaurant;

import core.domain.model.NamedEntity;

public class Dish extends NamedEntity {

    private int price;

    public Dish() {
    }

    public Dish(String name, int price) {
        this(null, name, price);
    }

    public Dish(Integer id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
