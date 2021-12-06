package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Object> findAll(String searchTerm);
}
