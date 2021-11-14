package lesson8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Participant[] participants = {
                new Human(3000, 2),
                new Cat(5000, 2),
                new Robot(10000, 1)
        };

        System.out.println("Participants: " + Arrays.toString(participants) + "\n");

        Obstacle[] obstacles = {
                new Wall(2),
                new Track(5000)
        };

        System.out.println("Obstacles: " + Arrays.toString(obstacles) + "\n");
        System.out.println("Results of overcoming obstacles:" + "\n");
        for (Participant participant : participants) {
            boolean allObstaclesOvercame = true;
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    System.out.println("☹ The participant could not overcome the obstacle.");
                    allObstaclesOvercame = false;
                    break;
                }
            }
            if( allObstaclesOvercame ){
                System.out.println("✨ The participant overcame all obstacles.");
            }
            System.out.println();
        }
    }
}
