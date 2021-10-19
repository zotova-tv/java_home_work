package lesson2;

public class HomeWorkApp {
    public static void main(String[] args) {
        inRangeFrom10To20(12, 3);  // task 1
        printPositiveOrNegative(11);  // task 2
        isPositiveInteger(-10); // task 3
        printStringNTimes("Hello, World!", 10);  // task 4
        isLeapYear(2021);  // task 5
    }

    private static boolean inRangeFrom10To20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void printPositiveOrNegative(int digit) {
        if( digit >= 0 ){
            System.out.println("Число положительное");
        }else{
            System.out.println("Число отрицательное");
        }
    }

    private static boolean isPositiveInteger(int digit) {
        return digit >= 0;
    }

    private static void printStringNTimes(String s, int n) {
        for(int i=0; i < n; i++){
            System.out.println(s);
        }
    }

    private static boolean isLeapYear(int year) {
        if(year % 400 == 0){
            return true;
        }else if( year % 100 == 0 ){
            return false;
        }else if( year % 4 == 0 ){
            return true;
        }else{
            return false;
        }
    }
}
