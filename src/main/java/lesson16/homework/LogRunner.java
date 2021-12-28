package lesson16.homework;

import lesson16.homework.enumerations.LogLevels;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LogRunner {

    public static void main(String[] args) throws InterruptedException {

        String fileName = "test.log";

        System.out.println("Удаляем старый файл журнала, если он есть...");
        try {
            Files.deleteIfExists(Path.of(fileName));
        } catch (IOException e) {
            System.out.println("При удалении файла произошла ошибка ввода-вывода.");
        }

        System.out.println("Начинаем процесс записи в журнал.");
        Logger thread1 = new Logger("Поток 1", LogLevels.values()[(int) (Math.floor(Math.random() *
                LogLevels.values().length))], fileName);
        Logger thread2 = new Logger("Поток 2", LogLevels.values()[(int) (Math.floor(Math.random() *
                LogLevels.values().length))], fileName);
        Logger thread3 = new Logger("Поток 3", LogLevels.values()[(int) (Math.floor(Math.random() *
                LogLevels.values().length))], fileName);
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(60_000);
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        System.out.println("Запись окончена. Посмотрим, что у нас получилось:");
        new LogReader(fileName).printAndDeleteLog();
    }
}
