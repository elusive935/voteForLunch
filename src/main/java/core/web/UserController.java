package core.web;

import core.domain.model.user.User;
import core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static core.web.UserController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public final class UserController {
    static final String REST_URL = "/users";
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user){
        LOG.info("save user {}", user);
        return service.save(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id){
        LOG.info("get user {}", id);
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        LOG.info("delete user {}", id);
        return service.delete(id);
    }

}
