package lesson15;

import java.util.ArrayList;
import java.util.List;

public class AnonymousRunner {

    public static void main(String[] args) {
        final String value = "Тестовая строка";

        Comparable<String> comparator1 = new Comparable<>() {

            @Override
            public int compareTo(String o) {
                return value.compareTo(o);
            }
        };

        int anotherStringAsResult = comparator1.compareTo("Другая текстовая строка");
        System.out.println(anotherStringAsResult);

        Comparable<String> comparator2 = name -> value.compareTo(name);

        Comparable<String> comparator3 = name -> {
            System.out.println("На вход получили значение " + name);
            return value.compareTo(name);
        };

        Comparable<String> comparator4 = value::compareTo;

//        Moveable moveable = new Moveable() {
//            @Override
//            public void move() {
//            }
//        };

        Moveable moveable1 = () -> {
            // много строк кода
        };

        Moveable moveable2 = () -> System.out.println("Мы нахожимся в движении");

        Copyable<String> methodForCopy = (/*String*/ origin, /*int*/ copyCount) -> {
            String result = "";
            for (int i = 0; i < copyCount; i++) {
                result += origin;
            }
            return result;
        };

        List<String> words = new ArrayList<>();
        words.add("Новая строка");
        words.add("Старая строка");
        words.add("Еще одна строка");
        words.add("Последняя строка");

        words.sort((str1, str2) -> str2.length() - str1.length());

        System.out.println(words);
    }
}
