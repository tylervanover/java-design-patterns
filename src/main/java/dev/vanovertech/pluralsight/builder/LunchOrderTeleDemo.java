package dev.vanovertech.pluralsight.builder;

public class LunchOrderTeleDemo {
    public static void main(String[] args) {
        LunchOrderTele tele = new LunchOrderTele("White", "Pickle", "Mayo", "Turkey");

        // What if I don't want meat?
        LunchOrderTele noMeat = new LunchOrderTele("Wheat", "Pickle", "Mayo", null);

        System.out.println(tele);
        System.out.println(noMeat);

        // What if I only want bread and dressing?
        LunchOrderTele justBreadAndDressing = new LunchOrderTele("Toast", null, "Cheese", null);

        /* IF I want to arrange different combinations of elements, I either need to build new constructors
            or I am required to place nulls, default values, etc. through my ever growing constructor.
         */
    }
}
