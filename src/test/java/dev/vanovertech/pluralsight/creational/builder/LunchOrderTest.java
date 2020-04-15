package dev.vanovertech.pluralsight.creational.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * A class that tests the {@link LunchOrder} class (which uses the Builder Pattern)
 */
public class LunchOrderTest {

    private LunchOrder.Builder builder;

    private static final String BREAD = "Wheat";
    private static final String CONDIMENTS = "Lettuce";
    private static final String DRESSING = "Mustard";
    private static final String MEAT = "Ham";
    private static final String MEAT_2 = "Chicken";
    private static final String MEAT_3 = "Turkey";

    /**
     * Runs once before each test.
     */
    @BeforeEach
    public void setUp() {
        builder = new LunchOrder.Builder();
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} creates a {@link LunchOrder}
     * without any chained arguments
     */
    @Test
    @DisplayName("Builder builds LunchOrder without any arguments")
    public void test_builderCreatesLunchOrder_withZeroArguments() {
        LunchOrder lunchOrder = builder.build();
        assertThat(lunchOrder.getBread(), is(nullValue()));
        assertThat(lunchOrder.getCondiments(), is(nullValue()));
        assertThat(lunchOrder.getDressing(), is(nullValue()));
        assertThat(lunchOrder.getMeat(), is(nullValue()));
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} creates a {@link LunchOrder}
     * when given just the {@link LunchOrder.Builder#bread(String)}
     */
    @Test
    @DisplayName("Builder builds LunchOrder with just Bread")
    public void test_builderCreatesLunchOrder_withOnlyBread() {
        builder.bread(BREAD);
        LunchOrder lunchOrder = builder.build();
        assertThat(lunchOrder.getBread(), is(BREAD));
        assertThat(lunchOrder.getCondiments(), is(nullValue()));
        assertThat(lunchOrder.getDressing(), is(nullValue()));
        assertThat(lunchOrder.getMeat(), is(nullValue()));
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} creates a {@link LunchOrder}
     * when given just the {@link LunchOrder.Builder#condiments(String)}
     */
    @Test
    @DisplayName("Builder builds LunchOrder with just Condiments")
    public void test_builderCreatesLunchOrder_withOnlyCondiments() {
        builder.condiments(CONDIMENTS);
        LunchOrder lunchOrder = builder.build();
        assertThat(lunchOrder.getBread(), is(nullValue()));
        assertThat(lunchOrder.getCondiments(), is(CONDIMENTS));
        assertThat(lunchOrder.getDressing(), is(nullValue()));
        assertThat(lunchOrder.getMeat(), is(nullValue()));
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} creates a {@link LunchOrder}
     * when given just the {@link LunchOrder.Builder#dressing(String)}
     */
    @Test
    @DisplayName("Builder builds LunchOrder with just Dressing")
    public void test_builderCreatesLunchOrder_withOnlyDressing() {
        builder.dressing(DRESSING);
        LunchOrder lunchOrder = builder.build();
        assertThat(lunchOrder.getBread(), is(nullValue()));
        assertThat(lunchOrder.getCondiments(), is(nullValue()));
        assertThat(lunchOrder.getDressing(), is(DRESSING));
        assertThat(lunchOrder.getMeat(), is(nullValue()));
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} creates a {@link LunchOrder}
     * when given just the {@link LunchOrder.Builder#meat(String)}
     */
    @Test
    @DisplayName("Builder builds LunchOrder with just Meat")
    public void test_builderCreatesLunchOrder_withOnlyMeat() {
        builder.meat(MEAT);
        LunchOrder lunchOrder = builder.build();
        assertThat(lunchOrder.getBread(), is(nullValue()));
        assertThat(lunchOrder.getCondiments(), is(nullValue()));
        assertThat(lunchOrder.getDressing(), is(nullValue()));
        assertThat(lunchOrder.getMeat(), is(MEAT));
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} creates a {@link LunchOrder}
     * when given a combination of the {@link LunchOrder.Builder#meat(String)}
     * and the {@link LunchOrder.Builder#bread(String)}
     */
    @Test
    @DisplayName("Builder builds LunchOrder with just mixture of Bread and Meat")
    public void test_builderCreatesLunchOrder_withOnlyBreadAndMeat() {
        builder.bread(BREAD).meat(MEAT);
        LunchOrder lunchOrder = builder.build();
        assertThat(lunchOrder.getBread(), is(BREAD));
        assertThat(lunchOrder.getCondiments(), is(nullValue()));
        assertThat(lunchOrder.getDressing(), is(nullValue()));
        assertThat(lunchOrder.getMeat(), is(MEAT));
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} creates a {@link LunchOrder}
     * with the same property values when two values are used in a different order.
     *
     * For example, calling builder.bread(x).meat(y) vs
     *              calling builder.meat(y).bread(x)
     */
    @Test
    @DisplayName("LunchOrder.Builder's properties are commutative for different members")
    public void test_builderProperties_areCommutative() {
        builder.bread(BREAD).meat(MEAT);
        LunchOrder orderOne = builder.build();

        builder = new LunchOrder.Builder();
        builder.meat(MEAT).bread(BREAD);
        LunchOrder orderTwo = builder.build();

        assertThat(orderOne.getMeat(), is(orderTwo.getMeat()));
        assertThat(orderOne.getBread(), is(orderTwo.getBread()));
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} creates a {@link LunchOrder}
     * with the last value given when the same property is used in sequence.
     *
     * For example, calling builder.meat("1").meat("2").meat("3")
     * Should result in the final {@link LunchOrder#getMeat()} returning "3"
     */
    @Test
    @DisplayName("LunchOrder.Builder's properties are sequential for the same member")
    public void test_builderProperties_areSequential() {
        builder.meat(MEAT).meat(MEAT_2).meat(MEAT_3);
        LunchOrder lunchOrder = builder.build();

        assertThat(lunchOrder.getMeat(), is(MEAT_3));
    }

    /**
     * Tests that the {@link LunchOrder.Builder#build()} does not have any
     * accessible Setters.
     * <p>
     *     NOTE: This assumes the setters are named according to standard Java naming conventions.
     * </p>
     */
    @Test
    @DisplayName("LunchOrder.Builder produces immutable Lunch Order")
    public void test_builderObject_isImmutable() {
        builder.meat(MEAT).bread(BREAD).dressing(DRESSING).condiments(CONDIMENTS);
        LunchOrder lunchOrder = builder.build();

        final List<Method> methods = Arrays.asList(LunchOrder.class.getDeclaredMethods());
        boolean b = true;
        for (Method m : methods) {
            if (m.getName().startsWith("set")
                    && m.getParameterCount() == 1) {
                b = false;
                break;
            }
        }
        assertThat(b, is(true));
    }
}
