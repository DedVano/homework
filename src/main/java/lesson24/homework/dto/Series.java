package lesson24.homework.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class Series {
    private final int id;
    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return Objects.equals(name, series.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
