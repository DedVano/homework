package lesson10;

public class PrinterRecordAnalog {
    private final String text;
    private final String source;

    public PrinterRecordAnalog (String text, String source) {
        this.text = text;
        this.source = source;
    }

    public String text() {
        return text;
    }
    public String source() {
        return source;
    }
}
