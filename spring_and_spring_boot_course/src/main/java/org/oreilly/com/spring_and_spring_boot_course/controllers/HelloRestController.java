package org.oreilly.com.spring_and_spring_boot_course.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/rest")
    public Greeting greet(@RequestParam(defaultValue = "world!") String name) {
        return new Greeting("Hello, " + name + "!");
    }

}


record Greeting(String message)  {} //data holder immutable