package org.oreilly.com.spring_and_spring_boot_course.json;

import java.util.List;

public record AstroResponse(String message,
                            int number,
                            List<Assignment> people) {

    record Assignment(String craft, String name) {}
}
