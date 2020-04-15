package dev.vanovertech.pluralsight.creational.abstractfactory;

public class VisaValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return true;
    }
}
