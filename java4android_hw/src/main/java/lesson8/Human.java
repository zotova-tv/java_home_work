package lesson8;

public class Human implements Participant {

    private int maxRunningDistance;
    private int maxJumpHeight;

    public Human(int maxRunningDistance, int maxJumpHeight) {
        this.maxRunningDistance = maxRunningDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(Track track) {
        if(track.getDistance() > this.getMaxRunningDistance()){
            System.out.println("The human cannot run such the distance.");
            return false;
        }else{
            System.out.println("The human ran the distance.");
            return true;
        }
    }

    @Override
    public boolean jump(Wall wall) {
        if(wall.getHeight() > this.getMaxJumpHeight()){
            System.out.println("The human cannot jump over this wall.");
            return false;
        }else{
            System.out.println("The human jumped over this wall.");
            return true;
        }
    }

    public int getMaxRunningDistance() {
        return maxRunningDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "maxRunningDistance=" + maxRunningDistance +
                ", maxJumpHeight=" + maxJumpHeight +
                '}';
    }
}
