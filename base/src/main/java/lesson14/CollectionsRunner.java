package lesson14;

import java.util.*;

public class CollectionsRunner {
    public static final List<String> WORDS = List.of("Виталий", "Василий");

    public static void main(String[] args) {
        for (String str : generate()) {
            System.out.println(str);
        }
        //Collections.sort(WORDS); не на имутабельных коллекциях
        List<String> anotherWords = new ArrayList<>();
        for (int i = 0 ; i < 100; i++) {
            anotherWords.add(i + "");
        }
        Collections.rotate(anotherWords, 9);
        System.out.println(anotherWords);
    }

    public static Collection<String> generate() {
        return new Random().nextBoolean() ? Collections.emptyList() : WORDS;
    }
}
