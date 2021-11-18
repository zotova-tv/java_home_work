package lesson10;

public class Orange extends Fruit {

    public Orange(float weight) {
        super(weight, "Orange");
    }

    public Orange() {
        this(1.5f);
    }
}
