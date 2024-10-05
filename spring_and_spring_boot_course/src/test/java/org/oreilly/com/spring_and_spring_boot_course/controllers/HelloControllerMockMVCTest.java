package org.oreilly.com.spring_and_spring_boot_course.controllers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class HelloControllerMockMVCTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void autowiringWorked() {
        assertNotNull(mvc);
    }

    @Test
    void testHelloWithoutName() throws  Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user", "World"));
    }

    void testHelloWithName() throws  Exception {
        mvc.perform(get("/hello?name=Max"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user", "Max"));
    }
}
