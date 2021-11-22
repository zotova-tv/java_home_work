package lesson10;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box<Apple> boxOfApples1 = new Box<>(10);
        boxOfApples1.add(new Apple());
        boxOfApples1.add(new Apple());
        boxOfApples1.add(new Apple(1.2f), new Apple(1.3f));
        boxOfApples1.add(new Apple(), new Apple());
        boxOfApples1.add(new Apple());
        boxOfApples1.add(new Apple());

        System.out.println(boxOfApples1);
        System.out.println("Weight: " + boxOfApples1.getWeight());

        Box<Apple> boxOfApples2 = new Box<>(20);
        System.out.println("1" + boxOfApples1 + " weight: " + boxOfApples1.getWeight());
        System.out.println("2" + boxOfApples2 + " weight: " + boxOfApples2.getWeight());
        System.out.println();
        boxOfApples2.getAllFruitsFromOtherBox(boxOfApples1);
        System.out.println("1" + boxOfApples1 + " weight: " + boxOfApples1.getWeight());
        System.out.println("2" + boxOfApples2 + " weight: " + boxOfApples2.getWeight());

        boxOfApples2.exchange(4, 5);
        System.out.println("2" + boxOfApples2 + " weight: " + boxOfApples2.getWeight());
        // boxOfApples2.exchange(4, 12);

        System.out.println("1Box " + Arrays.toString(boxOfApples1.getData()));
        System.out.println("2Box " + Arrays.toString(boxOfApples2.getData()));

        Box<Apple> boxOfApples3 = new Box<>(10);
        boxOfApples3.add(
                new Apple(),
                new Apple(),
                new Apple()
        );

        Box<Orange> boxOfOranges = new Box<>(15);
        boxOfOranges.add(
                new Orange(),
                new Orange()
        );

        System.out.println(String.format("boxOfApples3 (weight: %.1f) is equal in weight boxOfOrange (weight: %.1f): %s", boxOfApples3.getWeight(), boxOfOranges.getWeight(), (boxOfApples3.compare(boxOfOranges) ? "true" : "false")));
        System.out.println(String.format("boxOfApples2 (weight: %.1f) is equal in weight boxOfOrange (weight: %.1f): %s", boxOfApples2.getWeight(), boxOfOranges.getWeight(), (boxOfApples2.compare(boxOfOranges) ? "true" : "false")));
    }

}
