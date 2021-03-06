package core.web;

import core.domain.model.restaurant.Restaurant;
import core.service.restaurant.RestaurantService;
import core.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static core.web.RestaurantController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    static final String REST_URL = "/restaurants";
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RestaurantService service;

    @Autowired
    private ExceptionInfoHandler exceptionInfoHandler;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant){
        LOG.info("save restaurant {}", restaurant);
        ValidationUtil.checkNew(restaurant);
        Restaurant created = service.save(restaurant);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll(){
        LOG.info("get all restaurants");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable("id") int id){
        LOG.info("get restaurant {}", id);
        return service.get(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<Restaurant> updateBulk(@RequestBody List<Restaurant> restaurants){
        LOG.info("update restaurants {}", restaurants);
        return service.updateBulk(restaurants);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public Restaurant update(@PathVariable("id") int id, @RequestBody Restaurant restaurant){
        LOG.info("update restaurant {} to {}", id, restaurant);
        return service.update(id, restaurant);
    }

    @DeleteMapping
    @Secured("ROLE_ADMIN")
    public void deleteAll(){
        LOG.info("delete all restaurants");
        service.deleteAll();
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public void delete(@PathVariable("id") int id){
        LOG.info("delete restaurant {}", id);
        service.delete(id);
    }

//    @ExceptionHandler(NotFoundException.class)
//    public void anyException(HttpServletRequest req, Exception e) {
//        exceptionInfoHandler.handleError(req, e);
//    }
}













