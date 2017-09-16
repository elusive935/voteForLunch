package core.DAO.user;

import core.domain.model.user.User;

public interface UserDAO {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByLogin(String login);
}
