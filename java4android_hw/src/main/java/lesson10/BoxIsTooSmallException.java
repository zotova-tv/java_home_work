package lesson10;

public class BoxIsTooSmallException extends ArrayIndexOutOfBoundsException {
    public BoxIsTooSmallException() {
        super("Box is too small");
    }
}
