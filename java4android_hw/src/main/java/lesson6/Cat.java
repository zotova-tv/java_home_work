package lesson6;

public class Cat extends Animal {

    private static int catsCount = 0;

    public Cat(String name, int maxRunningDistance) {
        super(name, maxRunningDistance, 0);
        catsCount++;
    }

    public Cat(String name) {
        this(name, 200);
    }

    public static int getCatsCount() {
        return catsCount;
    }
}
