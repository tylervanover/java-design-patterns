package dev.vanovertech.pluralsight.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeNaiveDemo {
    public static void main(String[] args) {
        String sql = "select * from movies where title = ?";

        List<String> parameters = new ArrayList<>();
        parameters.add("Star Wars");

        Record record = new Record();

        Statement firstStatement = new Statement(sql, parameters, record);
        System.out.println(firstStatement.getSql());
        System.out.println(firstStatement.getParameters());
        System.out.println(firstStatement.getRecord());

        /**
         * This is a dangerous copy because we're "shallow" copying. If we made a change to
         * the properties in the secondStatement, we will also reflect those changes in
         * firstStatement. This could be extremely hazardous in production code.
         */
        Statement secondStatement = firstStatement.clone();
        System.out.println(secondStatement.getSql());
        System.out.println(secondStatement.getParameters());
        System.out.println(secondStatement.getRecord());
    }
}
