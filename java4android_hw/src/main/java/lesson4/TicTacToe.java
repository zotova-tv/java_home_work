package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 5;
    private static final int symbolsCountForWin = getSymbolsCountForWin();
    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

    private static final String SPACE_MAP = " ";
    private static final String HEADER_FIRST_MAP = "♥";

    private static final char[][] MAP = new char[SIZE][SIZE];
    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    private static int turnsCount;
    private static int[] currentCoordinates = new int[2];

    public static void turnGame() {
        do {
            init();
            printMap();
            playGame();
        } while (continueGame());
        endGame();
    }

    private static void endGame() {
        System.out.println("До новых встреч!");
    }

    private static void init() {
        initMap();
        turnsCount = 0;
    }

    private static boolean continueGame() {
        System.out.println("Хотите сыграть еще? y/n");
        return switch (in.next()) {
            case "y", "yes" -> true;
            default -> false;
        };
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_MAP + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }


    private static void playGame() {
        while (true) {

            turnHuman(); // ход игрока
            printMap(); // печать игрового поля
            if (checkEnd(DOT_HUMAN)) { // проверка на конец игры
                break;
            }

            turnAI();// ход ии
            printMap(); // печать игрового поля
            if (checkEnd(DOT_AI)) {// проверка игрового поля
                break;
            }
        }
        // следующий ход
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("\nВы победили!");
            } else {
                System.out.println("\nВы проиграли!");
            }
            return true;
        }
        if (checkDraw(symbol)) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkDraw(char symbol) {
        if (turnsCount == SIZE * SIZE) {
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {
        // проверяю горизонтальную линию [-]
        if(checkHorizontal(symbol)){
            return true;
        }
        // проверяю вертикальную линию [|]
        if(checkVertical(symbol)){
            return true;
        }
        // проверяю нисходящую диагональ [\]
        if (checkDescendingDiagonal(symbol)) {
            return true;
        }
        // проверяю восходящую диагональ [/]
        if (checkAscendingDiagonal(symbol)) {
            return true;
        }

        return false;
    }

    private static boolean checkHorizontal(int symbol){
        // проверка строки
        int symbolsInLineCount = 0;
        int currentRowNum = currentCoordinates[0];
        for (int i = 0; i < SIZE; i++) {
            if(MAP[currentRowNum][i] == symbol){
                symbolsInLineCount++;
                if(symbolsInLineCount == symbolsCountForWin){
                    return true;
                }
            }else{
                symbolsInLineCount = 0;
            }
        }
        return false;
    }

    private static boolean checkVertical(int symbol){
        // проверка столбца
        int currentColumnNum = currentCoordinates[1];
        int symbolsInLineCount = 0;
        for (int i = 0; i < SIZE; i++) {
            if(MAP[i][currentColumnNum] == symbol){
                symbolsInLineCount++;
                if(symbolsInLineCount == symbolsCountForWin){
                    return true;
                }
            }else{
                symbolsInLineCount = 0;
            }
        }
        return false;
    }

    private static boolean checkDescendingDiagonal(char symbol) {
        int diagonalPointRow = currentCoordinates[0];
        int diagonalPointColumn = currentCoordinates[1];
        int symbolsInLineCount = 0;

        // нахожу верхнюю точку диагонали
        while(diagonalPointRow > 0 && diagonalPointColumn > 0){
            diagonalPointRow--;
            diagonalPointColumn--;
        }
        // отбрасываю диагонали, где заведомо меньше клеток, чем количество символов, необходимое для победы
        if(SIZE - diagonalPointRow + diagonalPointColumn < symbolsCountForWin){
            return false;
        }
        // считаю символы игрока, пока не приду в нижнюю точку диагонали
        while(diagonalPointRow < SIZE && diagonalPointColumn < SIZE){
            if(MAP[diagonalPointRow][diagonalPointColumn] == symbol){
                symbolsInLineCount++;
                if(symbolsInLineCount == symbolsCountForWin){
                    return true;
                }
            }else{
                symbolsInLineCount = 0;
            }
            diagonalPointRow++;
            diagonalPointColumn++;
        }
        return false;
    }

    private static boolean checkAscendingDiagonal(char symbol) {
        int diagonalPointRow = currentCoordinates[0];
        int diagonalPointColumn = currentCoordinates[1];
        int symbolsInLineCount = 0;
        // нахожу верхнюю точку диагонали
        while(diagonalPointRow > 0 && diagonalPointColumn < SIZE - 1){
            diagonalPointRow--;
            diagonalPointColumn++;
        }
        // отбрасываю диагонали, где заведомо меньше клеток, чем количество символов, необходимое для победы
        if((diagonalPointRow == 0 && diagonalPointColumn + 1 < symbolsCountForWin) || (diagonalPointColumn == SIZE - 1 && SIZE - diagonalPointRow < symbolsCountForWin)){
            return false;
        }
        // считаю символы игрока, пока не приду в нижнюю точку диагонали
        while(diagonalPointRow < SIZE && diagonalPointColumn >= 0){
            if(MAP[diagonalPointRow][diagonalPointColumn] == symbol){
                symbolsInLineCount ++;
                if(symbolsInLineCount == symbolsCountForWin){
                    return true;
                }
            }else{
                symbolsInLineCount = 0;
            }
            diagonalPointRow++;
            diagonalPointColumn--;
        }
        return false;
    }

    private static void turnAI() {
        System.out.println("Ход компьютера");
        int rowNumber, columnNumber;
        while (true) {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
            if (isCellFree(rowNumber, columnNumber)) {
                setCurrentCoordinates(rowNumber, columnNumber);
                break;
            } else {
                System.out.println("\nВы выбрали занятую ячейку");
            }
        }
        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
    }

    private static void turnHuman() {
        System.out.println("Ход человека");
        int rowNumber, columnNumber;
        while (true) {
            rowNumber = getValidNumberFromUser() - 1;  // in.nextInt() - 1;
            columnNumber = getValidNumberFromUser() - 1;  //in.nextInt() - 1;
            if (isCellFree(rowNumber, columnNumber)) {
                setCurrentCoordinates(rowNumber, columnNumber);
                break;
            } else {
                System.out.println("\nВы выбрали занятую ячейку");
            }
        }
        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static int getValidNumberFromUser() {
        while (true) {
            System.out.println("Введите координату от 1 до " + SIZE);
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                } else {
                    System.out.println("\nПроверьте значение координаты. Должны быть от 1 до " + SIZE);
                }
            } else {
                in.next();
                System.out.println("\nВвод допускает лишь целые числа!");
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static void setCurrentCoordinates(int rowNumber, int columnNumber) {
        currentCoordinates[0] = rowNumber;
        currentCoordinates[1] = columnNumber;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static int getSymbolsCountForWin(){
        if(SIZE >= 3 && SIZE <= 5){
            return 3;
        }else if(SIZE >= 6 && SIZE <= 10){
            return 4;
        }else{
            // предполагается, что значение SIZE больше 3
            return 5;
        }
    }
}
