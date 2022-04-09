package lesson24.homework.dto;

import lombok.Data;

@Data
public class Book {
    private final int id;
    private final String isbn;
    private final Author author;
    private final String name;
    private final Series series;
    private final Integer numberInSeries;
}
