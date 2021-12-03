package lesson3.test;

import lesson3.HomeWorkApp;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.*;
import java.util.stream.Stream;

public class HomeWorkTest {

    @BeforeEach
    void startUp() throws IOException {
        System.out.println("Начинается тест");
    }

    @AfterEach
    void shutdown() {
        System.out.println("Тест завершен");
    }

    @BeforeAll
    static void mainStart() {
        System.out.println("Тесты для 3 урока");
    }

    @Test
    @DisplayName("Урок 3. Задание 7. Тест 1.")
    void testSumOfLeftSideIsEqualSumOfRightSide() {
        Assertions.assertTrue(HomeWorkApp.sumOfLeftSideIsEqualSumOfRightSide(new int[]{1, 1, 1, 2, 3, 2}));
    }

    @DisplayName("Урок 3. Задание 7. Параметризированный тест.")
    @ParameterizedTest
    @MethodSource("data")
    void paramTestSumOfLeftSideIsEqualSumOfRightSide(boolean expected, int[] arr) {
        Assertions.assertEquals(expected, HomeWorkApp.sumOfLeftSideIsEqualSumOfRightSide(arr));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(true, new int[]{1, 2, 3, 4, 2}),
                Arguments.arguments(false, new int[]{1, 2, 4, 5, 7}),
                Arguments.arguments(true, new int[]{1, 0, 3, 4, 5, 6}),
                Arguments.arguments(false, new int[]{Integer.MAX_VALUE, 1, 2, 3, Integer.MIN_VALUE}),
                Arguments.arguments(false, new int[0])
        );
    }

    @DisplayName("Урок 3. Задание 8. Тест 1.")
    @Test
    void testTimeoutShiftArrayElementsByNPlaces() {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            HomeWorkApp.shiftArrayElementsByNPlaces(new int[]{1, 2, 3}, 10000000);
        });
    }

    @DisplayName("Урок 3. Задание 8. Тест 2.")
    @Test
    void testTimeoutShiftArrayElementsByNPlaces2() {

        int size = 1000;
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = i;
        }

        Assertions.assertTimeout(Duration.ofMillis(100), () -> {
            HomeWorkApp.shiftArrayElementsByNPlaces(arr, -10000235);
        });
    }

    @DisplayName("Урок 3. Задание 8. Тест 3.")
    @Test
    void testTimeoutShiftArrayElementsByNPlaces3() {

        int size = 1000;
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = i;
        }

        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            HomeWorkApp.shiftArrayElementsByNPlaces(arr, -10);
        });
    }
}
