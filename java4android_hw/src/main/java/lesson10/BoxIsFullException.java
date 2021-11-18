package lesson10;

public class BoxIsFullException extends ArrayIndexOutOfBoundsException {
    public BoxIsFullException() {
        super("Box is full");
    }
}
