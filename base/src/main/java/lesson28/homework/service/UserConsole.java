package lesson28.homework.service;

import java.io.InputStream;
import java.io.PrintStream;

public interface UserConsole {
    InputStream getInputStream();
    PrintStream getPrintStream();
    void print(String message);
    void printf(String message, Object... args);
    String getRequestf(String message, Object... args);
}
