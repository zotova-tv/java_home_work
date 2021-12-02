package lesson13;

import java.util.Locale;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch readyCarsCountDown;
    private CyclicBarrier startLine;
    private Semaphore finishSemaphore;
    private CountDownLatch finishLine;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch readyCarsCountDown, CyclicBarrier startLine, Semaphore finishSemaphore, CountDownLatch finishLine) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.startLine = startLine;
        this.finishLine = finishLine;
        this.readyCarsCountDown = readyCarsCountDown;
        this.finishSemaphore = finishSemaphore;
        race.registerParticipant(this);
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            readyCarsCountDown.countDown();
            try {
                startLine.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        try {
            finishSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int finishedAtNumber = race.carsCount() - (int)finishLine.getCount() + 1;
        System.out.println("✨✨✨ " + (this.getName() + " финишировал под номером " + finishedAtNumber).toUpperCase());
        finishLine.countDown();
        finishSemaphore.release();
    }
}

