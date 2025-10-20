// Day 6 : 2D Arrays (Matrix Operations)

import java.util.*;

public class MatrixOperations {

    // Activity 1 : Basic Matrix Operations
    // Task 1: Input and display a 2D array
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Task 2: Find the sum of all elements
    public static int sumOfElements(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }

    // Activity 2 : Row & Column Operations
    // Task 3: Sum of each row and each column
    public static void sumRowsAndCols(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Row sums:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Row " + (i + 1) + ": " + rowSum);
        }

        System.out.println("Column sums:");
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Column " + (j + 1) + ": " + colSum);
        }
    }

    // Task 4: Find maximum element in the matrix
    public static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int val : row) {
                if (val > max) max = val;
            }
        }
        return max;
    }

    // Activity 3 : Matrix Transformation
    // Task 5: Transpose of a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Task 6: Check if matrix is symmetric
    public static boolean isSymmetric(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) return false;
            }
        }
        return true;
    }

    // Activity 4 : Matrix Multiplication
    // Task 7: Multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int r1 = A.length, c1 = A[0].length;
        int r2 = B.length, c2 = B[0].length;

        if (c1 != r2) {
            System.out.println("Matrix dimensions incompatible for multiplication!");
            return null;
        }

        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        displayMatrix(matrix);

        System.out.println("\nSum of all elements: " + sumOfElements(matrix));

        System.out.println("\nSum of Rows and Columns:");
        sumRowsAndCols(matrix);

        System.out.println("\nMaximum Element: " + findMax(matrix));

        System.out.println("\nTranspose of Matrix:");
        int[][] transposed = transposeMatrix(matrix);
        displayMatrix(transposed);

        System.out.println("\nIs Matrix Symmetric? " + isSymmetric(matrix));

        // Matrix Multiplication
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        System.out.println("\nMatrix Multiplication Result:");
        int[][] result = multiplyMatrices(A, B);
        if (result != null) displayMatrix(result);
    }
}
