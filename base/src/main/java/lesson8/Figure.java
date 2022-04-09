package lesson8;

import java.util.Objects;

public class Figure {

    String name;
    int size;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return size == figure.size && Objects.equals(name, figure.name);
    }


}
