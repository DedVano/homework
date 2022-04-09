package lesson18.homework.threads;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

@RequiredArgsConstructor
public class Reader extends Thread {
    private final String fileName;
    private final BlockingQueue<String> strings;

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                strings.put(line);
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
