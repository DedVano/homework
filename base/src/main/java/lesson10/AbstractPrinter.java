package lesson10;

public abstract class AbstractPrinter {
    private String source;

    public AbstractPrinter(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
