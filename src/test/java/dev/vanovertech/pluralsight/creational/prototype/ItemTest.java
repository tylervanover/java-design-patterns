package dev.vanovertech.pluralsight.creational.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Tests for the abstract class {@link Item}
 */
public class ItemTest {

    private final double PRICE = 1.99;
    private final String TITLE = "Title";
    private final String URL = "https://www.example.com";

    @Test
    @DisplayName("Abstract class' methods called from Mock")
    public void givenConcreteMethod_whenMocked_testCorrectBehavior() {
        Item item = Mockito.mock(Item.class, Mockito.CALLS_REAL_METHODS);
        item.setPrice(PRICE);
        item.setTitle(TITLE);
        item.setUrl(URL);

        assertThat(item.getPrice(), is(PRICE));
        assertThat(item.getTitle(), is(TITLE));
        assertThat(item.getUrl(), is(URL));
    }
}
