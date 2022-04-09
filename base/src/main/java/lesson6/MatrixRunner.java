package lesson6;

import java.util.Arrays;

public class MatrixRunner {

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];
        //int[][] matrix1 = new int[][];
        fillFugure(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void fillFugure(int[][] array) {
        for(int i = 0; i < array.length; i++) { // перебор строк таблицы
            for (int j = 0; j < array[i].length; j++) { // перебор столбцов
                array[i][j] = i == j ? 1 : 0;
            }
        }
    }
}
