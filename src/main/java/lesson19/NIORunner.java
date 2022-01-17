
package lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class NIORunner {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("D:", ".", "1", "..", "test.txt");
        System.out.println("Путь до файла: " + filePath);
        System.out.println("Нормальзованный путь: " + filePath.normalize());
        System.out.println("Имя файла: " + filePath.getFileName().toFile());

        Files.copy(filePath, System.out);
        System.out.println(Files.lines(filePath).collect(Collectors.joining(",")));
        Files.write(filePath, new String("\nНовая строка").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            System.out.println(bufferedReader.readLine());
        }
    }
}
