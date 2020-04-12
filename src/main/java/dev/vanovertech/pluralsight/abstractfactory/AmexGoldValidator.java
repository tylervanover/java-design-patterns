package dev.vanovertech.pluralsight.abstractfactory;

public class AmexGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return true;
    }
}
