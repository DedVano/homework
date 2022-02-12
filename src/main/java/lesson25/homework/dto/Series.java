package lesson25.homework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(generator = "seriesID")
    private int id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "series")
    List<Book> books;

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
