package lesson12.homework.exceptions;

/**
 * Вызывается в случае несовпадения размера матрицы, передаваемой в качестве аргумента метода, с ожидаемым размером.
 * Поскольку данное исключение может быть сгенерировано в процессе обычного выполнения кода и никак не связано
 * с обращением к каким-либо внешним системам ввода-вывода и прочими ситуациями с непредсказуемым риском,
 * оно наследуется от класса RuntimeException и является непроверяемым (unchecked).
 */
public class MyArraySizeException extends RuntimeException {
    private final int incomingArrayRows;
    private final boolean problemInRowsQuantity;
    private final int rowCausedProblem;
    private final int lengthOfProblemRow;

    /**
     * Создает новое исключение для случая несовпадения количества строк передаваемой матрицы заданному, с сопроводительным
     * сообщением и количеством строк в передаваемой матрице.
     *
     * @param message               сопроводительное сообщение к исключению
     * @param incomingArrayRows     количество строк в передаваемой матрице
     */
    public MyArraySizeException(String message, int incomingArrayRows) {
        super(message);
        this.problemInRowsQuantity = true;
        this.incomingArrayRows = incomingArrayRows;
        this.rowCausedProblem = this.lengthOfProblemRow = 0;
    }

    /**
     * Создает новое исключение для случая несовпадения количества столбцов передаваемой матрицы заданному, с сопроводительным
     * сообщением, номером строки, вызвавшей исключение, и количеством столбцов в ней.
     *
     * @param message            сопроводительное сообщение к исключению
     * @param rowCausedProblem   номер строки передаваемой матрицы, в которой обнаружено несовпадение количества столбцов
     * @param lengthOfProblemRow количество столбцов в обнаруженной строке передаваемой матрицы
     */
    public MyArraySizeException(String message, int rowCausedProblem, int lengthOfProblemRow) {
        super(message);
        this.problemInRowsQuantity = false;
        this.incomingArrayRows = 0;
        this.rowCausedProblem = rowCausedProblem;
        this.lengthOfProblemRow = lengthOfProblemRow;
    }

    public int getIncomingArrayRows() {
        return incomingArrayRows;
    }

    public boolean isProblemInRowsQuantity() {
        return problemInRowsQuantity;
    }

    public int getRowCausedProblem() {
        return rowCausedProblem;
    }

    public int getLengthOfProblemRow() {
        return lengthOfProblemRow;
    }
}
