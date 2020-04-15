package dev.vanovertech.pluralsight.creational.factory;

public class WebFactoryDemo {
    public static void main(String[] args) {
        Website siteOne = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        System.out.println(siteOne.getPages());

        Website siteTwo = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        System.out.println(siteTwo.getPages());
    }
}
