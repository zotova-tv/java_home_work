package lesson10;

public abstract class Fruit {

    private float weight;
    private String fruitName;

    public Fruit(float weight, String fruitName) {
        this.weight = weight;
        this.fruitName = fruitName;
    }

    public float getWeight(){
        return this.weight;
    }

    @Override
    public String toString() {
        return String.format("%s{" +
                "weight=" + this.weight +
                '}', fruitName);
    }
}
