package lesson16.concurency;


public class PrinterThread extends Thread {

    private final String value;
    private final int count;

    public PrinterThread(String val, int count) {
        this.value = val;
        this.count = count;
    }

    public PrinterThread(String name, String val, int count) {
        super(name);
//        setName(name);
        this.value = val;
        this.count = count;
        setPriority(MAX_PRIORITY);
        setDaemon(false);
    }
    public PrinterThread(String val, int count, boolean daemon) {
        this.value = val;
        this.count = count;
        setPriority(MAX_PRIORITY);
        setDaemon(daemon);
    }

    @Override
    public void run() {
        //super.run();
        for (int i = 0; i < count; i++) {
            System.out.println(this.getName() + ":" + value);
        }
    }
}
