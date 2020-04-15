package dev.vanovertech.pluralsight.structural.adapter;

public class EmployeeAdapterCSV implements Employee {

    private EmployeeCSV instance;

    public EmployeeAdapterCSV(EmployeeCSV instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return String.valueOf(instance.getId());
    }

    @Override
    public String getFamilyName() {
        return instance.getLastName();
    }

    @Override
    public String getGivenName() {
        return instance.getFirstName();
    }

    @Override
    public String getEmail() {
        return instance.getEmailAddress();
    }

    @Override
    public String toString() {
        return "EmployeeLDAP{" +
                "id='" + getId() +
                "', givenName='" + getGivenName() +
                "', familyName='" + getFamilyName() +
                "', email='" + getEmail() +
                "'}";
    }
}
