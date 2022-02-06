package lesson24.homework;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lesson24.homework.dto.Author;
import lesson24.homework.dto.Book;
import lesson24.homework.dto.Series;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

public class AddBooksToDatabase {

    private static final File CSV_FILE = new File("src/main/resources/books.csv");
    private static final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(FindBooksFromDatabase.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Set<Author> authorList = new LinkedHashSet<>();
        Set<Series> seriesList = new LinkedHashSet<>();
        Set<Book> booksList = new LinkedHashSet<>();

        System.out.println("Заполняем базу данных...");
        if (readFromCSV(booksList, authorList, seriesList)) {
            if (fillDatabase(booksList, authorList, seriesList)) {
                System.out.println("Заполнение базы данных прошло успешно.");
            }
        }
    }

    private static boolean readFromCSV(Set<Book> booksList, Set<Author> authorList, Set<Series> seriesList) {
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(CSV_FILE))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .withSkipLines(1)
                .build()
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                String isbnFromFile = nextRecord[0];
                String authorNameFromFile = nextRecord[1];
                String bookNameFromFile = nextRecord[2];
                String seriesNameFromFile = nextRecord[3];
                Integer numberInSeriesFromFile = nextRecord[4].equals("") ? null : Integer.valueOf(nextRecord[4]);
                Author author = new Author(authorList.size() + 1, authorNameFromFile);
                if (!authorList.add(author)) {
                    author = (Author) findFromList(authorList, author);
                }
                Series series = new Series(seriesList.size() + 1, seriesNameFromFile);
                if (!seriesList.add(series)) {
                    series = (Series) findFromList(seriesList, series);
                }
                booksList.add(new Book(booksList.size() + 1, isbnFromFile, author, bookNameFromFile, series, numberInSeriesFromFile));
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Файл %s не найден.\n", CSV_FILE);
            return false;
        } catch (IOException e) {
            System.out.printf("При считывании из файла %s произошла ошибка ввода-вывода.\n", CSV_FILE);
            return false;
        } catch (CsvValidationException e) {
            System.out.printf("Файл %s имеет ошибки внутренней структуры, что не позволяет его полноценно прочитать.\n", CSV_FILE);
            return false;
        }
        return true;
    }

    private static Object findFromList(Set<?> list, Object target) {
        for (Object item : list) {
            if (item.equals(target)) {
                return item;
            }
        }
        return null;
    }

    private static boolean fillDatabase(Set<Book> booksList, Set<Author> authorList, Set<Series> seriesList) {
        try (final Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));
             final Statement st = connection.createStatement();
             final PreparedStatement prepStForAddAuthor = connection.prepareStatement("insert into authors (id, name) values (?, ?);");
             final PreparedStatement prepStForAddSeries = connection.prepareStatement("insert into series (id, name) values (?, ?);");
             final PreparedStatement prepStForAddBook = connection
                     .prepareStatement("insert into books (isbn, author, name, series, number_in_series) values (?, ?, ?, ?, ?);")
        ) {
            st.execute("""
                    create table if not exists authors
                    (
                        id int not null primary key,
                        name varchar(255) not null
                    );
                    """);
            st.execute("""
                    create table if not exists series
                    (
                        id int not null primary key,
                        name varchar(255) null
                    );
                    """);
            st.execute("""
                    create table if not exists books
                    (
                        id int auto_increment primary key,
                        isbn varchar(25) null,
                        author int null,
                        name varchar(255) not null,
                        series int null,
                        number_in_series int null,
                        constraint books_authors_id_fk
                            foreign key (author) references authors (id),
                        constraint books_series_id_fk
                            foreign key (series) references series (id)
                    );
                    """);
            st.execute("delete from books;");
            st.execute("delete from authors;");
            st.execute("delete from series;");
            st.execute("alter table books auto_increment=0;");
            st.execute("alter table authors auto_increment=0;");
            st.execute("alter table series auto_increment=0;");
            for (Author author : authorList) {
                prepStForAddAuthor.setInt(1, author.getId());
                prepStForAddAuthor.setString(2, author.getName());
                prepStForAddAuthor.executeUpdate();
            }
            for (Series series : seriesList) {
                prepStForAddSeries.setInt(1, series.getId());
                prepStForAddSeries.setString(2, series.getName());
                prepStForAddSeries.executeUpdate();
            }
            for (Book book : booksList) {
                prepStForAddBook.setString(1, book.getIsbn());
                prepStForAddBook.setInt(2, book.getAuthor().getId());
                prepStForAddBook.setString(3, book.getName());
                prepStForAddBook.setInt(4, book.getSeries().getId());
                if (book.getNumberInSeries() != null) {
                    prepStForAddBook.setInt(5, book.getNumberInSeries());
                } else {
                    prepStForAddBook.setNull(5, Types.INTEGER);
                }
                prepStForAddBook.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("При заполнении базы танных произошла ошибка: неверный синтаксис запроса.");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
