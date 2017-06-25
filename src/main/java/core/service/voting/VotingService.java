package core.service.voting;

import core.util.NotFoundException;

public interface VotingService {
    boolean vote(int id) throws NotFoundException;
}
