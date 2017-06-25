package core.service.user;

import core.domain.model.user.User;

public interface UserService {

    User save(User user);

    boolean delete(int id);

    User get(int id);
}
