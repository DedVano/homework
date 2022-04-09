package lesson25.homework;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import lesson25.homework.dto.Author;
import lesson25.homework.dto.Book;
import lesson25.homework.dto.CsvItem;
import lesson25.homework.dto.Series;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.function.Consumer;

public class AddBooksToDatabase {

    private static final File CSV_FILE = new File("src/main/resources/books.csv");
    private static final Properties DB_SETTINGS = new Properties();
    private static final Configuration CONFIG;

    static {
        try {
            DB_SETTINGS.load(FindBooksFromDatabase.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CONFIG = new Configuration();
        CONFIG.configure("hibernate.cfg.for.lesson25.homework.xml");
    }

    public static void main(String[] args) {

        Set<Author> authorList = new LinkedHashSet<>();
        Set<Series> seriesList = new LinkedHashSet<>();
        Set<Book> booksList = new LinkedHashSet<>();

        System.out.println("Заполняем базу данных...");
        List<CsvItem> itemsList = readFromCSV();
        fillDatabase(itemsList);
        /*if (readFromCSV(booksList, authorList, seriesList)) {
            if (fillDatabase(booksList, authorList, seriesList)) {
                System.out.println("Заполнение базы данных прошло успешно.");
            }
        }*/
    }

    private static void fillDatabase(List<CsvItem> itemsList) {
//        prepareDatabase();
        for (CsvItem item : itemsList) {
            runInsideSession(session -> {
                Author author = new Author();
                author.setName(item.getAuthor());
                session.save(author);
                Series series = new Series();
                series.setName(item.getSeries());
                session.save(series);
                Book book = new Book();
                book.setIsbn(item.getIsbn());
                book.setAuthor(author);
                book.setName(item.getName());
                book.setSeries(series);
                book.setNumberInSeries(item.getNumberInSeries());
                session.save(book);
            });
        }
    }

    private static List<CsvItem> readFromCSV() {
        List<CsvItem> parseResult;
        try (FileReader reader = new FileReader(CSV_FILE);
        ) {
            parseResult = new CsvToBeanBuilder<CsvItem>(new CSVReaderBuilder(new FileReader(CSV_FILE))
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                    /*.withSkipLines(1)*/
                    .build())
                    .withType(CsvItem.class)
                    .build()
                    .parse();
            /*String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                records.add(nextRecord);
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
            }*/
        } catch (FileNotFoundException e) {
            System.out.printf("Файл %s не найден.\n", CSV_FILE);
            return null;
        } catch (IOException e) {
            System.out.printf("При считывании из файла %s произошла ошибка ввода-вывода.\n", CSV_FILE);
            return null;
        } /*catch (CsvValidationException e) {
            System.out.printf("Файл %s имеет ошибки внутренней структуры, что не позволяет его полноценно прочитать.\n", CSV_FILE);
            return false;
        }*/
        return parseResult;
    }

    private static Object findFromList(Set<?> list, Object target) {
        for (Object item : list) {
            if (item.equals(target)) {
                return item;
            }
        }
        return null;
    }

    /*private static boolean fillDatabase(Set<Book> booksList, Set<Author> authorList, Set<Series> seriesList) {
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

            prepareDatabase(st);

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
    }*/

    private static void prepareDatabase() {
        runInsideSession(session -> {
            session.createNativeQuery("""
                                    create table if not exists authors
                                    (
                                        id int auto_increment primary key,
                                        name varchar(255) not null,
                                        constraint authors_name_uindex unique (name)
                                    );
                    """).executeUpdate();

            session.createNativeQuery("""
                    create table if not exists series
                    (
                        id int auto_increment primary key,
                        name varchar(255) not null,
                        constraint series_name_uindex unique (name)
                    );
                    """).executeUpdate();
            session.createNativeQuery("""
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
                    """).executeUpdate();
            session.createNativeQuery("delete from books;").executeUpdate();
            session.createNativeQuery("delete from authors;").executeUpdate();
            session.createNativeQuery("delete from series;").executeUpdate();
            session.createNativeQuery("alter table books auto_increment=1;").executeUpdate();
            session.createNativeQuery("alter table authors auto_increment=1;").executeUpdate();
            session.createNativeQuery("alter table series auto_increment=1;").executeUpdate();

        });
    }

    public static void runInsideSession(Consumer<Session> consumer) {
        try (final Session session = getCurrentSessionFromConfig()) {
            Transaction transaction = session.beginTransaction();
            consumer.accept(session);
            transaction.commit();
        }
    }

    public static Session getCurrentSessionFromConfig() {
        // local SessionFactory bean created
        SessionFactory sessionFactory = CONFIG.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
