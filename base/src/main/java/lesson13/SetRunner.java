package lesson13;

import java.util.*;

public class SetRunner {

    public static void main(String[] args) {
        System.out.println(Set.of(13, 15, -1, 28, 75));
//        Set<Product> products = new HashSet<>(); // сортировка при выводе (итераторе) по хэшу
        Set<Product> products = new LinkedHashSet<>(); // сортировка при выводе (итераторе) по порядку добавления
        products.add(new Product(1, "Хлеб", 35));
        products.add(new Product(10, "Хлеб", 35));
        products.add(new Product(2, "Молоко", 70));
        products.add(new Product(3, "Яблоко", 120));
        products.add(new Product(4, "Зубная паста", 300));
        products.add(new Product(5, "Мусорные пакеты", 20));
        System.out.println(products);

        Set<Integer> values = new TreeSet<>(); // с компаратором
        values.add(150);
        values.add(1);
        values.add(138);
        values.add(-5);
        values.add(17);
        values.add(1);
        System.out.println(values);

        Set<Product> products2 = new TreeSet<>(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        products2.add(new Product(145, "Хлеб", 35));
        products2.add(new Product(10, "Хлеб", 35));
        products2.add(new Product(21, "Молоко", 70));
        products2.add(new Product(3, "Яблоко", 120));
        products2.add(new Product(47, "Зубная паста", 300));
        products2.add(new Product(-5, "Мусорные пакеты", 20));
        System.out.println(products2);

        Set<Product3> products3 = new TreeSet<>();
        products3.add(new Product3(145, "Хлеб", 35));
        products3.add(new Product3(10, "Хлеб", 35));
        products3.add(new Product3(21, "Молоко", 70));
        products3.add(new Product3(3, "Яблоко", 120));
        products3.add(new Product3(47, "Зубная паста", 300));
        products3.add(new Product3(-5, "Мусорные пакеты", 20));
        System.out.println(products3);

    }
}
