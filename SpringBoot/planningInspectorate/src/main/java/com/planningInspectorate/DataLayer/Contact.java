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
    private long id;
    private long departmentId; // foreign key - department table
    private long personId; // foreign key - person table
    private boolean accepted;

    public Contact(){}

    // when reading from the database
    public Contact(long id, long departmentId, long personId, boolean accepted) {
        this.id = id;
        this.departmentId = departmentId;
        this.personId = personId;
        this.accepted = accepted;
    }

    // when writing to the database
    public Contact(long departmentId, long personId, boolean accepted) {
        this.departmentId = departmentId;
        this.personId = personId;
        this.accepted = accepted;
    }

    public Contact(long departmentId, long personId) {
        this.departmentId = departmentId;
        this.personId = personId;
        this.accepted = true;
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

    public boolean isAccepted() { return accepted; }

    public void setAccepted(boolean accepted) { this.accepted = accepted; }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", personId=" + personId +
                ", accepted=" + accepted +
                '}';
    }
}
