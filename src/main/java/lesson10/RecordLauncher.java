package lesson10;

public class RecordLauncher {
    public static void main(String[] args) {
        PrinterRecord printerRecord = new PrinterRecord("", "");
        printerRecord.source();
        printerRecord.text();

        PrinterRecordAnalog printerRecord2 = new PrinterRecordAnalog("", "");
        printerRecord2.source();
        printerRecord2.text();
    }
}
