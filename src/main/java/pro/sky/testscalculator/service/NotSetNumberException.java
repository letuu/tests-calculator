package pro.sky.testscalculator.service;

public class NotSetNumberException extends RuntimeException {
    public NotSetNumberException(String message) {
        super(message);
    }
}
