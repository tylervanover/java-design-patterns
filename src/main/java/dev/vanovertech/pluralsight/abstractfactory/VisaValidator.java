package dev.vanovertech.pluralsight.abstractfactory;

public class VisaValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return true;
    }
}
