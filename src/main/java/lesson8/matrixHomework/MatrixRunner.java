package lesson8.matrixHomework;

public class MatrixRunner {

    public static void main(String[] args) {

        Matrix matrix1 = new Matrix(8, 5);
        Matrix matrix2 = new Matrix(5, 9);
        Matrix sameSizeMatrix1 = new Matrix(5, 7);
        Matrix sameSizeMatrix2 = new Matrix(5, 7);
        Matrix squareMatrix = new Matrix(4, 4);
        matrix1.fillMatrix();
        matrix2.fillMatrix();
        sameSizeMatrix1.fillMatrix();
        sameSizeMatrix2.fillMatrix();
        squareMatrix.fillMatrix();

        System.out.println("Матрица 1");
        matrix1.matrixPrint();
        System.out.println("Матрица 2");
        matrix2.matrixPrint();
        System.out.println();
        System.out.println("Произведение матриц 1 и 2:");
        Matrix multipliedMatrix = matrix1.matrixMultiply(matrix2);
        multipliedMatrix.matrixPrint();
        System.out.println();

        System.out.println("Матрица 3");
        sameSizeMatrix1.matrixPrint();
        System.out.println("Матрица 4");
        sameSizeMatrix2.matrixPrint();
        System.out.println("Сумма матриц 3 и 4:");
        sameSizeMatrix1.matrixSum(sameSizeMatrix2).matrixPrint();
        System.out.println();
        System.out.println("Разность матриц 3 и 4:");
        sameSizeMatrix1.matrixSubtract(sameSizeMatrix2).matrixPrint();
        System.out.println();

        int numberForMultiply = 5;
        System.out.println("Произведение матрицы 3 на число " + numberForMultiply + ":");
        sameSizeMatrix1.matrixMultiplyByNumber(numberForMultiply).matrixPrint();
        System.out.println();

        System.out.println("Транспонированная матрица 3:");
        sameSizeMatrix1.matrixTransposition().matrixPrint();
        System.out.println();

        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        System.out.println("Исходная матрица перед транспонированием:");
        Matrix.matrixPrint(array);
        array = Matrix.matrixTransposition(array);
        System.out.println("Транспонированная матрица:");
        Matrix.matrixPrint(array);
        System.out.println();

        System.out.println("Исходная матрица перед возведением в степень:");
        squareMatrix.matrixPrint();
        System.out.println("Матрица в квадрате:");
        squareMatrix.raiseToPower2().matrixPrint();
        System.out.println("Матрица в кубе:");
        squareMatrix.raiseToPower3().matrixPrint();
        System.out.println();

        System.out.println("Единичная матрица (из статичного поля):");
        Matrix.matrixPrint(Matrix.UNIT_MATRIX_5X5);
        System.out.println("Единичная матрица (сгенерированная методом:");
        Matrix unitMatrix = Matrix.getUnitMatrix(7);
        unitMatrix.matrixPrint();
        System.out.println();

        double[][] squareArray = new double[][]{
                {2, 5, 7},
                {6, 3, 4},
                {5, -2, -3}};
        Matrix anotherSquareMatrix = new Matrix(3, 3);
        anotherSquareMatrix.fillMatrixArray(squareArray);
        System.out.println("Исходная матрица (искусственно подобранная):");
        anotherSquareMatrix.matrixPrint();
        System.out.println("Детерминант матрицы:");
        System.out.println(anotherSquareMatrix.getDeterminant());
        System.out.println("Обратная матрица:");
        anotherSquareMatrix.getInverseMatrix().matrixPrint();
        System.out.println("Проверяем:");
        anotherSquareMatrix.getInverseMatrix().matrixMultiply(anotherSquareMatrix).matrixPrint();

        System.out.println("Исходная матрица (случайным образом заполненная):");
        squareMatrix.matrixPrint();
        System.out.println("Детерминант матрицы:");
        System.out.println(squareMatrix.getDeterminant());
        System.out.println("Обратная матрица (при слишком малых значениях из-за округления могут отобразиться нули):");
        squareMatrix.getInverseMatrix().matrixPrint();
        System.out.println("Проверяем:");
        squareMatrix.getInverseMatrix().matrixMultiply(squareMatrix).matrixPrint();

        System.out.println("Исходная матрица:");
        sameSizeMatrix1.matrixPrint();
        System.out.println("Ранг матрицы:");
        System.out.println(sameSizeMatrix1.getMatrixRang());
        System.out.println("Перевернутая матрица:");
        sameSizeMatrix1.matrixMirror();
        sameSizeMatrix1.matrixPrint();

        System.out.println("Размер матрицы 1 - " + matrix1.getRows() + " строк и " + matrix1.getColumns() + " столбцов.");
    }
}
