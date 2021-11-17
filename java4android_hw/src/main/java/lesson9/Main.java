package lesson9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Sum of " + Arrays.deepToString(arr) + " = " + getSumFromParsedStringArray4X4(arr));
        }catch(MyArraySizeException e){
            e.printStackTrace();
        }catch(MyArrayDataException e){
            e.printStackTrace();
        }
    }

    public static int getSumFromParsedStringArray4X4(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        if(arr.length != 4){
            throw new MyArraySizeException();
        }
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length != 4){
                throw new MyArraySizeException();
            }
            for(int j = 0; j < arr[i].length; j++){
                try{
                    sum += Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
