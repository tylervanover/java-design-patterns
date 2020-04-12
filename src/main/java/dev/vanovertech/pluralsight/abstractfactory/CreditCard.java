package dev.vanovertech.pluralsight.abstractfactory;

public class CreditCard {

    protected int cardNumberLength;
    protected int cscNumberLength;
    protected int cscNumber;

    public int getCardNumberLength() {
        return cardNumberLength;
    }

    public void setCardNumberLength(int cardNumberLength) {
        this.cardNumberLength = cardNumberLength;
    }

    public int getCscNumberLength() {
        return cscNumberLength;
    }

    public void setCscNumberLength(int cscNumberLength) {
        this.cscNumberLength = cscNumberLength;
    }

    public int getCscNumber() {
        return cscNumber;
    }

    public void setCscNumber(int cscNumber) {
        this.cscNumber = cscNumber;
    }
}
