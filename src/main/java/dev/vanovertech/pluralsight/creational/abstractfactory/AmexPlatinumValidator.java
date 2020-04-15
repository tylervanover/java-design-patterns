package dev.vanovertech.pluralsight.creational.abstractfactory;

public class AmexPlatinumValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return true;
    }
}
