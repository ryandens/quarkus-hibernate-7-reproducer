package com.ryandens.example;

import jakarta.persistence.EntityManager;
import java.util.Optional;
import org.hibernate.annotations.processing.HQL;

/** Queries for Person entities. */
interface PersonQueries {

    /**
     * Get a Person by their natural ID (UUID), if present.
     *
     * @param id the person's UUID natural ID
     * @return an {@link Optional} containing the person, if present, or empty otherwise.
     */
    @HQL(
        """
        select p from Person p
        where p.id = :id
        """)
    Optional<Person> getPersonByNaturalId(String id);

    /** needed for JPA */
    @SuppressWarnings("unused")
    EntityManager getEntityManager();
}