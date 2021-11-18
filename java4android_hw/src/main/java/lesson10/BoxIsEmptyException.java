package lesson10;

public class BoxIsEmptyException extends ArrayIndexOutOfBoundsException {
    public BoxIsEmptyException() {
        super("Box is empty!");
    }
}
