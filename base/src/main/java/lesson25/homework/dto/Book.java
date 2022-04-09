package lesson25.homework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(generator = "bookID")
    private int id;

    @Column
    private String isbn;

    @ManyToOne
    private Author author;

    @Column
    private String name;

    @ManyToOne
    private Series series;

    @Column
    private Integer numberInSeries;
}
