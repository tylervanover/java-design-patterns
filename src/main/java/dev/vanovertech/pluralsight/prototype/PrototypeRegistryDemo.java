package dev.vanovertech.pluralsight.prototype;

/**
 * A class demoing the functionality of the Registry and Item classes
 * using Java's built in Clone API.
 */
public class PrototypeRegistryDemo {
    public static void main(String[] args) {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("A Few Good Men");
        movie.setRuntime("138 minutes");
        movie.setPrice(12.99);

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getPrice());

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Rock-a-Doodle");
        movie.setRuntime("77 minutes");
        /* Priceless */

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getPrice());
    }
}
