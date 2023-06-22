package com.smsoft.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/hello/world")
    public String helloWorld(){
        return "hello, world";
    }
}
