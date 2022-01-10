package lesson18.homework;

import lesson18.homework.threads.Reader;
import lesson18.homework.threads.Writer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Runner {

    public static void main(String[] args) {

        String filename = "src/main/resources/test.txt";
        String outputFilenameMask = "src/main/resources/outfile-";
        String outputFileExtension = ".txt";

        BlockingQueue<String> strings = new LinkedBlockingQueue<>(5);
        new Reader(filename, strings).start();
        new Writer(outputFilenameMask, outputFileExtension, strings).start();
    }
}
