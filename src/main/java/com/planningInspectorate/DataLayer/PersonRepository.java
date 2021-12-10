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

    /*@Transactional()
    @Modifying
    @Query("update Person p set p.email = :email, p.method = :method, p.name = :name where p.id = :id")
    void updatePerson(@Param("email") String email, @Param("method") String method, @Param("name") String name, @Param("id") long id);*/

    @Modifying
    @Query(value = "INSERT INTO Person (name, method, email) " +
            "VALUES (?, ?, ?);",
            nativeQuery = true)
    void addPers(String name, String method, String email);

    @Query(value = "SELECT id FROM Person WHERE name = ? AND method = ? AND email = ?", nativeQuery = true)
    List<String> getPerson(String name, String contactMethod, String email);
}
