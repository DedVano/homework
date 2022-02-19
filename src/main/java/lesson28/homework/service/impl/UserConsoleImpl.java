package lesson28.homework.service.impl;

import lesson28.homework.service.UserConsole;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserConsoleImpl implements UserConsole {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printf(String message, Object... args) {
        System.out.printf(message, args);
    }

    @Override
    public String getRequestf(String message, Object... args) {
        System.out.printf(message, args);
        return scanner.nextLine();
    }
}
