package com.planningInspectorate.Tables;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Special_Contact")
public class SpecialContact {
    @Id
    private long id;
    private long personId;
    private long organisationId;

    public SpecialContact(){}

    public SpecialContact(long id, long personId, long organisationId) {
        this.id = id;
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
