package core.DAO.user;

import core.domain.model.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public final class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()){
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return entityManager.createNamedQuery(User.DELETE).setParameter(1, id).executeUpdate() != 0;
    }

    @Override
    public User get(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByLogin(String login) {
        return entityManager.createNamedQuery(User.GET_BY_LOGIN, User.class).setParameter(1, login).getSingleResult();
    }

}
