package dev.vanovertech.pluralsight.creational.prototype;

public abstract class Item implements Cloneable {
    private String title;
    private double price;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Basic clone method extends the Cloneable. The contract must return an {@link Object}
     * , which means we must cast on the calling service. Downside of the basic Clone API
     * is that we have no concept of generics.
     * @return an {@link Object} that was cloned from this one
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
