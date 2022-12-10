package pro.sky.testscalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.testscalculator.service.CalculatorService;
import pro.sky.testscalculator.service.IllegalNumberException;

import java.util.List;

public class CalculatorServiceTests {
    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        int num1 = 10;
        int num2 = 20;
        int result = 30;
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("plusTestSuites")
    public void plusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("minusTestSuites")
    public void minusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.minus(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("multiplyTestSuites")
    public void multiplyTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.multiply(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("divideTestSuites")
    public void divideTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.divide(num1, num2));
    }

    @Test
    public void divideByZeroThrowsException() {
        Assertions.assertThrows(IllegalNumberException.class, () ->{
            calculatorService.divide(1, 0);
        });
    }

    public static List<Arguments> plusTestSuites() {
        return List.of(
                Arguments.of(10,20,30),
                Arguments.of(-15,40,25),
                Arguments.of(0,1,1)
        );
    }

    public static List<Arguments> minusTestSuites() {
        return List.of(
                Arguments.of(10,20,-10),
                Arguments.of(-15,40,-55),
                Arguments.of(0,-1,1)
        );
    }

    public static List<Arguments> multiplyTestSuites() {
        return List.of(
                Arguments.of(10,20,200),
                Arguments.of(-15,40,-600),
                Arguments.of(0,0,0)
        );
    }

    public static List<Arguments> divideTestSuites() {
        return List.of(
                Arguments.of(20,10,2),
                Arguments.of(-160,-40,4),
                Arguments.of(17,17,1)
        );
    }
}
