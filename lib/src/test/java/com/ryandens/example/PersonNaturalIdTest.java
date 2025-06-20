package com.ryandens.example;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonNaturalIdTest {

    @Inject
    EntityManager entityManager;

    @Inject
    PersonQueries personQueries;

    @Test
    @TestTransaction
    void testQueryByNaturalIdUsingHQL() {
        // Create and persist a person
        Person person = new Person("testuser", "test@example.com");
        entityManager.persist(person);
        entityManager.flush();

        String savedUuid = person.getId();

        // Query using HQL with natural ID
        Optional<Person> foundPerson = personQueries.getPersonByNaturalId(savedUuid);

        assertTrue(foundPerson.isPresent());
        assertEquals("testuser", foundPerson.get().getUsername());
        assertEquals("test@example.com", foundPerson.get().getEmail());
        assertEquals(savedUuid, foundPerson.get().getId());
    }
}