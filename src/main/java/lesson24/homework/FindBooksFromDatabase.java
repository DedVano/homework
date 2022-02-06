package lesson24.homework;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class FindBooksFromDatabase {

    private static final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(FindBooksFromDatabase.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (final Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));
             final PreparedStatement prepStForFindContext = connection.prepareStatement("""
                     select b.id, b.isbn, a.name, b.name, s.name, b.number_in_series from books b
                        join authors a on a.id = b.author
                        join series s on s.id = b.series
                        where (lower(b.name) like ?) or (lower(a.name) like ?) or (lower(s.name) like ?);
                     """)
        ) {
            System.out.println("Введите название книги, имя автора или название серии для поиска:");
            System.out.println("Для просмотра всех книг в базе данных просто нажмите Enter, не указывая текст для запроса.");
            System.out.println("Для выхода введите 'выход'.");
            Scanner scanner = new Scanner(System.in);
            String order;
            do {
                order = scanner.nextLine();
                if (order.equalsIgnoreCase("выход")) {
                    continue;
                }
                prepStForFindContext.setString(1, "%" + order + "%");
                prepStForFindContext.setString(2, "%" + order + "%");
                prepStForFindContext.setString(3, "%" + order + "%");
                ResultSet resultSet = prepStForFindContext.executeQuery();
                if (resultSet.isBeforeFirst()) {
                    System.out.print("\nНайдены следующие книги:\n\n");
                } else {
                    System.out.print("По данному запросу книг не найдено.\n\n");
                }
                while (resultSet.next()) {
                    System.out.println("ID книги: " + resultSet.getInt("b.id"));
                    System.out.println("ISBN: " + resultSet.getString("b.isbn"));
                    System.out.println("Автор: " + resultSet.getString("a.name"));
                    System.out.println("Название книги: " + resultSet.getString("b.name"));
                    String series = resultSet.getString("s.name");
                    if (!series.equals("")) {
                        System.out.println("Входит в серию: " + series);
                        System.out.println("Номер в серии: " + resultSet.getInt("b.number_in_series"));
                    }
                    System.out.println();
                }
                System.out.println("Введите следующий запрос для поиска или 'выход' для прекращения работы.");
            } while (!order.equalsIgnoreCase("выход"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
