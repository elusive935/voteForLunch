package core.service.voting;

import core.domain.to.VoteTO;
import core.util.NotFoundException;

import java.util.List;

public interface VotingService {
    boolean vote(int id) throws NotFoundException;
    List<VoteTO> getVotesForToday();
    List<VoteTO> getAllVotes();
}
