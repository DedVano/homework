package lesson25.homework.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CsvItem {
    @CsvBindByName(column = "ISBN", required = true)
    private String isbn;
    @CsvBindByName(column = "Автор")
    private String author;
    @CsvBindByName(column = "Название")
    private String name;
    @CsvBindByName(column = "Серия")
    private String series;
    @CsvBindByName(column = "Номер в серии")
    private Integer numberInSeries;
}
