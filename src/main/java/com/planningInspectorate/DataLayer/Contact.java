package com.planningInspectorate.DataLayer;

import javax.persistence.*;

@Entity(name = "Contact")
public class Contact {
    @Id
    @SequenceGenerator(
            name = "contact_sequence",
            sequenceName = "contact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contact_sequence"
    )
    @Column
    private long id;
    @Column
    private long departmentId; // foreign key - department table
    @Column
    private long personId; // foreign key - person table
    @Column(nullable = true)
    private String otp;

    public Contact(){}

    public Contact(long id, long departmentId, long personId, String otp) {
        this.id = id;
        this.departmentId = departmentId;
        this.personId = personId;
        this.otp = otp;
    }

    // when reading from the database
    public Contact(long id, long departmentId, long personId) {
        this.id = id;
        this.departmentId = departmentId;
        this.personId = personId;
    }

    // when writing to the database
    public Contact(long departmentId, long personId, boolean accepted) {
        this.departmentId = departmentId;
        this.personId = personId;
    }

    public Contact(long departmentId, long personId) {
        this.departmentId = departmentId;
        this.personId = personId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", personId=" + personId +
                ", otp='" + otp + '\'' +
                '}';
    }
}
