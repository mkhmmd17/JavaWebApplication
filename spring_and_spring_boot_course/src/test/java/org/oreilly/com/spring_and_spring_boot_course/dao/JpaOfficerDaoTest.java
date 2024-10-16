package org.oreilly.com.spring_and_spring_boot_course.dao;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.oreilly.com.spring_and_spring_boot_course.entities.Officer;
import org.oreilly.com.spring_and_spring_boot_course.entities.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaOfficerDaoTest {

    @Autowired
    private JpaOfficerDao dao;

    @Autowired
    private JdbcTemplate template;

    private List<Integer> ids() {
        return template.query("select id from officers",
                (rs, num) -> rs.getInt("id"));
    }

    @Test
    void save() {
        Officer officer = new Officer(null, Rank.ENSIGN, "WESLEY", "CRUSHER");
        officer = dao.save(officer);
        assertNotNull(officer.getId());
    }

    @Test
    void findByIdExists() {
        ids().forEach(id -> {
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            assertEquals(id, officer.get().getId());
        });
    }

    @Test
    void findByIdThatDoesNotExist() {
        assertThat(ids()).doesNotContain(999);
        Optional<Officer> officer = dao.findById(999);
        assertFalse(officer.isPresent());
    }

    @Test
    void count() {
        assertEquals(ids().size(), dao.count());
    }

    @Test
    void findAll() {
        List<String> dbNames = dao.findAll().stream()
                .map(Officer::getLastName)
                .toList();
        assertThat(dbNames).containsAll(List.of(
                "KIRK", "WYNNE", "BRAUNAGEL","YAN","FONSECA","KIRK","BABARURAM", "MAC"));
    }

    @Test
    void delete() {
        ids().forEach(id -> {
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            dao.delete(officer.get());
        });
        assertEquals(0, dao.count());
    }

    @Test
    void existsByID() {
        ids().forEach(id -> assertTrue(dao.existsByID(id)));
    }
}