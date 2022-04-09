package lesson28.homework.service.impl;

import lesson28.homework.service.UserConsole;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class UserConsoleImpl implements UserConsole {

    private final Scanner scanner = new Scanner(getInputStream());

    @Override
    public InputStream getInputStream() {
        return System.in;
    }

    @Override
    public PrintStream getPrintStream() {
        return System.out;
    }

    @Override
    public void print(String message) {
        getPrintStream().println(message);
    }

    @Override
    public void printf(String message, Object... args) {
        getPrintStream().printf(message, args);
    }

    @Override
    public String getRequestf(String message, Object... args) {
        getPrintStream().printf(message, args);
        return scanner.nextLine();
    }
}
