package lesson13;

import java.util.*;

public class LinkedListRunner {

    public static void main(String[] args) {
        List<String> words = new LinkedList<>();
        List<String[]> wordsOfWords = new LinkedList<>();
        // List<List<Set<Integer>>> = ...  так лучше не надо, сложно потом разбирать
        List<Product> products = new LinkedList<>(); // если надо много вспомогательной инфы, проще создать свой класс

        words.add("Skoda");
        words.add("VW");
        words.add("ВАЗ");
        words.add("Bentley");
        words.add("Audi");
        words.add("BMW");
        words.add("Mercedes");
        words.add("Geely");

        ListIterator<String> wordListIterator = words.listIterator();
//        while (wordListIterator.hasNext()) {
//            String word = wordListIterator.next();
//        }
//        while (wordListIterator.hasPrevious()) {
//            String word = wordListIterator.previous();
//        }

        System.out.println(words);
//        for (String word : words) {
//            if (new Random().nextBoolean()) {
//                words.remove(word);
//            }
//        }
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if (new Random().nextBoolean()) {
                System.out.println("Удаляемый элемент: " + next);
                iterator.remove();
            }
        }
        System.out.println(words);

        List<String> anotherWords = List.of("Lamborgini", "Suzuki", "Ford");
        List<String> yetAnotherWords = new ArrayList<>(anotherWords);
        words.addAll(anotherWords);
        System.out.println(words);
        words.set(3, "Jeep");
        System.out.println(words);
        swap(words, 1, 3);
        System.out.println(words);


    }

    private static void swap(List<String> list, int begin, int finish) {
        if (begin >= list.size() || finish >= list.size()) {
            //TODO: generate exception
            return;
        }
        String firstElement = list.get(begin);
        String secondElement = list.get(finish);
        list.set(begin, secondElement);
        list.set(finish, firstElement);
    }
}
