package lesson9;

public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(String s) {
        super(s);
    }

    public MyArrayDataException(int rowIndex, int colIndex) {
        this(String.format("Данные в ячейке [%d][%d] не могут быть приведены к типу Integer", rowIndex, colIndex));
    }
}
