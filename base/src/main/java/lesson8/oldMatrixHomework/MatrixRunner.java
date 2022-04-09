package lesson8.oldMatrixHomework;

public class MatrixRunner {

    public static void main(String[] args) {

//        int [][] array1 = new int[][] {{1,0,0,0},{0,1,0,0},{0,0,0,0}};
//        int[][] array2 = new int[][] {{1,2,3},{1,1,1},{0,0,0},{2,1,0}};
//        Matrix matrix1 = new Matrix(3,4, array1);
//        Matrix matrix2 = new Matrix(4, 3, array2);
        Matrix matrix1 = new Matrix(15, 12);
        Matrix matrix2 = new Matrix(12, 16);
        matrix1.fillMatrix();
        matrix2.fillMatrix();
        Matrix matrix3 = new Matrix(5, 7);
        Matrix matrix4 = new Matrix(5, 7);
        matrix3.fillMatrix();
        matrix4.fillMatrix();

        System.out.println("Матрица 1");
        matrix1.matrixPrint();
        System.out.println("Матрица 2");
        matrix2.matrixPrint();
        System.out.println();

        System.out.println("Произведение матриц:");
        Matrix multipliedMatrix = matrix1.matrixMultiply(matrix2);
        multipliedMatrix.matrixPrint();
        System.out.println();

        System.out.println("Матрица 1");
        matrix3.matrixPrint();
        System.out.println("Матрица 2");
        matrix4.matrixPrint();

        System.out.println("Сумма матриц:");
        Matrix summedMatrix = matrix3.matrixSum(matrix4);
        summedMatrix.matrixPrint();
        System.out.println();

        System.out.println("Разность матриц:");
        Matrix subtractedMatrix = matrix3.matrixSubtract(matrix4);
        subtractedMatrix.matrixPrint();
        System.out.println();

        int numberForMultiply = 5;
        System.out.println("Произведение матрицы 1 на число " + numberForMultiply + ":");
        Matrix matrixMultipliedByNumber = matrix3.matrixMultiplyByNumber(numberForMultiply);
        matrixMultipliedByNumber.matrixPrint();
        System.out.println();

        matrix3.matrixReverse();
        System.out.println("Инвертированная матрица 1:");
        matrix3.matrixPrint();
        System.out.println();

        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        System.out.println("Исходная матрица перед инвертированием:");
        Matrix.matrixPrint(array);
        Matrix.matrixReverse(array);
        System.out.println("Инвертированная матрица:");
        Matrix.matrixPrint(array);
        System.out.println();

        int[][] array2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Matrix matrix5 = new Matrix(3, 3, array2);
        System.out.println("Исходная матрица перед возведением в степень:");
        matrix5.matrixPrint();
        System.out.println("Матрица в квадрате:");
        Matrix matrixToSquare = matrix5.raiseToPower2();
        matrixToSquare.matrixPrint();
        System.out.println("Матрица в кубе:");
        Matrix matrixToCube = matrix5.raiseToPower3();
        matrixToCube.matrixPrint();
        System.out.println();

        System.out.println("Единичная матрица (из статичного поля):");
        Matrix.matrixPrint(Matrix.UNIT_MATRIX_5X5);
        System.out.println("Единичная матрица (сгенерированная методом:");
        Matrix unitMatrix = Matrix.getUnitMatrix(7);
        unitMatrix.matrixPrint();
        System.out.println();

        int[][] array3 = new int[][]{
                {2, 7, 3},//, 7, 9, 0},
                {3, 9, 4},//, 6, 0, 12},
                {1, 5, 3}};//, 45, 21},
//                {34, 21, 32, 1, 6},
//                {2, 76, 12, 3, 12}};
        Matrix matrix6 = new Matrix(3, 3, array3);
        System.out.println("Детерминант матрицы:");
        System.out.println(matrix6.getDeterminant());
        System.out.println("Обратная матрица:");
        matrix6.getInverseMatrix().matrixPrint();


    }
}
