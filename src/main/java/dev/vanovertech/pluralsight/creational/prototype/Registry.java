package dev.vanovertech.pluralsight.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * A basic object for creating a default {@link Item} "prototype" for each
 * concrete implementation.
 */
public class Registry {
    /**
     * The {@link String} Key of this map could or should ultimately be replaced by an {@link Enum} type.
     */
    private Map<String, Item> items = new HashMap<String, Item>();

    public Registry() {
        loadItems();
    }

    public Item createItem (String type) {
        Item item = null;
        try {
            item = (Item) (items.get(type)).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return item;
    }

    public int size() {
        return items.size();
    }

    public Item getItemPrototype(String type) {
        final Item item = items.get(type);
        return item;
    }

    /**
     * Create some basic {@link Item}s and load them into the {@link Registry}.
     */
    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRuntime("120 minutes");
        items.put("Movie", movie);

        Book book = new Book();
        book.setNumberOfPages(496);
        book.setPrice(7.77);
        book.setTitle("Darth Plagueis");
        items.put("Book", book);
    }

}
