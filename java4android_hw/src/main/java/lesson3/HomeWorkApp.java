package lesson3;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class HomeWorkApp {

    public static void main(String[] args) {

        // task 1
        replace0With1(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0});

        // task 2
        System.out.println(Arrays.toString(createRange(1, 100)));
        System.out.println(Arrays.toString(createRangeFrom1(100)));

        // task 3
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyBy2IfLessThan6(arr);
        System.out.println(Arrays.toString(arr));

        // task 4
        drawCrossInASquare(6);

        // task 5
        createArrayWithInitialValue(10, 1);

        // task 6
        int[] arr2 = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        int minNum = getMinNum(arr2);
        int maxNum = getMaxNum(arr2);
        System.out.println("Min: " + minNum + "; Max: " + maxNum);

        // task 7
        int[] arr3 = {1, 1, 1, 2, 3, 2};
        sumOfLeftSideIsEqualSumOfRightSide(arr3);

        // task 8
        int[] arr4 = {1, 2, 3};
        shiftArrayElementsByNPlaces(arr4, -1);
    }

    // task 1
    private static void replace0With1(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                ints[i] = 1;
            } else if (ints[i] == 1) {
                ints[i] = 0;
            } else {
                continue;
            }
        }
    }

    // task 2
    private static int[] createRange(int rangeFrom, int rangeTo) {
        if (rangeFrom > rangeTo) {
            return new int[]{};
        }
        int[] arr = new int[rangeTo - rangeFrom + 1];
        for (int i = 0, j = rangeFrom; i < arr.length; i++, j++) {
            arr[i] = j;
        }
        return arr;
    }

    // task 2
    private static int[] createRangeFrom1(int rangeTo) {
        if (rangeTo < 1) {
            return new int[]{};
        }
        int[] arr = new int[rangeTo];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // task 3
    private static void multiplyBy2IfLessThan6(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] = nums[i] * 2;
            }
        }
    }

    // task 4
    private static void drawCrossInASquare(int a) {
        int[][] deepArr = new int[a][a];
        for (int i = 0; i < deepArr.length; i++) {
            for (int j = 0; j < deepArr[i].length; j++) {
                if (i == j) {
                    deepArr[i][j] = 1;
                }
                if (j == deepArr[i].length - 1 - i) {
                    deepArr[i][j] = 1;
                }
                System.out.print(deepArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // task 5
    private static int[] createArrayWithInitialValue(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    // task 6
    private static int getMaxNum(int[] arr) {
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }

    // task 6
    private static int getMinNum(int[] arr) {
        int minNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minNum) {
                minNum = arr[i];
            }
        }
        return minNum;
    }

    // task 7
    public static boolean sumOfLeftSideIsEqualSumOfRightSide(int[] arr) {

        Logger logger = getLogger("task7");
        if( logger.getHandlers().length ==  0 ){
            try {
                Handler handler = getHandler("lesson3Task7.log");
                logger.addHandler(handler);
            }catch (IOException e){
                logger.warning(e.getMessage());
            }
        }

        logger.info("В функцию sumOfLeftSideIsEqualSumOfRightSide передан массив " + Arrays.toString(arr));

        if (arr.length < 2) {
            logger.warning("Передан массив с менее чем двумя числами");
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j < i) {
                    leftSum += arr[j];
                } else {
                    rightSum += arr[j];
                }
            }
            if (leftSum == rightSum) {
                logger.log(Level.FINE, "Массив может быть поделен на два миссива с одинаковыми суммами. Сумма каждого массива будет равно " + leftSum);
                return true;
            }
        }
        logger.info("Массив не может быть поделен на два миссива с одинаковыми суммами");
        return false;
    }

    // task 8
    public static void shiftArrayElementsByNPlaces(int[] arr, int allShiftsCount) {

        Logger logger = getLogger("task8");
        if( logger.getHandlers().length ==  0 ){
            try {
                Handler handler = getHandler("lesson3Task8.log");
                logger.addHandler(handler);
            }catch (IOException e){
                logger.warning(e.getMessage());
            }
        }
        logger.info("В метод shiftArrayElementsByNPlaces переданы " + Arrays.toString(arr) + ", который нужно сдивинуть " + allShiftsCount + " раз");
        int shiftsCount = allShiftsCount % arr.length;
        if (shiftsCount > 0) {
            int prevElem = arr[arr.length - 1];
            for (int i = 0; i < shiftsCount; i++) {
                for (int j = 0; j < arr.length; j++) {
                    int currentElem = arr[j];
                    arr[j] = prevElem;
                    prevElem = currentElem;
                }
            }
        } else if (shiftsCount < 0) {
            shiftsCount *= -1;
            int prevElem = arr[0];
            for (int i = 0; i < shiftsCount; i++) {
                for (int j = arr.length - 1; j >= 0; j--) {
                    int currentElem = arr[j];
                    arr[j] = prevElem;
                    prevElem = currentElem;
                }
            }
        }
        logger.info("Результат смещения массива " + Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr));
    }

    private static Logger getLogger(String loggerName){
        if(loggerName == ""){
            loggerName = "defaultLogger";
        }
        Logger logger = Logger.getLogger(loggerName);
        logger.setLevel(Level.ALL);
        return logger;
    }

    private static Handler getHandler(String filename) throws IOException {
        if( filename == "" ){
            filename = "defaultLog.log";
        }
        Handler handler = new FileHandler("src/main/resources/logs/" + filename);
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.ALL);
        return handler;
    }
}
