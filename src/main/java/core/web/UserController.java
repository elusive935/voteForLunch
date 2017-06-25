package core.web;

import core.domain.model.user.User;
import core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static core.web.UserController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public final class UserController {
    static final String REST_URL = "/users";

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }

}
