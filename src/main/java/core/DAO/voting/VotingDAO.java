package core.DAO.voting;

import core.domain.to.VoteTO;

import java.util.List;

public interface VotingDAO {
    boolean vote(int id);
    List<VoteTO> getVotesForToday();
    List<VoteTO> getAllVotes();
}
