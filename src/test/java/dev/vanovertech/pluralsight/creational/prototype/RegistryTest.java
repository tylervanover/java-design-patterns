package dev.vanovertech.pluralsight.creational.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.Matchers.not;

/**
 * A class for testing an {@link Item} {@link Registry}
 */
public class RegistryTest {

    private Registry registry;

    private final String MOVIE_TITLE = "New Movie Title";
    private final String BOOK_TITLE = "New Book Title";
    private final String PROTOTYPED_MOVIE_TITLE = "Basic Movie";
    private final String PROTOTYPED_BOOK_TITLE = "Darth Plagueis";
    private final String RUNTIME = "88 minutes";
    private final String PROTOTYPED_RUNTIME = "120 minutes";
    private final double MOVIE_PRICE = 19.99;
    private final double BOOK_PRICE = 14.95;
    private final double PROTOTYPED_MOVIE_PRICE = 24.99;
    private final double PROTOTYPED_BOOK_PRICE = 7.77;
    private final int PAGES = 100;
    private final int PROTOTYPED_PAGES = 496;

    /**
     * Runs once before each test
     */
    @BeforeEach
    public void setUp() {
        registry = new Registry();
    }

    @Test
    @DisplayName("Registry constructor populates prototyped Items")
    public void test_registryConstructor_loadsPrototypes() {
        int sizeOfRegistry = registry.size();
        assertThat(sizeOfRegistry, is(2));
    }

    @Test
    @DisplayName("Registry constructor creates one Book and one Movie")
    public void test_registryConstructor_loadsOneBookAndOneMovie() {
        Book book = (Book) registry.getItemPrototype("Book");
        Movie movie = (Movie) registry.getItemPrototype("Movie");

        assertThat(book, is(notNullValue()));
        assertThat(movie, is(notNullValue()));
    }

    @Test
    @DisplayName("Registry getItemPrototype returns null on no hit")
    public void test_registryConstructor_returnsNullWhenNoMatchingItem() {
        Book book = (Book) registry.getItemPrototype("Berk");
        assertThat(book, is(nullValue()));
    }

    @Test
    @DisplayName("Registry's default Book and Movie have default traits set")
    public void test_registryItems_haveDefaultValues() {
        Book book = (Book) registry.getItemPrototype("Book");
        Movie movie = (Movie) registry.getItemPrototype("Movie");

        assertThat(book.getNumberOfPages(), is(PROTOTYPED_PAGES));
        assertThat(book.getPrice(), is(PROTOTYPED_BOOK_PRICE));
        assertThat(book.getTitle(), is(PROTOTYPED_BOOK_TITLE));

        assertThat(movie.getRuntime(), is(PROTOTYPED_RUNTIME));
        assertThat(movie.getPrice(), is(PROTOTYPED_MOVIE_PRICE));
        assertThat(movie.getTitle(), is(PROTOTYPED_MOVIE_TITLE));
    }

    @Test
    @DisplayName("Registry's createItem() Deep Copies Book object")
    public void test_createItem_returnsBookDeepCopy() {
        Book book1 = (Book) registry.getItemPrototype("Book");
        Book book2 = (Book) registry.createItem("Book");

        assertThat(book1, not(book2));
        assertThat(book2.getNumberOfPages(), is(PROTOTYPED_PAGES));

        book2.setNumberOfPages(PAGES);
        book2.setTitle(BOOK_TITLE);
        book2.setPrice(BOOK_PRICE);

        assertThat(book1.getNumberOfPages(), is(PROTOTYPED_PAGES));
        assertThat(book1.getPrice(), is(PROTOTYPED_BOOK_PRICE));
        assertThat(book1.getTitle(), is(PROTOTYPED_BOOK_TITLE));

        assertThat(book2.getNumberOfPages(), is(PAGES));
        assertThat(book2.getPrice(), is(BOOK_PRICE));
        assertThat(book2.getTitle(), is(BOOK_TITLE));
    }

    @Test
    @DisplayName("Registry's createItem() Deep Copies Movie object")
    public void test_createItem_returnsMovieDeepCopy() {
        Movie movie1 = (Movie) registry.getItemPrototype("Movie");
        Movie movie2 = (Movie) registry.createItem("Movie");

        assertThat(movie1, not(movie2));
        assertThat(movie2.getRuntime(), is(PROTOTYPED_RUNTIME));

        movie2.setRuntime(RUNTIME);
        movie2.setTitle(MOVIE_TITLE);
        movie2.setPrice(MOVIE_PRICE);

        assertThat(movie1.getRuntime(), is(PROTOTYPED_RUNTIME));
        assertThat(movie1.getPrice(), is(PROTOTYPED_MOVIE_PRICE));
        assertThat(movie1.getTitle(), is(PROTOTYPED_MOVIE_TITLE));

        assertThat(movie2.getRuntime(), is(RUNTIME));
        assertThat(movie2.getPrice(), is(MOVIE_PRICE));
        assertThat(movie2.getTitle(), is(MOVIE_TITLE));
    }
}
