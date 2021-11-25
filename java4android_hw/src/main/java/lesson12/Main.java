package lesson12;

public class Main {
    public static void main(String[] args) {
        Calculation calc1 = new Calculation();
        Calculation calc2 = new Calculation();

        System.out.println("method 1".toUpperCase());
        calc1.method1();

        System.out.println("*************************************");
        System.out.println("method 2".toUpperCase());
        try {
            calc2.method2();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
