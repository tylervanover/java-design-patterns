package dev.vanovertech.pluralsight.structural.adapter;

public class EmployeeAdapaterLdap implements Employee {

    private EmployeeLdap instance;

    public EmployeeAdapaterLdap(EmployeeLdap instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return instance.getCn();
    }

    @Override
    public String getFamilyName() {
        return instance.getSurname();
    }

    @Override
    public String getGivenName() {
        return instance.getGivenName();
    }

    @Override
    public String getEmail() {
        return instance.getMail();
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
