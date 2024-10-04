package org.oreilly.com.spring_and_spring_boot_course.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello") // maps to http://localhost:8080/hello?name=Dolly
    public String sayHello(@RequestParam(defaultValue = "World") String name, Model model) {
        model.addAttribute("user", name);
        return "welcome"; //forward to /src/main/rescources/templats/welcome.html
    }
}
