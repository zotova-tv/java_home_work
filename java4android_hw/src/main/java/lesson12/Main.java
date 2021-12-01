package lesson12;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Calculation calc1 = new Calculation();
        Calculation calc2 = new Calculation();

        System.out.println("method 1".toUpperCase());
        float[] arr1 = calc1.method1();

        System.out.println("*************************************");
        System.out.println("method 2".toUpperCase());
        float[] arr2;
        try {
            arr2 = calc2.method2();
        }catch(InterruptedException e){
            e.printStackTrace();
            arr2 = new float[0];
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.equals(arr1, arr2));

    }
}
