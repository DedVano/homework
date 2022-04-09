package lesson11.homework.exceptionClasses;

import lesson11.homework.enumerations.ExceptionReasons;

public class MyException extends RuntimeException {
    ExceptionReasons reason;
    String type;
    String numberPlate;

    public MyException(String message, ExceptionReasons reason, String type, String numberPlate) {
        super(message);
        this.reason = reason;
        this.type = type;
        this.numberPlate = numberPlate;
    }

    public ExceptionReasons getReason() {
        return reason;
    }

    public String getType() {
        return type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }
}
