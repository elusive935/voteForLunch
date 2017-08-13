package core.web;

import core.domain.model.votes.Vote;
import core.domain.to.VoteTO;
import core.service.voting.VotingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static core.web.VotingController.REST_URL;

@RestController
@RequestMapping(value = REST_URL)
public final class VotingController {
    static final String REST_URL = "/votes";
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final VotingService service;

    @Autowired
    private ExceptionInfoHandler exceptionInfoHandler;

    @Autowired
    public VotingController(VotingService service) {
        this.service = service;
    }

    @PostMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean vote(@PathVariable int id) {
        LOG.info("user voted for restaurant {}", id);
        return service.vote(id);
    }

    @GetMapping
    public List<VoteTO> getVotesForToday(){
        LOG.info("get all votes for today");
        return service.getVotesForToday();
    }

    @GetMapping(value="/all")
    public List<VoteTO> getAllVotes(){
        LOG.info("get all votes (history)");
        return service.getAllVotes();
    }

    //    @ExceptionHandler(NotFoundException.class)
//    public void anyException(HttpServletRequest req, Exception e) {
//        exceptionInfoHandler.handleError(req, e);
//    }

}
