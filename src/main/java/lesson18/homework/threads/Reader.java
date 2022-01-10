package lesson18.homework.threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Reader extends Thread {
    private final String fileName;
    private final BlockingQueue<String> strings;

    public Reader(String fileName, BlockingQueue<String> strings) {
        this.fileName = fileName;
        this.strings = strings;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                strings.put(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден");
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Процесс чтения прерван.");
        }
    }
}
