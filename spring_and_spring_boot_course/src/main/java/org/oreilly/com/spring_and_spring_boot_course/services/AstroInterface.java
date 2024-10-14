package org.oreilly.com.spring_and_spring_boot_course.services;

import org.oreilly.com.spring_and_spring_boot_course.json.AstroResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface AstroInterface {
    @GetExchange("/astros.json")
    AstroResponse getResponse();
}
