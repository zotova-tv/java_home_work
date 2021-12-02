package lesson13;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Car> cars = new ArrayList<>();

    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void registerParticipant(Car car){
        cars.add(car);
    }

    public int carsCount(){
        return cars.size();
    }
}
