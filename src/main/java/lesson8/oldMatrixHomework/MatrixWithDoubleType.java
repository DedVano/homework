package lesson8.oldMatrixHomework;

public class MatrixWithDoubleType extends Matrix {
    protected double[][] array;

    public MatrixWithDoubleType() {
        super();
        this.array = new double[2][2];
    }

    public MatrixWithDoubleType(int rows, int columns) {
        super(rows, columns);
        /*this.rows = rows;
        this.columns = columns;*/
        this.array = new double[rows][columns];
    }
}
