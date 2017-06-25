package core.web;

import core.domain.model.restaurant.Restaurant;
import core.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static core.web.RestaurantController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public final class RestaurantController {
    static final String REST_URL = "/restaurants";

    private final RestaurantService service;

    @Autowired
    private ExceptionInfoHandler exceptionInfoHandler;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant){
//        checkNew
        Restaurant created = service.save(restaurant);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable("id") int id){
        return service.get(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> updateBulk(@RequestBody List<Restaurant> restaurants){
        return service.updateBulk(restaurants);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant update(@PathVariable("id") int id, @RequestBody Restaurant restaurant){
        return service.update(id, restaurant);
    }

    @DeleteMapping
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }

//    @ExceptionHandler(NotFoundException.class)
//    public void anyException(HttpServletRequest req, Exception e) {
//        exceptionInfoHandler.handleError(req, e);
//    }
}













