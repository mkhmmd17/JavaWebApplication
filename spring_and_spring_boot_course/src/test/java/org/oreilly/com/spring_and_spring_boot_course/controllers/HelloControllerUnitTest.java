package org.oreilly.com.spring_and_spring_boot_course.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;
class HelloControllerUnitTest {
  @Test
    void sayHello() {
      HelloController controller = new HelloController();
      Model model = new BindingAwareModelMap();
      String result = controller.sayHello("Dolly", model);
      assertAll(
              () -> assertEquals("welcome", result),
              () -> assertEquals("Dolly", model.getAttribute("user"))
      );
  }
}