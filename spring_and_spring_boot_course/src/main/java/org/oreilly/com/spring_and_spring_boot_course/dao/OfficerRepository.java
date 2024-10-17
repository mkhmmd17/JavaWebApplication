package org.oreilly.com.spring_and_spring_boot_course.dao;

import org.oreilly.com.spring_and_spring_boot_course.entities.Officer;
import org.oreilly.com.spring_and_spring_boot_course.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    List<Officer> findAllByLastNameContainingAndRank(String last, Rank rank);
}
