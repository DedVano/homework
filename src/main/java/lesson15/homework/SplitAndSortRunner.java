package lesson15.homework;

import java.util.*;
import java.util.stream.Collectors;

public class SplitAndSortRunner {
    public static void main(String[] args) {


        String sourceText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Sed sodales consectetur purus at faucibus. Donec mi quam, " +
                "tempor vel ipsum non,  faucibus suscipit massa. Morbi lacinia " +
                "velit blandit tincidunt efficitur. Vestibulum eget metus " +
                "imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, " +
                "ac auctor lorem. Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit. Integer vel odio nec mi tempor dignissim.";

//        sourceText = "Семь раз отмерь, 1 раз отрежь!";

        // Long Way

        /*String modifiedText = sourceText
                .replace('.', ' ')
                .replace(',', ' ')
                .replace(':', ' ')
                .replace('!', ' ')
                .replace(';', ' ')
                .replace('?', ' ');
        Stream<String> sourceStream = Arrays.stream(modifiedText.split("\\s+"));
        Map<String, Integer> sourceMap = sourceStream.collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        Map<String, Integer> targetMap = sourceMap
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(countValue -> -(int) ((Map.Entry) countValue).getValue())
                        .thenComparing(wordKey -> ((Map.Entry) wordKey).getKey().toString().toLowerCase()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, LinkedHashMap::new));
        targetMap
                .entrySet()
                .stream()
                .forEach((Map.Entry<String, Integer> x) -> System.out.println(x.getKey() + " " + x.getValue()));
    }*/

        // Short Way

        Arrays.stream(sourceText
                        .replace('.', ' ')
                        .replace(',', ' ')
                        .replace(':', ' ')
                        .replace('!', ' ')
                        .replace(';', ' ')
                        .replace('?', ' ')
                        .toLowerCase(Locale.ROOT)
                        .split("\\s+"))
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum, LinkedHashMap::new))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(entry -> -(int) entry.getValue()))
                .forEach((Map.Entry<String, Integer> x) -> System.out.println(x.getKey() + " - " + x.getValue()));
    }
}