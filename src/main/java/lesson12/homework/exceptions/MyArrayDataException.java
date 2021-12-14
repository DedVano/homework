package lesson12.homework.exceptions;

/**
 * Вызывается в случае несоответствия типа данных в какой-либо ячейке матрицы,передаваемой в качестве аргумента методу,
 * заданному. Поскольку данное исключение может быть сгенерировано в процессе обычного выполнения кода и никак не связано
 * с обращением к каким-либо внешним системам ввода-вывода и прочими ситуациями с непредсказуемым риском,
 * оно наследуется от класса RuntimeException и является непроверяемым (unchecked).
 */
public class MyArrayDataException extends RuntimeException {
    int rowCausedProblem;
    int columnCausedProblem;
    String wrongField;

    /**
     * Создает новое исключение с сопроводительным сообщением, номерами строки и столбца, в которых обнаружен
     * неверный элемент, и значением самого элемента.
     *
     * @param message       сопроводительное сообщение
     * @param problemRow    номер строки передаваемой матрицы, в которой обнаружен неверный элемент
     * @param problemColumn номер столбца передаваемой матрицы, в котором обнаружен неверный элемент
     * @param wrongField    значение неверного элемента
     */
    public MyArrayDataException(String message, int problemRow, int problemColumn, String wrongField) {
        super(message);
        this.rowCausedProblem = problemRow;
        this.columnCausedProblem = problemColumn;
        this.wrongField = wrongField;
    }

    public int getRowCausedProblem() {
        return rowCausedProblem;
    }

    public int getColumnCausedProblem() {
        return columnCausedProblem;
    }

    public String getWrongField() {
        return wrongField;
    }
}
