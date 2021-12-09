package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

        @Query(value = "DELETE FROM contact WHERE department_id = ? AND person_id = ?", nativeQuery = true)
        void deleteContactsBy(long departmentId, long personId);

        @Query(value = "INSERT INTO CONTACT (department_id, person_id, accepted) " +
                "VALUES (?, ?, true)",
                nativeQuery = true)
        boolean insertContact(long deptId, long persId);
}