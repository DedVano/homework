package lesson14;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MapRunner {
    public static void main(String[] args) {
        //Map<Integer, String> regions = new HashMap<>();
        Map<Integer, String> regions = new LinkedHashMap<>();

        regions.put(77, "Москва");
        regions.put(63, "Самара");
        regions.put(64, "Саратов2");
        regions.put(16, "Казань");
        regions.put(78, "Санкт-Петербург");
        regions.put(61, "Ростов-на-Дону");
        regions.put(64, "Саратов"); // !!
        regions.put(72, null);
        regions.put(null, null);
        regions.put(null, "");
        System.out.println(regions);

        System.out.println(regions.get(77));
        if (regions.containsKey(71)) {
            System.out.println(regions.get(71));
        } else System.out.println("чото не нашел");
        if (regions.containsKey(72)) {
            System.out.println(regions.get(72));
        }

        System.out.println(regions.size());
        System.out.println(regions.keySet());
        System.out.println(regions.values());

        System.out.println(regions.containsValue("Самара"));
        String searchValue = "Ростов-на-Дону";
        System.out.println(getKeyByValue(regions, searchValue));
    }

    private static Integer getKeyByValue(Map<Integer, String> regions, String searchValue) {
        for (Map.Entry<Integer, String> entry : regions.entrySet()) {
            if (Objects.equals(searchValue, entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Ключа по значению " + searchValue + " не найдено.");
    }
}
