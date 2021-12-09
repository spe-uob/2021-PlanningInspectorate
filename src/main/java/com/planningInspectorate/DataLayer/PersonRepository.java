package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Modifying
    @Query(value="UPDATE Person " +
            "SET email = ?, method = ?, name = ? " +
            "WHERE id = ?",
            nativeQuery = true)
    boolean updatePerson(String email, String method, String name, Long id);

    @Modifying
    @Query(value = "INSERT INTO Person (name, method, email) " +
            "VALUES (?, ?, ?);",
            nativeQuery = true)
    void addPers(String name, String method, String email);

    @Query(value = "SELECT id FROM Person WHERE name = ? AND method = ? AND email = ?", nativeQuery = true)
    List<String> getPerson(String name, String contactMethod, String email);
}
