package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value =
            "SELECT Department.id, Organisation.id AS \"OrgId\", Person.id AS \"PersId\", Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
            "FROM Department, Organisation, Contact, Person " +
            "WHERE Department.organisation_id = Organisation.id " +
            "AND Contact.department_id = Department.id " +
            "AND Person.id = Contact.person_id " +
            "AND Department.name = ?",
            nativeQuery = true)
    List<List<String>> getRecord(String dept);

    @Modifying
    @Query(value =
            "UPDATE Department " +
                    "SET name = ?, notes = ?, organisation_id = ?, test= ? " +
                    "WHERE id = ?",
            nativeQuery = true)
    boolean updateDepartment(String name, String notes, Long orgId, String test, Long deptId);

    @Query(value =
            "SELECT Department.Id " +
                    "FROM Department, Organisation " +
                    "WHERE Department.name = ? " +
                    "AND Organisation.id = ? " +
                    "AND Department.organisation_id = Organisation.id;",
            nativeQuery = true)
    List<String> getByName(String department, Long orgId);

    @Query(value= "INSERT INTO Department (name, organisation_id) VALUES (?, ?);", nativeQuery = true)
    boolean addDept(String department, Long orgId);
}
