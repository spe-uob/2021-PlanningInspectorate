package com.planningInspectorate.DataLayer;

import javax.persistence.*;

@Entity(name = "Organisation")
public class Organisation {
    @Id
    @SequenceGenerator(
            name = "organisation_sequence",
            sequenceName = "organisation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "organisation_sequence"
    )
    private Long id;
    private String name;
    private Boolean special;

    public Organisation(){}

    // when reading from the database
    public Organisation(Long id, String name, Boolean special) {
        this.id = id;
        this.name = name;
        this.special = special;
    }

    // when writing to the database
    public Organisation(String name, Boolean special) {
        this.name = name;
        this.special = special;
    }

    public Organisation(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSpecial() {
        return special;
    }

    public void setSpecial(Boolean special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", special=" + special +
                '}';
    }
}
