package org.oreilly.com.spring_and_spring_boot_course.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void autowiringWorked(@LocalServerPort int port) {
        assertNotNull(restTemplate);
        System.out.println("Test server running on port" + port);
    }

    @Test
    void greetWithOutName() {
        Greeting greeting = restTemplate.getForObject("/rest", Greeting.class);
        assertNotNull(greeting);
        assertEquals("Hello, World!", greeting.message());
    }
    @Test
    void greetWithName() {
        ResponseEntity<Greeting> response =
                restTemplate.getForEntity(
                        "/rest?name={name}", Greeting.class, "Mokhammad"
                );

        assertAll(
                () -> assertTrue(response.getStatusCode().is2xxSuccessful()),
                () -> assertEquals(MediaType.APPLICATION_JSON,
                response.getHeaders().getContentType()),
                () -> assertEquals("Hello, Mokhammad!",
                Objects.requireNonNull(response.getBody()).message())
        );
    }
}
