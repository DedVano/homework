package lesson18.homework.threads;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Writer extends Thread {
    private final String fileNameMask;
    private final String fileExtension;
    private final BlockingQueue<String> strings;

    public Writer(String fileNameMask, String fileExtension, BlockingQueue<String> strings) {
        this.fileNameMask = fileNameMask;
        this.fileExtension = fileExtension;
        this.strings = strings;
    }

    @Override
    public void run() {
        int fileNumber = 1;
        while (!Thread.currentThread().isInterrupted()) {
            String string;
            try {
                string = strings.poll(3000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Процесс записи прерван.");
                continue;
            }
            if (string != null) {
                try (FileWriter fw = new FileWriter(fileNameMask + fileNumber + fileExtension)) {
                    fw.write(string);
                } catch (IOException e) {
                    System.out.println("Произошла ошибка ввода-вывода.");
                }
            } else {
                Thread.currentThread().interrupt();
            }
            fileNumber++;
        }
    }
}
