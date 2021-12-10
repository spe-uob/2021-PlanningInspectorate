package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
            "FROM Department, Organisation, Contact, Person " +
            "WHERE Department.organisation_id = Organisation.id " +
            "AND Contact.department_id = Department.id " +
            "AND Person.id = Contact.person_id " +
            "AND Department.name = ?",
            nativeQuery = true)
    List<List<String>> getRecord(String dept);

    @Transactional
    @Modifying
    @Query(value =
            "UPDATE Department " +
                    "SET name = ?, notes = ?, organisation_id = ?, test= ? " +
                    "WHERE id = ?",
            nativeQuery = true)
    int updateDepartment(String name, String notes, Long orgId, String test, Long deptId);

    /*@Transactional
    @Modifying
    @Query("update Department dep set dep.name = :name, dep.notes = :notes, dep.organisationId = :orgId, dep.test = :test where dep.id = :id")
    void updateDepartment(@Param("name") String name, @Param("notes") String notes, @Param("organisationId") Long orgId, @Param("test") String test, @Param("id") Long id);*/

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
