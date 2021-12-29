package lesson17;

import lesson17.thread.FlagThread;

import java.util.concurrent.atomic.AtomicBoolean;

public class FlagRunner {

    public static void main(String[] args) throws Exception {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        FlagThread flagThread = new FlagThread(atomicBoolean);
        flagThread.start();
        Thread.sleep(5000);
        atomicBoolean.set(true);
//        flagThread.interrupt();
    }
}
