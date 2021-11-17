package lesson9;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    public MyArraySizeException() {
        super("Размер передаваемого массива должен быть строго 4 на 4");
    }
}
