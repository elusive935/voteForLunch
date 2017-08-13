package core.DAO.voting;

import core.domain.model.votes.Vote;
import core.domain.to.VoteTO;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static core.domain.model.votes.Vote.*;

@Repository
@Transactional(readOnly = true)
public final class VotingDAOImpl implements VotingDAO {
    private final static LocalTime TIME_X = LocalTime.of(21, 0);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean vote(int id) {
        if (LocalTime.now().isBefore(TIME_X)) {
            List<Vote> votes = entityManager.createNamedQuery(BY_DATE, Vote.class)
                    .setParameter(1, LocalDate.now())
                    .setParameter(2, 100000)
                    .getResultList();
            Vote vote = DataAccessUtils.singleResult(votes);
            if (vote == null) {
                entityManager.persist(new Vote(id, 100000));
            } else {
                vote.setRestaurantId(id);
                entityManager.merge(vote);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<VoteTO> getVotesForToday() {
        List<Vote> resultList = entityManager.createNamedQuery(TODAY, Vote.class)
                .setParameter(1, LocalDate.now())
                .getResultList();
        return adapterToVoteTO(resultList);
    }

    @Override
    public List<VoteTO> getAllVotes() {
        List<Vote> resultList = entityManager.createNamedQuery(ALL, Vote.class)
                .getResultList();
        return adapterToVoteTO(resultList);
    }

    private List<VoteTO> adapterToVoteTO(List<Vote> original) {
        return original.stream()
                .map(e -> new VoteTO(e.getDate(), e.getRestaurantId(), e.getUserId()))
                .collect(Collectors.toList());
    }
}
