package dev.vanovertech.pluralsight.creational.singleton;

public class DbSingletonDemo {

    public static void main(String[] args) {
        DbSingleton singleton = DbSingleton.getInstance();
        DbSingleton singleton2 = DbSingleton.getInstance();

        // Compile Error
        // DbSingleton testConstructor = new DbSingleton();

        System.out.println(singleton);
        System.out.println(singleton2);
    }

}
