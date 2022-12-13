package pro.sky.testscalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int plus(Integer num1, Integer num2) {
        //спринг сам выкидывает ошибку с кодом 400, несмотря на это исключение - если не введены параметры
        //но исключение работает - можно проверить на другом значении, например num2 == 0, и выводится сообщение исключения
        if (num1 == null || num2 == null) {
            throw new NotSetNumberException("Не задан один или оба параметра num1, num2");
        }
        return num1 + num2;
    }
    public int minus(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NotSetNumberException("Не задан один или оба параметра num1, num2");
        }
        return num1 - num2;
    }
    public int multiply(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NotSetNumberException("Не задан один или оба параметра num1, num2");
        }
        return num1 * num2;
    }
    public int divide(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NotSetNumberException("Не задан один или оба параметра num1, num2");
        }
        if (num2 == 0) {
            throw new IllegalNumberException("Деление на ноль невозможно");
        }
        return num1 / num2;
    }
}
