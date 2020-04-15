package dev.vanovertech.pluralsight.creational.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CreditCardFactory creditCardFactory = CreditCardFactory.getCreditCardFactory(700);
        CreditCard card = creditCardFactory.getCreditCard(CardType.PLATINUM);
        System.out.println(card.getClass());

        CreditCardFactory creditCardFactory2 = CreditCardFactory.getCreditCardFactory(600);
        CreditCard card2 = creditCardFactory2.getCreditCard(CardType.GOLD);
        System.out.println(card2.getClass());
    }
}
