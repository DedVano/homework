package lesson18;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class InputStreamRunner {
    @SneakyThrows(IOException.class)
    public static void main(String[] args) {
        try (InputStream fileInputStream = InputStreamRunner.class.getResourceAsStream("/file.txt")) {
            byte[] bytes = fileInputStream.readAllBytes();
            System.out.println(new String(bytes));
//            fileInputStream.close();
        }

        try (InputStream inputStream = InputStreamRunner.class.getResourceAsStream("/file.txt");
             FileOutputStream out = new FileOutputStream("D:\\newfile.txt")) {
            assert inputStream != null;
            inputStream.transferTo(out);
//            out.close();
//            inputStream.close();
        }

        char[] buffer = new char[512];
        String result = "";
        try (FileReader fileReader = new FileReader("D:\\newfile.txt")) {
            while (fileReader.read(buffer) != -1) {
                result += new String(buffer);
            }
        }
        System.out.println("Чтение файла завершено, его содержимое:\n" + result);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        InputStreamRunner.class.getResourceAsStream("/file.txt"), StandardCharsets.ISO_8859_1.name()))) {
            System.out.println(br.lines().collect(Collectors.joining()));
        }
    }
}
