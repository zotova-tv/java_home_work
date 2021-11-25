package lesson12;

import java.util.Arrays;

public class Calculation {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];

    public void method1() {
        setOne();
        long startTime = System.currentTimeMillis();
        calc(arr);
        long endTime = System.currentTimeMillis();
        // System.out.println(Arrays.toString(arr));
        System.out.println("Total time: " + (endTime - startTime));
    }

    public void method2() throws InterruptedException {
        setOne();
        long startTime = System.currentTimeMillis();
        float[] halfArr1 = new float[HALF];
        float[] halfArr2 = new float[HALF];
        System.arraycopy(arr, 0, halfArr1, 0, HALF);
        System.arraycopy(arr, HALF, halfArr2, 0, HALF);
        Thread thread1 = new Thread(() -> calc(halfArr1), "t1");
        Thread thread2 = new Thread(() -> calc(halfArr2, HALF), "t2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(halfArr1, 0, arr, 0, HALF);
        System.arraycopy(halfArr2, 0, arr, HALF, HALF);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time: " + (endTime - startTime));

        //System.out.println(Arrays.toString(arr));
    }

    public void setOne() {
        Arrays.fill(arr, 1.0f);
    }

    private void calc(float[] arr, int startElem) {
        for (int i = startElem; i < arr.length + startElem; i++) {
            arr[i - startElem] = (float) (arr[i - startElem] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            //System.out.print(Thread.currentThread().getName() + ":" + i + " ");
        }
        //System.out.println();
    }

    private void calc(float[] arr){
        this.calc(arr, 0);
    }
}
