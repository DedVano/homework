package lesson8.matrixHomework;

public class Matrix {

    private final int rows;
    private final int columns;
    private final double[][] array;
    public static final int[][] UNIT_MATRIX_5X5 = {
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1}};


    //---------------------- конструкторы --------------------------------------------------
    public Matrix() {
        this.rows = 2;
        this.columns = 2;
        this.array = new double[rows][columns];
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.array = new double[rows][columns];
    }

    //----------------------- методы ----------------------------------------------------------

    /**
     * Метод заполняет матрицу объекта класса Matrix псевдослучайными целыми числами от -10 до 10
     */
    public void fillMatrix() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.array[i][j] = (double) Math.round(Math.random() * 20 - 10);
            }
        }
    }

    /**
     * Метод заполняет матрицу объекта класса Matrix значениями, содержащимися в массиве, указанном в качестве аргумента
     *
     * @param array массив, значениями которого заполняется матрица объекта
     */
    public void fillMatrixArray(double[][] array) {
        if (array.length != this.rows || array[0].length != this.columns) {
            System.out.println("Ошибка заполнения, применен несовпадающий по размерам массив.");
            return;
        }
        for (int i = 0; i < this.rows; i++) {
            System.arraycopy(array[i], 0, this.array[i], 0, this.columns);
        }
    }

    /**
     * Метод возвращает сумму матрицы объекта с матрицей второго объекта, принимаемого в качестве аргумента
     *
     * @param matrix объект, с матрицей которого производится суммирование
     * @return новый объект класса Matrix, матрица которого содержит сумму двух вышеуказанных матриц
     */
    public Matrix matrixSum(Matrix matrix) {
        if (this.rows != matrix.rows || this.columns != matrix.columns) {
            System.out.println("Эти матрицы нельзя складывать, они не одинакового размера.");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                newMatrix.array[i][j] = this.array[i][j] + matrix.array[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * Метод возвращает разность матрицы объекта и матрицы второго объекта, принимаемого в качестве аргумента
     *
     * @param matrix объект, с матрица которого вычитается из матрицы текущего объекта
     * @return новый объект класса Matrix, матрица которого содержит разность двух вышеуказанных матриц
     */
    public Matrix matrixSubtract(Matrix matrix) {
        if (this.rows != matrix.rows || this.columns != matrix.columns) {
            System.out.println("Эти матрицы нельзя вычитать, они не одинакового размера.");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                newMatrix.array[i][j] = this.array[i][j] - matrix.array[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * Метод возаращает произведение матрицы объекта с матрицей второго объекта, принимаемого в качестве аргумента
     *
     * @param matrix объект, с матрицей которого производится произведение
     * @return новый объект класса Matrix, матрица которого содержит произведение двух вышеуказанных матриц
     */
    public Matrix matrixMultiply(Matrix matrix) {
        if (this.columns != matrix.rows) {
            System.out.println("Эти матрицы нельзя умножать, не совпадает количество столбцов первой с количеством " +
                    "строк второй.");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(this.rows, matrix.columns);
        for (int i = 0; i < newMatrix.rows; i++) {
            for (int j = 0; j < newMatrix.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    newMatrix.array[i][j] += this.array[i][k] * matrix.array[k][j];
                }
            }
        }
        return newMatrix;
    }

    /**
     * Метод возаращает произведение матрицы объекта на число, принимаемое в качестве аргумента
     *
     * @param number число, на которое умножается матрица текущего объекта
     * @return новый объект класса Matrix, матрица которого содержит произведение матрицы на число
     */
    public Matrix matrixMultiplyByNumber(double number) {
        if (this.rows == 0 || this.columns == 0) {
            System.out.println("Матрицу нельзя перемножить на число, потому что она пустая");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < newMatrix.rows; i++) {
            for (int j = 0; j < newMatrix.columns; j++) {
                newMatrix.array[i][j] = this.array[i][j] * number;
            }
        }
        return newMatrix;
    }

    /**
     * Метод производит возведение матрицы текущего объекта в квадрат
     *
     * @return новый объект класса Matrix, матрица которого содержит возведенную в квадрат матрицу текущего объекта
     */
    public Matrix raiseToPower2() {
        if (this.rows == 0 || this.columns == 0) {
            System.out.println("Эту матрицу нельзя возвести в квадрат, потому что она пустая");
            return new Matrix(0, 0);
        } else if (this.rows != this.columns) {
            System.out.println("Эту матрицу нельзя возвести в квадрат, потому что она не квадратная");
            return new Matrix(0, 0);
        }
        return this.matrixMultiply(this);
    }

    /**
     * Метод производит возведение матрицы текущего объекта в куб
     *
     * @return новый объект класса Matrix, матрица которого содержит возведенную в куб матрицу текущего объекта
     */
    public Matrix raiseToPower3() {
        if (this.rows == 0 || this.columns == 0) {
            System.out.println("Эту матрицу нельзя возвести в куб, потому что она пустая");
            return new Matrix(0, 0);
        } else if (this.rows != this.columns) {
            System.out.println("Эту матрицу нельзя возвести в куб, потому что она не квадратная");
            return new Matrix(0, 0);
        }
        return this.matrixMultiply(this.matrixMultiply(this));
    }

    /**
     * Медод производит вычисление детерминанта матрицы объекта
     *
     * @return детерминант матрицы
     */
    public double getDeterminant() {
        if (this.rows != this.columns || this.rows == 0) {
            System.out.println("Для данной матрицы не получится найти детерминант.");
            return 0;
        }
        if (this.rows == 1) {
            return this.array[0][0];
        }
        int det = 0;
        for (int jMinor = 0; jMinor < this.columns; jMinor++) {
            Matrix tempMatrix = getMinorMatrix(this, 0, jMinor);
            int sign = jMinor % 2 == 0 ? 1 : -1;
            det += sign * this.array[0][jMinor] * tempMatrix.getDeterminant();
        }
        return det;
    }

    /**
     * Матод производит вычисление обратной матрицы для матрицы объекта
     *
     * @return объект класса Matrix, содержащий обратную матрицу для текущего объекта
     */
    public Matrix getInverseMatrix() {
        if (this.rows != this.columns || this.rows == 0) {
            System.out.println("Для данной матрицы не получится найти обратную.");
            return new Matrix(0, 0);
        }
        double det = this.getDeterminant();
        if (det == 0) {
            System.out.println("Для данной матрицы не получится найти обратную, поскольку её определитель равен 0.");
            return new Matrix(0, 0);
        }
        Matrix inverseMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                int sign = (i + j) % 2 == 0 ? 1 : -1;
                inverseMatrix.array[j][i] = sign * getMinorMatrix(this, i, j).getDeterminant();
            }
        }
        inverseMatrix = inverseMatrix.matrixMultiplyByNumber(1 / det);
        return inverseMatrix;
    }

    /**
     * Метод производит вычисление ранга матрицы для объекта
     *
     * @return значение ранга матрицы для текущего объекта
     */
    public int getMatrixRang() {
        int rang = 0;
        int order = 1;
        while (order <= Math.min(this.rows, this.columns)) {
            Matrix minorMatrix = new Matrix(order, order);
            for (int iSource = 0; iSource < (this.rows - (order - 1)); iSource++) {
                for (int jSource = 0; jSource < (this.columns - (order - 1)); jSource++) {
                    for (int i = 0; i < order; i++) {
                        System.arraycopy(this.array[iSource + i], jSource, minorMatrix.array[i], 0, order);
                    }
                    if (minorMatrix.getDeterminant() != 0) {
                        rang = order;
                    }
                }
            }
            order++;
        }
        return rang;
    }

    /**
     * Вспомогательный метод для расчета определителя и обратной матрицы. Вычленяет из матрицы объекта минорную матрицу   <br>
     * по заданным координатам столбцов и строк
     *
     * @param matrix объект, из матрицы которого следует найти минорную матрицу
     * @param iMinor номер строки, которую следует убрать из исходной матрицы
     * @param jMinor номер стролбца, который следует убрать из исходной матрицы
     * @return новый объект класса Matrix, содержащий в себе минорную матрицу для текущего объекта
     */
    private Matrix getMinorMatrix(Matrix matrix, int iMinor, int jMinor) {
        Matrix tempMatrix = new Matrix(matrix.rows - 1, matrix.columns - 1);
        int iFound = 0;
        for (int i = 0; i < matrix.rows; i++) {
            int jFound = 0;
            for (int j = 0; j < matrix.columns; j++) {
                if (jMinor != j && iMinor != i) {
                    tempMatrix.array[i - iFound][j - jFound] = matrix.array[i][j];
                } else if (j == jMinor) {
                    jFound = 1;
                } else {
                    iFound = 1;
                }
            }
        }
        return tempMatrix;
    }

    /**
     * Метод транспонирует матрицу текущего объекта, т.е. меняет строки со столбцами местами
     *
     * @return новый объект класса Matrix, содержащий транспонированную матрицу
     */
    public Matrix matrixTransposition() {
        if (this.rows < 1 && this.columns < 1) {
            System.out.println("Эту матрицу нельзя транспонировать, потому что у нее меньше одного столбца или строки");
            return new Matrix(0, 0);
        }
        Matrix transposedMatrix = new Matrix(this.columns, this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                transposedMatrix.array[j][i] = this.array[i][j];
            }
        }
        return transposedMatrix;
    }

    /**
     * Статичный метод класса для транспонирования матриц, т.е. для смены столбцов и строк матрицы местами
     *
     * @param matrix двумерный массив, содержащий матрицу для транспонирования
     * @return двумерный массив, содержащий транспонированную матрицу
     */
    public static int[][] matrixTransposition(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Эту матрицу нельзя транспонировать, потому что у нее меньше одного столбца или строки");
            return new int[0][0];
        }
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    /**
     * Метод зеркально отражает матрицу объекта одновременно по вертикали и по горизонтали.
     * Изменения затрагивают непосредственно матрицу объекта.
     */
    public void matrixMirror() {
        if (this.rows < 2 && this.columns < 2) {
            System.out.println("Эту матрицу нельзя перевернуть, потому что у нее меньше двух столбцов и строк");
            return;
        }
        double temp;
        for (int i = 0; i < this.rows; i++) {
            for (int jForward = 0, jBack = this.columns - 1; jForward <= this.columns / 2 - 1; jForward++, jBack--) {
                temp = this.array[i][jForward];
                this.array[i][jForward] = this.array[i][jBack];
                this.array[i][jBack] = temp;
            }
        }
        for (int j = 0; j < this.columns; j++) {
            for (int iForward = 0, iBack = this.rows - 1; iForward <= this.rows / 2 - 1; iForward++, iBack--) {
                temp = this.array[iForward][j];
                this.array[iForward][j] = this.array[iBack][j];
                this.array[iBack][j] = temp;
            }
        }
    }

    /**
     * Медод генерирует единичную матрицу заданного размера
     *
     * @param size размер генерируемой матрицы
     * @return новый объект класса Matrix, содержащий единичную матрицу
     */
    public static Matrix getUnitMatrix(int size) {
        if (size <= 0) {
            System.out.println("Не получается создать единичную матрицу нулевого или отрицательного размера");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(size, size);
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (x == y) {
                    newMatrix.array[y][x] = 1;
                }
            }
        }
        return newMatrix;
    }

    /**
     * Медод производит форматированный вывод в консоль значений матрицы объекта.       <br>
     * Для удобства просмотра дробные числа округляются до 7 знаков после точки,      <br>
     * целые числа отображаются бех десятичной точки.
     */
    public void matrixPrint() {
        if (this.rows == 0 || this.columns == 0) {
            System.out.println("Матрица пуста");
            return;
        }
        int maxLength = 0;
        String digitsAfterDot = ".0";
        boolean intOnly = true;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                maxLength = Math.max((String.valueOf((int) this.array[i][j])).length() + 2, maxLength);
                if (Math.round(this.array[i][j] * 1_000_000) / 1_000_000 != Math.round(this.array[i][j])) {
                    intOnly = false;
                }
            }
        }
        if (!intOnly) {
            maxLength += 8;
            digitsAfterDot = ".7";
        }
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.printf("%" + maxLength + digitsAfterDot + "f", this.array[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * Статичный метод класса. Производит форматированный вывод в консоль значений матрицы,   <br>
     * принимаемой с качестве аргумента.                                                      <br>
     * Для удобства просмотра дробные числа округляются до 7 знаков после точки,              <br>
     * целые числа отображаются бех десятичной точки.
     *
     * @param matrix двумерный массив, содержащий матрицу, подлежащую отображению
     */
    public static void matrixPrint(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Матрица пуста");
            return;
        }
        int maxLength = 0;
        for (int[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLength = Math.max((String.valueOf(row[j])).length() + 2, maxLength);
            }
        }
        for (int[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%" + maxLength + "d", row[j]);
            }
            System.out.println();
        }
    }
}
