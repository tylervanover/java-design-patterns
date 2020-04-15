package dev.vanovertech.pluralsight.creational.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A class that tests the {@link DbSingleton class}
 */
public class DbSingletonTest {

    @Test
    @DisplayName("DbSingleton returns same reference on two successive getInstance()")
    public void test_getInstance_returnsSameReference() {
        DbSingleton one = DbSingleton.getInstance();
        DbSingleton two = DbSingleton.getInstance();

        assertThat(one, is(two));
    }

    @Test
    @DisplayName("DbSingleton constructor cannot be accessed via reflection")
    public void test_singletonConstructor_isInaccessible() {
        DbSingleton one = DbSingleton.getInstance();
        assertThrows(InvocationTargetException.class, () -> {
            for (Constructor constructor : DbSingleton.class.getDeclaredConstructors()) {
                constructor.setAccessible(true);
                DbSingleton instance = (DbSingleton) constructor.newInstance();
            }
        });
    }
}
