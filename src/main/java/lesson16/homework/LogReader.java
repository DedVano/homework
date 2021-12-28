package lesson16.homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public record LogReader(String logFileName) {

    public void printAndDeleteLog() {
        try (BufferedReader lineReader = new BufferedReader(new FileReader(logFileName))) {
            String line = lineReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = lineReader.readLine();
            }
            lineReader.close();
            Files.deleteIfExists(Path.of(logFileName));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка. Файл не найден.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода.");
        }
    }
}
