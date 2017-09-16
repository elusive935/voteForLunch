package core.service.user;

import core.AuthorizedUser;
import core.DAO.user.UserDAO;
import core.domain.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public final class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public boolean delete(int id) {
        return userDAO.delete(id);
    }

    @Override
    public User get(int id) {
        return userDAO.get(id);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.getByLogin(login);
        if (user == null){
            throw new UsernameNotFoundException("User " + login + " not found");
        }
        return new AuthorizedUser(user);
    }
}
