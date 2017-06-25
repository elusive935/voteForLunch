package core.web;

import core.service.voting.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static core.web.VotingController.REST_URL;

@RestController
@RequestMapping(value = REST_URL)
public final class VotingController {
    static final String REST_URL = "/votes";

    private final VotingService service;

    @Autowired
    private ExceptionInfoHandler exceptionInfoHandler;

    @Autowired
    public VotingController(VotingService service) {
        this.service = service;
    }

    @PostMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean vote(@PathVariable int id) {
        return service.vote(id);
    }

    //    @ExceptionHandler(NotFoundException.class)
//    public void anyException(HttpServletRequest req, Exception e) {
//        exceptionInfoHandler.handleError(req, e);
//    }

}
