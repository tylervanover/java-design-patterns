package dev.vanovertech.pluralsight.creational.abstractfactory;

public class AmexGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return true;
    }
}
