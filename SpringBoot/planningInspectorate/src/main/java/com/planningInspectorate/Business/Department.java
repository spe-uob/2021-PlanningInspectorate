package com.planningInspectorate.Business;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Department")
public class Department {
    @Id
    private long id;
    private long organisationId;
    private String name;
    private String test;
    private String notes;
    private String location;

    public Department(){}

    public Department(long id,
                      long organisationId,
                      String name,
                      String test,
                      String notes,
                      String location) {
        this.id = id;
        this.organisationId = organisationId;
        this.name = name;
        this.test = test;
        this.notes = notes;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", organisationId=" + organisationId +
                ", name='" + name + '\'' +
                ", test='" + test + '\'' +
                ", notes='" + notes + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
