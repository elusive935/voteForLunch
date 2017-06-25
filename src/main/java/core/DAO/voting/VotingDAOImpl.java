package core.DAO.voting;

import org.springframework.stereotype.Repository;

@Repository
public final class VotingDAOImpl implements VotingDAO {
    @Override
    public boolean vote(int id) {
        return id % 2 == 0;
    }
}
