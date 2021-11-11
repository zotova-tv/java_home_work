package lesson8;

public class Robot implements Participant{

    private int maxRunningDistance;
    private int maxJumpHeight;

    public Robot(int maxRunningDistance, int maxJumpHeight) {
        this.maxRunningDistance = maxRunningDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(Track track) {
        if(track.getDistance() > this.getMaxRunningDistance()){
            System.out.println("The robot cannot run such a distance.");
            return false;
        }else{
            System.out.println("The robot ran the distance.");
            return true;
        }
    }

    @Override
    public boolean jump(Wall wall) {
        if(wall.getHeight() > this.getMaxJumpHeight()){
            System.out.println("The robot cannot jump over this wall.");
            return false;
        }else{
            System.out.println("The robot jumped over this wall.");
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
        return "Robot{" +
                "maxRunningDistance=" + maxRunningDistance +
                ", maxJumpHeight=" + maxJumpHeight +
                '}';
    }
}
