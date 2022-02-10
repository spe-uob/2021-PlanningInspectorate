package com.planningInspectorate.DataLayer;

import javax.persistence.*;

@Entity(name = "Person")
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private long id;
    private String method;
    private String name;
    private String addressBlock; // stored as text rather than varchar
    private String email;
    public Person(){}

    // when reading from the database
    public Person(long id, String method, String name, String addressBlock, String email) {
        this.id = id;
        this.method = method;
        this.name = name;
        this.addressBlock = addressBlock;
        this.email = email;
    }

    // when writing to the database
    /*public Person(String method, String name, String addressBlock, String email) {
        this.method = method;
        this.name = name;
        this.addressBlock = addressBlock;
        this.email = email;
    }*/

    public Person(long id, String method, String name, String email) {
        this.id = id;
        this.method = method;
        this.name = name;
        this.email = email;
    }

    public Person(String method, String name, String email) {
        this.method = method;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() { return method; }

    public void setMethod(String method) { this.method = method; }

    public String getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(String addressBlock) {
        this.addressBlock = addressBlock;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressBlock='" + addressBlock + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
