Vote for lunch
===============================
**Description**

REST API for voting system

Admins add and update menus of restaurants each day.

Users vote for a restaurant (once a day).
Until 11-00 user can vote again (change his mind).
After 11-00 user's votes won't be taken into consideration.

**Stack of technologies**

Maven/ Spring/ Security/ JPA(Hibernate)/ REST(Jackson)/ Bootstrap(CSS)/ jQuery + plugins

***

**_API usage_**
* Add new restaurant: POST /restaurants
* Replace bulk of restaurants: PUT /restaurants
* Replace a restaurant: PUT /restaurants/id
* Remove all restaurants: DELETE /restaurants
* Remove a restaurant: DELETE /restaurants/id

* Get list of all restaurants: GET /restaurants
* Get sorted list of all restaurants: GET /restaurants?sort=-name, /restaurants?sort=+name
* Get specific fields of the list of: all restaurants GET /restaurants?fields=name,dishname,price,votes
* Get limited list of all restaurants: GET /restaurants?offset=10&limit=5
* Get one restaurant: GET /restaurants/id

* Vote: POST /votes/id

* Register: POST /users
* Update registration: PUT /users/id
* Delete account: DELETE /users/id
* Read account information: GET /users/id

**JSONs**

restaurant = {
    "id": restaurantId,
    "name": "restaurantName",
    "dishes": [
        {
            "id": dishId,
            "name": "dishName",
            "price": dishPrice
        },
        {
        }
    ]
}

user = {
    "id": userId,
    "name": "userName",
    "login": "userLogin",
    "password": "userPassword"
}

***

**Application Usage**
