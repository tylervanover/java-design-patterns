package dev.vanovertech.pluralsight.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;

/**
 * A class for testing the {@link Book} concrete implementation of {@link Item}
 */
public class BookTest {

    private final int NUMBER_OF_PAGES = 127;
    private final int NUMBER_OF_PAGES_2 = 264;

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book();
    }

    @Test
    @DisplayName("Book pages are default 0 when not set on new()")
    public void test_zeroPages_whenNotSetOnNew() {
        assertThat(book.getNumberOfPages(), is(0));
    }

    @Test
    @DisplayName("Book pages are correct when set and returned by getter")
    public void test_pagesAreCorrect_onSetAndRetrieve() {
        book.setNumberOfPages(NUMBER_OF_PAGES);
        assertThat(book.getNumberOfPages(), is(NUMBER_OF_PAGES));
    }

    @Test
    @DisplayName("Book.clone() returns deep copy")
    public void test_bookClone_isDeepCopy() throws CloneNotSupportedException {
        book.setNumberOfPages(NUMBER_OF_PAGES);
        Book book2 = (Book) (book.clone());
        book2.setNumberOfPages(NUMBER_OF_PAGES_2);

        assertThat(book, not(book2));
        assertThat(book.getNumberOfPages(), not(book2.getNumberOfPages()));
    }

}
