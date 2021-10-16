package lesson1;

public class HomeWorkApp {
    public static void main(String[] args) { // task 1
        printThreeWords();  // task 2
        checkSumSign();  // task 3
        printColor();  // task 4
        compareNumbers();  // task 5
    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign() {
        int a = 2;
        int b = 3;
        int sum = a + b;
        if(sum >= 0){
            System.out.println("Сумма положительная");
        }else{
            System.out.println("Сумма отрицательная");
        }
    }

    static void printColor() {
        int value = 0;
        if(value <= 0){
            System.out.println("Красный");
        }else if(value > 0 && value <= 100){
            System.out.println("Желтый");
        }else{
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 1;
        int b = 15;
        if(a >= b){
            System.out.println("a >= b");
        }else{
            System.out.println("a < b");
        }
    }
}
