package lesson8;

import java.util.Objects;

public class Cat {

    String name;
    int age;
    String poroda;
    String bossName;

    public boolean equals(Object cat) {
        if (cat instanceof Cat c) {
            return Objects.equals(name, c.name)
                    && age == c.age
                    && Objects.equals(poroda, c.poroda);
            // && bossName == cat.bossName;
        }
        return false;

    }
}
