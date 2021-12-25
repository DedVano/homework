package lesson15;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {

    public static final Integer THRESHOLD = 1000;
    public static long result = 0;

    public static void main(String[] args) {

        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            digits.add(new Random().nextInt(THRESHOLD));
        }
        System.out.println(digits);

        Stream<Integer> stream = digits.stream();

        Stream.Builder<Integer> builder = Stream.builder();
        for (int i = 0; i < 100; i++) {
            builder.add(new Random().nextInt(THRESHOLD));
        }

        System.out.println(stream.count());

        System.out.println("Сумма через итерирование " + summa(digits)); // without streams
        System.out.println("Сумма через stream " + summaStream(digits));

        Stream<String> names = Stream.of("Виталий", "Сергей", "Анна", "Петр");
        List<Integer> lengthOfNames = names
                .peek(System.out::println)
                .limit(3)
                .skip(1)
                .map(String::length)
                .filter(i -> i % 2 == 0)
                .distinct()
                .sorted(/*Comparator.reverseOrder()*/ (a1, a2) -> a2 - a1)
                .collect(Collectors.toList());
        System.out.println(lengthOfNames);
        //System.out.println(names.collect(Collectors.toSet())); так нельзя, поток уже обработан, надо создавать заново
    }

    public static long summa(Collection<Integer> ints) {
        long result = 0;
        for(Integer val : ints) {
            result += val;
        }
        return result;
    }

    public static long summaStream(Collection<Integer> ints) {
//        return ints.stream().reduce(0, (a, b) -> a + b);
//        return ints.stream().reduce(0, Integer::sum);
        result = 0;
        ints.stream().forEach(a -> result += a);
        return result;
    }
}
