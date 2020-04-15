package dev.vanovertech.pluralsight.structural.adapter;

import java.util.List;

public class EmployeeDB implements Employee {

    private String id;
    private String givenName;
    private String familyName;
    private String email;

    public EmployeeDB(String id, String givenName, String familyName, String email) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "EmployeeDB{" +
                "id='" + id + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
