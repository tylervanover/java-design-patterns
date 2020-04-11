package dev.vanovertech.pluralsight.builder;

public class LunchOrderBeanDemo {
    public static void main(String[] args) {
        LunchOrderBean lunchOrderBean = new LunchOrderBean();

        lunchOrderBean.setBread("Wheat");
        lunchOrderBean.setCondiments("Lettuce");
        lunchOrderBean.setDressing("Mustard");
        lunchOrderBean.setMeat("Ham");

        /* I have no defined contract for how to build a LunchOrder Bean
            and the class is mutable. I can directly access members with setters.
            We could try the Telescoping method (LunchOrderTele), but even that has
            drawbacks.
         */

        System.out.println(lunchOrderBean);
    }
}
