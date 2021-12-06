package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Object> findAll(String searchTerm);
}
