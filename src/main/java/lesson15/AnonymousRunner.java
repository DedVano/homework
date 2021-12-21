package lesson15;

public class AnonymousRunner {

    public static void main(String[] args) {
        final String value = "Тестовая строка";
        Comparable<String> comparator = new Comparable<>() {
            @Override
            public int compareTo(String o) {
                return value.compareTo(o);
            }
        };
    }
}
