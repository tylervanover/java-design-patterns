package dev.vanovertech.pluralsight.creational.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {

    protected List<Page> pages = new ArrayList<>();

    public List<Page> getPages() {
        return pages;
    }

    public Website() {
        this.createWebSite();
    }

    public abstract void createWebSite();

}
