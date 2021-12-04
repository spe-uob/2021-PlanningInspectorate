package com.planningInspectorate.DataLayer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Contact")
public class Contact {
    @Id
    private long id;
    private long departmentId;
    private long personId;

    public Contact(){}

    public Contact(long id, long departmentId, long personId) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", personId=" + personId +
                '}';
    }
}
