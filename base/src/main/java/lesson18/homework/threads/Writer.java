package lesson18.homework.threads;

import lombok.RequiredArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Writer extends Thread {
    private final String fileNameMask;
    private final String fileExtension;
    private final BlockingQueue<String> strings;

    @Override
    public void run() {
        int fileNumber = 1;
        while (!Thread.currentThread().isInterrupted()) {
            String string;
            try {
                string = strings.poll(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Процесс записи прерван.");
                break;
            }
            if (string != null) {
                writeFile(fileNumber, string);
            } else {
                Thread.currentThread().interrupt();
            }
            fileNumber++;
        }
    }

    private void writeFile(int fileNumber, String string) {
        try (FileWriter fw = new FileWriter(fileNameMask + fileNumber + fileExtension)) {
            fw.write(string);
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода.");
        }
    }
}
