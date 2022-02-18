package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Transactional
    @Modifying
    @Query(value="UPDATE Person " +
            "SET email = ?, method = ?, name = ? " +
            "WHERE id = ?",
            nativeQuery = true)
    int updatePerson(String email, String method, String name, Long id);

    @Modifying
    @Query(value = "INSERT INTO Person (name, method, email) " +
            "VALUES (?, ?, ?);",
            nativeQuery = true)
    void addPers(String name, String method, String email);

    @Query(value = "SELECT id FROM Person WHERE name = ? AND method = ? AND email = ?", nativeQuery = true)
    List<String> getPerson(String name, String contactMethod, String email);

    @Query(value = "SELECT * FROM Person WHERE id = ?", nativeQuery = true)
    List<String> getPersonInfo(Long id);
}
