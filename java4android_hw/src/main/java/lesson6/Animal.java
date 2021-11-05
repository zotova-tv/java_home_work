package lesson6;

public abstract class Animal {
    private String name;

    private static int animalsCount = 0;

    final private int maxRunningDistance;
    final private int maxSwimmingDistance;

    public Animal(String name, int maxRunningDistance, int maxSwimmingDistance) {
        this.name = name;
        this.maxRunningDistance = maxRunningDistance;
        this.maxSwimmingDistance = maxSwimmingDistance;
        animalsCount++;
    }

    public boolean swim(int distance){
        return distance > 0 && distance <= maxSwimmingDistance;
    }

    public boolean run(int distance){
        return distance > 0 && distance <= maxRunningDistance;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

    public String getName() {
        return name;
    }
}
