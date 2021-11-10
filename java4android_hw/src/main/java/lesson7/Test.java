package lesson7;


public class Test {

    public static void main(String[] args) throws InterruptedException {

        Plate plate = new Plate(12);

        Cat[] cats = {
                new Cat("Мартин Лютер Кот", 10),
                new Cat("Том", 5),
                new Cat("Матроскин", 7),
        };

        plate.printInfo();

        for (Cat cat : cats) {
            cat.eat(plate);

            if (cat.isFull()) {
                System.out.println(cat.getName() + " наелся... пока...");
            } else {
                System.out.println(cat.getName() + " всё еще голоден и не ручается за своё поведение.");
            }
            // Thread.sleep(3000);
        }
        plate.printInfo();
    }
}