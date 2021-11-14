package lesson8;

public class Wall implements Obstacle{

    final private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.jump(this);
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }
}
