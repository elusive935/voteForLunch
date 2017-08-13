package core.DAO.user;

import core.domain.model.user.Role;
import core.domain.model.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;

import static core.domain.model.user.Role.ROLE_USER;

@Repository
public final class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        return user;
    }

    @Override
    public boolean delete(int id) {
        return id % 2 == 1;
    }

    @Override
    public User get(int id) {
        return new User(1, "Misha", "misha297", "123456", new HashSet<Role>(Arrays.asList(ROLE_USER)));
    }
}
