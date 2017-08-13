package core.service.voting;

import core.DAO.voting.VotingDAO;
import core.domain.model.votes.Vote;
import core.domain.to.VoteTO;
import core.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class VotingServiceImpl implements VotingService {

    private final VotingDAO votingDAO;

    @Autowired
    public VotingServiceImpl(VotingDAO votingDAO) {
        this.votingDAO = votingDAO;
    }

    @Override
    public boolean vote(int id) throws NotFoundException {
        return votingDAO.vote(id);
    }

    @Override
    public List<VoteTO> getVotesForToday() {
        return votingDAO.getVotesForToday();
    }

    @Override
    public List<VoteTO> getAllVotes() {
        return votingDAO.getAllVotes();
    }
}
