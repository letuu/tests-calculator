package pro.sky.testscalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.testscalculator.service.CalculatorService;
import pro.sky.testscalculator.service.IllegalNumberException;
import pro.sky.testscalculator.service.NotSetNumberException;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
//Вывод в консоль сообщения своего исключения, при этом аннотацию в своем исключении надо убрать, это ExceptionMapper
//    @ExceptionHandler(value = IllegalNumberException.class)
//    public ResponseEntity<String> IllegalNumberHandler(IllegalNumberException e) {
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }

    @ExceptionHandler(value = NotSetNumberException.class)
    public ResponseEntity<String> NotSetNumberHandler(NotSetNumberException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @GetMapping("/")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        //здесь также можно выкидывать исключение или в сервисе, здесь предпочтительней, так как это простая валидация
        //но спринг сам выкидывает ошибку с кодом 400, несмотря на это исключение
//        if (num1 == null || num2 == null) {
//            throw new NotSetNumberException("Не задан один или оба параметра num1, num2");
//        }
        int result = calculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        int result = calculatorService.minus(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        int result = calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        int result = calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d", num1, num2, result);
    }
}
