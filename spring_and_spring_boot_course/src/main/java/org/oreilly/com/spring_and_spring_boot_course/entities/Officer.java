package org.oreilly.com.spring_and_spring_boot_course.entities;

public record Officer(Integer id,
                      Rank rank,
                      String firstName,
                      String lastName) {
}
