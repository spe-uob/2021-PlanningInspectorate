package com.planningInspectorate.DataLayer;

import javax.persistence.*;

@Entity(name = "Special_Contact")
public class SpecialContact {
    @Id
    @SequenceGenerator(
            name = "special_contact_sequence",
            sequenceName = "special_contact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "special_contact_sequence"
    )
    private long id;
    private long personId; // foreign key - person table
    private long organisationId; // foreign key - organisation table

    public SpecialContact(){}

    // when reading from the database
    public SpecialContact(long id, long personId, long organisationId) {
        this.id = id;
        this.personId = personId;
        this.organisationId = organisationId;
    }

    // when writing to database
    public SpecialContact(long personId, long organisationId) {
        this.personId = personId;
        this.organisationId = organisationId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }

    @Override
    public String toString() {
        return "SpecialContact{" +
                "id=" + id +
                ", personId=" + personId +
                ", organisationId=" + organisationId +
                '}';
    }
}
