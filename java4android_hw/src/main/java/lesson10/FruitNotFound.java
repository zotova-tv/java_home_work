package lesson10;

public class FruitNotFound extends ArrayIndexOutOfBoundsException {
    public FruitNotFound() {
        super("Fruit not found");
    }

    public FruitNotFound(int index) {
        super(String.format("Fruit (Index: %d) not found", index));
    }
}
