package lesson6;

public class Dog extends Animal {

    private static int dogsCount = 0;

    public Dog(String name, int maxRunningDistance, int maxSwimmingDistance) {
        super(name, maxRunningDistance, maxSwimmingDistance);
        dogsCount++;
    }

    public Dog(String name) {
        this(name, 500, 10);
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}
