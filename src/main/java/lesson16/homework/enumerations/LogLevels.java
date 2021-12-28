package lesson16.homework.enumerations;

public enum LogLevels {
    ERROR(1),
    WARN(2),
    INFO(3),
    DEBUG(4),
    TRACE(5);

    private int logLevel;

    LogLevels(int logLevel) {
        this.logLevel = logLevel;
    }
}
