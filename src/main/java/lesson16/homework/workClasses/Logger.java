package lesson16.homework.workClasses;

import lesson16.homework.enumerations.LogLevels;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Logger extends Thread {
    private final String threadName;
    private final LogLevels logLevel;
    private final String fileName;
    private int messagesCount;

    public Logger(String threadName, LogLevels logLevel, String fileName) {
        this.threadName = threadName;
        this.logLevel = logLevel;
        this.fileName = fileName;
        this.messagesCount = 0;
    }

    public void run() {
        while (!currentThread().isInterrupted()) {
            try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                String formattedLogLevel = String.format("<%s>", this.logLevel);
                String message = String.format("<%tF> <%<tT.%<tL> %7s Служебное сообщение процесса '%s' #%d.\n",
                        new Date(), formattedLogLevel, this.threadName, this.messagesCount + 1);
                String messageLine1 = String.format("%36sСтрока 1 сообщения #%d процесса '%s'.\n", " ",
                        this.messagesCount + 1, this.threadName);
                String messageLine2 = String.format("%36sСтрока 2 сообщения #%d процесса '%s'.\n", " ",
                        this.messagesCount + 1, this.threadName);
                String messageLine3 = String.format("%36sСтрока 3 сообщения #%d процесса '%s'.\n", " ",
                        this.messagesCount + 1, this.threadName);
                fileWriter.write(message);
                fileWriter.write(messageLine1);
                fileWriter.write(messageLine2);
                fileWriter.write(messageLine3);
                fileWriter.close();
                this.messagesCount++;
                Thread.sleep(new Random().nextInt(5000));
            } catch (IOException ioe) {
                System.out.println("Произошла ошибка ввода-вывода.");
            } catch (InterruptedException ie) {
                break;
            }
        }
    }
}
