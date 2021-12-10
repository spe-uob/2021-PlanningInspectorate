package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

        @Modifying
        @Query(value = "DELETE FROM contact WHERE department_id = ? AND person_id = ?", nativeQuery = true)
        int deleteContactsBy(long departmentId, long personId);

        @Query(value =
                "SELECT Department.organisation_id " +
                        "FROM department, contact " +
                        "WHERE contact.department_id = department.id " +
                        "AND contact.id = ?",
                nativeQuery = true)
        String getOrg(long contactId);

        @Query(value=
                "SELECT department_id FROM contact WHERE id = ?",
                nativeQuery = true)
        String getDept(long contactId);

        @Query(value = "INSERT INTO CONTACT (department_id, person_id, accepted) " +
                "VALUES (?, ?, true)",
                nativeQuery = true)
        boolean insertContact(long deptId, long persId);

        @Query(value =
                "SELECT person_id FROM Contact WHERE id = ?",
                nativeQuery = true)
        String getPerson(long contactId);
}