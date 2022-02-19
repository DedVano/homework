package lesson28.homework.service;

public interface UserConsole {
    void print(String message);
    void printf(String message, Object... args);
    String getRequestf(String message, Object... args);
}
