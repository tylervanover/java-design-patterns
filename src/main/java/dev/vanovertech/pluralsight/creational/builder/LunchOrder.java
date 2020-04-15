package dev.vanovertech.pluralsight.creational.builder;

/**
 * A class to define a LunchOrder. Uses the builder pattern to give a flexible contract.
 * Makes the class immutable to all except the builder.
 */
public class LunchOrder {

    /**
     * A Builder class that is responsible for creating a {@link LunchOrder}.
     * Controls the contract of "constructor" arguments using the BuilderPattern.
     */
    public static class Builder {
        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        public Builder() {}

        public LunchOrder build() {
            return new LunchOrder(this);
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }
    }

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    /**
     * Private constructor, only accessible via the {@link Builder} class.
     * @param builder The {@link Builder} responsible for creating the immutable {@link LunchOrder}.
     */
    private LunchOrder(Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

    @Override
    public String toString() {
        return "LunchOrder{" +
                "bread='" + bread + '\'' +
                ", condiments='" + condiments + '\'' +
                ", dressing='" + dressing + '\'' +
                ", meat='" + meat + '\'' +
                '}';
    }
}
