package org.oreilly.com.spring_and_spring_boot_course.services;

import org.junit.jupiter.api.Test;
import org.oreilly.com.spring_and_spring_boot_course.json.AstroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AstroServiceTest {

    @Autowired
    private AstroService service;


    @Test
    void getPeopleInSpace() {
        String people = service.getPeopleInSpace();
        assertTrue(people.contains("people"));
        System.out.println(people);
    }

    @Test
    void getAstroResponse() {
        var response = service.getAstroResponse();
        assertEquals("success", response.message());
        assertTrue(response.number() >= 0);
        assertEquals(response.people().size(), response.number());
        System.out.println(response);
    }

    @Test
    void getAstroResponseAsync() {
        var response = service.getAstroResponseAsync();
        assertEquals("success", response.message());
        assertTrue(response.number() >= 0);
        assertEquals(response.people().size(), response.number());
        System.out.println(response);
    }
}