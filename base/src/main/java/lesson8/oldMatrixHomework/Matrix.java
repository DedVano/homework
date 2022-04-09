package lesson8.oldMatrixHomework;

public class Matrix {

    private int rows;
    private int columns;
    private int[][] array;
    public static int[][] UNIT_MATRIX_5X5 = {
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1}};


    //---------------------- конструкторы --------------------------------------------------
    public Matrix(int rows, int columns, int[][] array) {
        this.rows = rows;
        this.columns = columns;
        this.array = array;
    }

    public Matrix() {
        this.rows = 2;
        this.columns = 2;
        this.array = new int[rows][columns];
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.array = new int[rows][columns];
    }

    //----------------------- методы ----------------------------------------------------------
    public void fillMatrix() {
        for (int y = 0; y < this.rows; y++) {
            for (int x = 0; x < this.columns; x++) {
                this.array[y][x] = (int) Math.round(Math.random() * 51);
            }
        }
    }

    public Matrix matrixSum(Matrix matrix) {
        if (this.rows != matrix.rows || this.columns != matrix.columns) {
            System.out.println("Эти матрицы нельзя складывать, они не одинакового размера.");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int y = 0; y < this.rows; y++) {
            for (int x = 0; x < this.columns; x++) {
                newMatrix.array[y][x] = this.array[y][x] + matrix.array[y][x];
            }
        }
        return newMatrix;
    }

    public Matrix matrixSubtract(Matrix matrix) {
        if (this.rows != matrix.rows || this.columns != matrix.columns) {
            System.out.println("Эти матрицы нельзя вычитать, они не одинакового размера.");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int y = 0; y < this.rows; y++) {
            for (int x = 0; x < this.columns; x++) {
                newMatrix.array[y][x] = this.array[y][x] - matrix.array[y][x];
            }
        }
        return newMatrix;
    }

    public Matrix matrixMultiply(Matrix matrix) {
        if (this.columns != matrix.rows) {
            System.out.println("Эти матрицы нельзя умножать, не совпадает количество столбцов первой с количеством " +
                    "строк второй.");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(this.rows, matrix.columns);
        for (int y = 0; y < newMatrix.rows; y++) {
            for (int x = 0; x < newMatrix.columns; x++) {
                for (int k = 0; k < this.columns; k++) {
                    newMatrix.array[y][x] += this.array[y][k] * matrix.array[k][x];
                }
            }
        }
        return newMatrix;
    }

    public Matrix matrixMultiplyByNumber(int number) {
        if (this.rows == 0 || this.columns == 0) {
            System.out.println("Матрицу нельзя перемножить на число, потому что она пустая");
            return new Matrix(0, 0);
        }
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int y = 0; y < newMatrix.rows; y++) {
            for (int x = 0; x < newMatrix.columns; x++) {
                newMatrix.array[y][x] = this.array[y][x] * number;
            }
        }
        return newMatrix;
    }

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

    public long getDeterminant() {
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

    public Matrix getInverseMatrix() {
        if (this.rows != this.columns || this.rows == 0) {
            System.out.println("Для данной матрицы не получится найти обратную.");
            return new Matrix(0,0);
        }
        long det = this.getDeterminant();
        if (det == 0) {
            System.out.println("Для данной матрицы не получится найти обратную, поскольку её определитель равен 0.");
            return new Matrix(0,0);
        }
        MatrixWithDoubleType inverseMatrix = new MatrixWithDoubleType(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                inverseMatrix.array[j][i] = (int)getMinorMatrix(this, i, j).getDeterminant();
            }
        }
        return inverseMatrix;
    }

    private Matrix getMinorMatrix(Matrix matrix, int iMinor, int jMinor) {
        Matrix tempMatrix = new Matrix(matrix.rows - 1, matrix.columns - 1);
        for (int i = 1; i < matrix.rows; i++) {
            int jFound = 0;
            for (int j = 0; j < matrix.columns; j++) {
                if (jMinor != j) {
                    tempMatrix.array[i - 1][j - jFound] = matrix.array[i][j];
                } else {
                    jFound = 1;
                }
            }
        }
        return tempMatrix;
    }

    public void matrixReverse() {
        if (this.rows < 2 && this.columns < 2) {
            System.out.println("Эту матрицу нельзя инвертировать, потому что у нее меньше двух столбцов и строк");
            return;
        }
        int temp;
        for (int y = 0; y < this.rows; y++) {
            for (int xForward = 0, xBack = this.columns - 1; xForward <= (this.columns - 1) / 2; xForward++, xBack--) {
                temp = this.array[y][xForward];
                this.array[y][xForward] = this.array[y][xBack];
                this.array[y][xBack] = temp;
            }
        }
        for (int x = 0; x < this.columns; x++) {
            for (int yForward = 0, yBack = this.rows - 1; yForward <= (this.rows - 1) / 2; yForward++, yBack--) {
                temp = this.array[yForward][x];
                this.array[yForward][x] = this.array[yBack][x];
                this.array[yBack][x] = temp;
            }
        }
    }

    public static void matrixReverse(int[][] matrix) {
        if (matrix.length < 2 && matrix[0].length < 2) {
            System.out.println("Эту матрицу нельзя инвертировать, потому что у нее меньше двух столбцов и строк");
            return;
        }
        int temp;
        for (int y = 0; y < matrix.length; y++) {
            for (int xForward = 0, xBack = matrix[0].length - 1; xForward <= (matrix[0].length - 1) / 2; xForward++, xBack--) {
                temp = matrix[y][xForward];
                matrix[y][xForward] = matrix[y][xBack];
                matrix[y][xBack] = temp;
            }
        }
        for (int x = 0; x < matrix[0].length; x++) {
            for (int yForward = 0, yBack = matrix.length - 1; yForward <= (matrix.length - 1) / 2; yForward++, yBack--) {
                temp = matrix[yForward][x];
                matrix[yForward][x] = matrix[yBack][x];
                matrix[yBack][x] = temp;
            }
        }
    }

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

    public void matrixPrint() {
        if (this.rows == 0 || this.columns == 0) {
            System.out.println("Матрица пуста");
            return;
        }
        int maxLength = 0;
        for (int y = 0; y < this.rows; y++) {
            for (int x = 0; x < this.columns; x++) {
                maxLength = Math.max((String.valueOf(this.array[y][x])).length() + 2, maxLength);
            }
        }
        for (int y = 0; y < this.rows; y++) {
            for (int x = 0; x < this.columns; x++) {
                System.out.printf("%" + maxLength + "d", this.array[y][x]);
            }
            System.out.println();
        }
    }

    public void matrixPrint(Matrix matrix) {
        if (matrix.rows == 0 || matrix.columns == 0) {
            System.out.println("Матрица пуста");
            return;
        }
        int maxLength = 0;
        for (int y = 0; y < matrix.rows; y++) {
            for (int x = 0; x < matrix.columns; x++) {
                maxLength = Math.max((String.valueOf(matrix.array[y][x])).length() + 2, maxLength);
            }
        }
        for (int y = 0; y < matrix.rows; y++) {
            for (int x = 0; x < matrix.columns; x++) {
                System.out.printf("%" + maxLength + "d", matrix.array[y][x]);
            }
            System.out.println();
        }
    }

    public static void matrixPrint(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Матрица пуста");
            return;
        }
        int maxLength = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                maxLength = Math.max((String.valueOf(matrix[y][x])).length() + 2, maxLength);
            }
        }
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                System.out.printf("%" + maxLength + "d", matrix[y][x]);
            }
            System.out.println();
        }
    }
}
