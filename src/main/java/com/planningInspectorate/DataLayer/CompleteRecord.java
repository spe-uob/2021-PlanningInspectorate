package com.planningInspectorate.DataLayer;

public class CompleteRecord {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String department;
    private String organisationName;
    private String apfpTest;
    private String notes;
    private String contactMethod;
    private String name;
    private String email;

    public CompleteRecord(String id, String department, String organisationName, String apfpTest, String notes, String contactMethod, String name, String email) {
        this.id = id;
        this.department = department;
        this.organisationName = organisationName;
        this.apfpTest = apfpTest;
        this.notes = notes;
        this.contactMethod = contactMethod;
        this.name = name;
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getApfpTest() {
        return apfpTest;
    }

    public void setApfpTest(String apfpTest) {
        this.apfpTest = apfpTest;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
