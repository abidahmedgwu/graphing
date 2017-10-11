// Abid Ahmed
// 10-9-17
// Class that creates a matrix

public class Matrix {

    // Instance variables
    private double[][] matrix;

    // Constructors
    public Matrix() {
        matrix = new double[0][0];
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    // Accessor methods
    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getRow(int row) {
        return matrix[row];
    }

    public double[] getColumn(int col) {
        double[] column = new double[matrix.length];
        for (int i = 0; i < column.length; i++) {
            column[i] = matrix[i][col];
        }
        return column;
    }

    // toString
    public String toString() {
        String message = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                message += matrix[i][j] + " ";
            }
            message += "\n";
        }
        return message;
    }

    // Gets the number of rows in a matrix
    public int rows() {
        return matrix.length;
    }

    // Gets the number of columns in a matrix
    public int columns() {
        return matrix[0].length;
    }

    // Adds two matrices
    public static Matrix add(Matrix m1, Matrix m2) {
        if (m1.rows() != m2.rows()) {
            return null;
        }
        double[][] newMatrix = new double[m1.rows()][m1.columns()];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = m1.getMatrix()[i][j] + m2.getMatrix()[i][j];
            }
        }
        return new Matrix(newMatrix);
    }

    // Subtracts two matrices
    public static Matrix subtract(Matrix m1, Matrix m2) {
        if (m1.rows() != m2.rows()) {
            return null;
        }
        double[][] newMatrix = new double[m1.rows()][m1.columns()];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = m1.getMatrix()[i][j] - m2.getMatrix()[i][j];
            }
        }
        return new Matrix(newMatrix);
    }

    // Multiplies two matrices
    public static Matrix multiply(Matrix m1, Matrix m2) {
        if (m1.columns() != m2.rows()) {
            return null;
        }
        double[][] newMatrix = new double[m1.rows()][m2.columns()];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                for (int k = 0; k < m1.columns(); k++) {
                    newMatrix[i][j] += m1.getMatrix()[i][k] * m2.getMatrix()[k][j];
                }
            }
        }
        return new Matrix(newMatrix);
    }

    // Multiplies a matrix by a scalar
    public static Matrix multiply(Matrix m1, double t) {
        double[][] newMatrix = new double[m1.rows()][m1.columns()];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = t*m1.getMatrix()[i][j];
            }
        }
        return new Matrix(newMatrix);
    }
}
