package lesson10;

public class Apple extends Fruit {

    public Apple(float weight) {
        super(weight, "Apple");
    }

    public Apple() {
        this(1.0f);
    }
}
