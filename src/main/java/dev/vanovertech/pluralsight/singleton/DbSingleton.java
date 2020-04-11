package dev.vanovertech.pluralsight.singleton;

public class DbSingleton {

    private static volatile DbSingleton instance = null;

    private DbSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance static method to create");
        }
    }

    public static DbSingleton getInstance() {
        if (instance == null) {
            synchronized (DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }
}
