package dev.vanovertech.pluralsight.creational.factory;

public class Shop extends Website {

    @Override
    public void createWebSite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }
}
