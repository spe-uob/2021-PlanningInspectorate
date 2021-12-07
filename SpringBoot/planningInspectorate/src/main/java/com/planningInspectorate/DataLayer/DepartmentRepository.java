package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value =
            "SELECT Department.name, Organisation.name AS \"Organisation\", Department.test, Department.notes, Person.method, Person.name AS \"Contact\", Person.Email" +
            " FROM Department" +
            "INNER JOIN Organisation ON Organisaiton.Id = Department.Organisaiton_id" +
            "INNER JOIN Contact ON Contact.Department_id = Department.id" +
            "INNER JOIN Person.id = Contact.Person_id" +
            "WHERE Department.name = ?1",
            nativeQuery = true)
    String getRecord(String dept);
}
