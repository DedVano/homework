package lesson26.homework.impl;

import lesson26.homework.interfaces.InputInterface;

import java.util.Scanner;

public class InputInterfaceImpl implements InputInterface {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public String getRequest() {
        return scanner.nextLine();
    }
}
