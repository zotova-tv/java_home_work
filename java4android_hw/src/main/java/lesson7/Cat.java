package lesson7;

import java.util.Random;
import java.util.Scanner;

public class Cat {

    private String name;
    private int appetite;

    Scanner scanner = new Scanner(System.in);

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        int decreaseFoodCount = plate.decreaseFood(this.appetite);
        this.appetite -= decreaseFoodCount;
        if (this.appetite > 0) {
            if (askForMore(plate)) {
                plate.addFood(this.appetite);
                this.eat(plate);
            }
        }
    }

    private boolean askForMore(Plate plate) {
        System.out.println("Мяу!!! (Перевод: " + this.name + " голоден! Требует срочно добавить в тарелку " + this.appetite + " кусочков.)");
        System.out.println("Добавить? y/n");
        switch (scanner.next()) {
            case "y", "yes", "ok", "да" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public boolean isFull() {
        return this.appetite == 0;
    }

    public String getName() {
        return name;
    }


}
