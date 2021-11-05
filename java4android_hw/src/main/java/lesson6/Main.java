package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Marusya");
        Dog dog = new Dog("Barbos");

        System.out.println(cat.getName() + " проплыл(а) 5 м? " + (cat.swim(5) ? "Да" : "Нет"));
        System.out.println(cat.getName() + " пробежал(а) 100 м? " + (cat.run(100) ? "Да" : "Нет"));
        System.out.println(dog.getName() + " проплыл(а) 10 м? " + (cat.swim(10) ? "Да" : "Нет"));
        System.out.println(dog.getName() + " пробежал(а) 200 м? " + (cat.run(200) ? "Да" : "Нет"));

        System.out.println("All animals: " + Animal.getAnimalsCount());
        System.out.println("All cats: " + Cat.getCatsCount());
        System.out.println("All dogs: " + Dog.getDogsCount());
    }
}






