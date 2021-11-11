package lesson8;

public class Track implements Obstacle{

    final private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.run(this);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Track{" +
                "distance=" + distance +
                '}';
    }
}
