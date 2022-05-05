package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

        @Modifying
        @Query(value = "DELETE FROM contact " +
                "WHERE department_id = ? " +
                "AND person_id = ?", nativeQuery = true)
        int deleteContactsBy(long departmentId, long personId);

        @Query(value =
                "SELECT Department.organisation_id " +
                        "FROM department, contact " +
                        "WHERE contact.department_id = department.id " +
                        "AND contact.id = ?",
                nativeQuery = true)
        String getOrg(long contactId);

        @Query(value=
                "SELECT department_id " +
                        "FROM contact " +
                        "WHERE id = ?",
                nativeQuery = true)
        String getDept(long contactId);

        @Query(value = "INSERT INTO CONTACT (department_id, person_id, accepted) " +
                "VALUES (?, ?, true)",
                nativeQuery = true)
        boolean insertContact(long deptId, long persId);

        @Transactional
        @Modifying
        @Query(value="UPDATE Contact " +
                "SET otp = ? " +
                "WHERE id = ?",
                nativeQuery = true)
        int addOtp(String otp, Long id);

        @Query(value= "SELECT * " +
                "FROM Contact " +
                "WHERE otp = ?",
        nativeQuery = true)
        List<List<String>> getOtpRow(String pin);

        @Query(value =
                "SELECT person_id " +
                        "FROM Contact " +
                        "WHERE id = ?",
                nativeQuery = true)
        String getPerson(long contactId);


}