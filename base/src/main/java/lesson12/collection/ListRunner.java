package lesson12.collection;

import lesson7.homework.Cat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListRunner {

    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 4, 5};
//        List integers = List.of(1, 2, 3, 4, 5, 6);
//        for (Object value : integers) {
//            int index = (int) value;
//            System.out.print(index + " ");
//        }
        List raw = List.of(1, "Test", false, new Cat("Vasya"));
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        for (Integer value : integers) {
            System.out.print(value + " ");
        }
        System.out.println("\n----------------------------");
        // Как оно происходит на самом деле
        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext(); ) {
            Integer value = iterator.next();
            System.out.print(value + " ");
        }
        // integers.add (1);  не прокатит, потому как
        // это был неизменный список, а нам надо добавлять элементы, тогда:

        List<String> names = new ArrayList<>(10 /* необязательно, но лучше заранее указать */);
        names.add("Виталий");
        names.add("Анатолий");
        names.add("Сергей");
        names.add("Наталья");
        names.add("Ольга");
        names.add("Эдуард");

        System.out.println("\n------------------------");
        System.out.println(names);

        String name = "Виталий";
        System.out.println("В списке имен " + name + (names.contains(name) ? " встречается." : " не найден."));
        name = "Петр";
        System.out.println("В списке имен " + name + (names.contains(name) ? " встречается." : " не найден."));

        if (names.remove("Сергей")) {
            System.out.println("Имя удалено");
        } else {
            System.out.println("Имя не удалено");
        }
        System.out.println(names);

        System.out.println(names.remove("Сергей2") ? "Имя удалено" : "Имя не удалено");
        System.out.println(names);

        System.out.println("Размер списка: " + names.size());

        names.sort(Comparator.naturalOrder());
        System.out.println(names);

        //names.clear();

        System.out.println("Теперь на первом месте стоит " + names.get(0));
        System.out.println("А на последнем " + names.get(names.size() - 1));

        names.addAll(List.of("Виталий", "Николай", "Марина"));
        System.out.println(names);
        name = "Виталий";
        System.out.println("В списке имен " + name + (names.contains(name) ? " встречается." : " не найден."));
        System.out.println(names.indexOf(name));
        System.out.println(names.lastIndexOf(name));


    }
}
