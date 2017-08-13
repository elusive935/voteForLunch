package core.domain.to;

import java.time.LocalDate;

public class VoteTO {
    private LocalDate date;
    private int restaurantId;
    private int userId;

    public VoteTO(LocalDate date, int restaurantId, int userId) {
        this.date = date;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
