package com.smsoft.review.api;

import com.smsoft.review.api.request.CreateAndEditRestaurantRequest;
import com.smsoft.review.model.RestaurantEntity;
import com.smsoft.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
public class RestaurantApi {
    private final RestaurantService restaurantService;
    @GetMapping("/restaurants")
    public String getRestaurants(){
        return "This is getRestaurants";
    }
    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(@PathVariable Long restaurantId) {
        return "This is getRestaurant, " + restaurantId;
    }

    @PostMapping("/restaurant")
    public RestaurantEntity createRestaurant(@RequestBody CreateAndEditRestaurantRequest request){
        return restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(@PathVariable Long restaurantId, @RequestBody CreateAndEditRestaurantRequest request){
        return "This is createRestaurant, name=" + request.getName() + "address=" + request.getAddress()
                + ", menu[0].name= " + request.getMenus().get(0).getName() + ", menu[0].price = " + request.getMenus().get(0).getPrice();
}

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(@PathVariable Long restaurantId){
        return "This is deleteRestaurant, " + restaurantId;
    }
}
