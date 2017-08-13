package core.domain.model.votes;

import core.domain.model.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

import static core.domain.model.votes.Vote.ALL;
import static core.domain.model.votes.Vote.BY_DATE;
import static core.domain.model.votes.Vote.TODAY;

@Entity
@Table(name = "votes")
@NamedQueries({
        @NamedQuery(name = BY_DATE, query = "SELECT v FROM Vote v WHERE v.date=?1 AND v.userId=?2"),
        @NamedQuery(name = TODAY, query = "SELECT v FROM Vote v WHERE v.date=?1"),
        @NamedQuery(name = ALL, query = "SELECT v FROM Vote v")
})
public class Vote extends BaseEntity {
    public static final String BY_DATE = "Vote.find";
    public static final String TODAY = "Votes.today";
    public static final String ALL = "Votes.all";

    private LocalDate date;
    @Column(name = "restaurant_id")
    private int restaurantId;
    @Column(name = "user_id")
    private int userId;

    public Vote() {
    }

    public Vote(int restaurantId, int userId) {
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.date = LocalDate.now();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
