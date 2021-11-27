package lesson13;

import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CyclicBarrier startLine = new CyclicBarrier(CARS_COUNT);
        CountDownLatch finishCarsCountDown = new CountDownLatch(CARS_COUNT);
        CountDownLatch readyCarsCountDown = new CountDownLatch(CARS_COUNT);
        Semaphore finishSemaphore = new Semaphore(1);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), readyCarsCountDown, startLine, finishSemaphore, finishCarsCountDown);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            int k = i;
            executorService.execute(cars[k]);
        }
        try {
            readyCarsCountDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            finishCarsCountDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        executorService.shutdown();
    }
}
