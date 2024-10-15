package org.oreilly.com.spring_and_spring_boot_course.dao;

import org.oreilly.com.spring_and_spring_boot_course.entities.Officer;

import java.util.List;
import java.util.Optional;

public interface OfficerDAO {
    Officer save(Officer officer);
    Optional<Officer> findById(int id);
    List<Officer> findAll();
    long count();
    void delete(Officer officer);
    boolean existsByID(Integer id);

}
