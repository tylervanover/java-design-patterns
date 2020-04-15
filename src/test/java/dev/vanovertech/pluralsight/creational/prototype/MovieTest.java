package dev.vanovertech.pluralsight.creational.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * A class for testing the {@link Movie} concrete implementation of {@link Item}
 */
public class MovieTest {

    private final String RUNTIME = "120 minutes";
    private final String RUNTIME_2 = "88 minutes";

    private Movie movie;

    @BeforeEach
    public void setUp() {
        movie = new Movie();
    }

    @Test
    @DisplayName("Movie runtime is null when not set on new()")
    public void test_nullRuntime_whenNotSetOnNew() {
        assertThat(movie.getRuntime(), is(nullValue()));
    }

    @Test
    @DisplayName("Movie runtime is correct when set and returned by getter")
    public void test_runtimeIsCorrect_onSetAndRetrieve() {
        movie.setRuntime(RUNTIME);
        assertThat(movie.getRuntime(), is(RUNTIME));
    }

    @Test
    @DisplayName("Movie.clone() returns deep copy")
    public void test_movieClone_isDeepCopy() throws CloneNotSupportedException {
        movie.setRuntime(RUNTIME);
        Movie movie2 = (Movie) (movie.clone());
        movie2.setRuntime(RUNTIME_2);

        assertThat(movie, not(movie2));
        assertThat(movie.getRuntime(), not(movie2.getRuntime()));
    }

}
