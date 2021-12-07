package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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


}
