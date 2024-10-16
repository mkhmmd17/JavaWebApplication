package org.oreilly.com.spring_and_spring_boot_course.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.oreilly.com.spring_and_spring_boot_course.entities.Officer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaOfficerDao implements OfficerDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Officer save(Officer officer) {
        entityManager.persist(officer);
        return officer;
    }

    @Override
    public Optional<Officer> findById(int id) {
        return Optional.ofNullable(entityManager.find(Officer.class, id));
    }

    @Override
    public List<Officer> findAll() {
        return entityManager.createQuery("select o from Officer o", Officer.class).getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("select count(o.id) from Officer o", Long.class).getSingleResult();
    }

    @Override
    public void delete(Officer officer) {
        entityManager.remove(officer);
    }

    @Override
    public boolean existsByID(Integer id) {
        Long count = entityManager.createQuery(
                "select count(o.id) from Officer o where o.id=:id", Long.class)
                .setParameter("id", id)
                .getSingleResult();

        return count > 0;
    }
}
