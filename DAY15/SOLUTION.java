// Day 15: Arrays – Part 3 (2D Arrays & Common Problems)

public class Day15 {
    public static void main(String[] args) {
        // Activity 1: 2D Array Basics
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Task 1: Print all elements
        System.out.println("All elements of 2D array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Task 2: Sum of all elements
        int totalSum = 0;
        for (int[] row : arr) {
            for (int val : row) {
                totalSum += val;
            }
        }
        System.out.println("Sum of all elements: " + totalSum);


        // Activity 2: Row and Column Operations
        // Task 3: Sum of each row and column
        System.out.println("\nSum of each row:");
        for (int i = 0; i < arr.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                rowSum += arr[i][j];
            }
            System.out.println("Row " + (i + 1) + ": " + rowSum);
        }

        System.out.println("\nSum of each column:");
        for (int j = 0; j < arr[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < arr.length; i++) {
                colSum += arr[i][j];
            }
            System.out.println("Column " + (j + 1) + ": " + colSum);
        }

        // Task 4: Find maximum element and its position
        int max = arr[0][0];
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("\nMax element: " + max + " at position (" + maxRow + ", " + maxCol + ")");


        // Activity 3: Diagonal Elements
        // Task 5: Print main and secondary diagonals
        System.out.println("\nMain diagonal elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][i] + " ");
        }

        System.out.println("\nSecondary diagonal elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][arr.length - 1 - i] + " ");
        }

        // Task 6: Sum of both diagonals
        int mainSum = 0, secSum = 0;
        for (int i = 0; i < arr.length; i++) {
            mainSum += arr[i][i];
            secSum += arr[i][arr.length - 1 - i];
        }
        System.out.println("\nSum of main diagonal: " + mainSum);
        System.out.println("Sum of secondary diagonal: " + secSum);


        // Activity 4: Matrix Transformations
        // Task 7: Transpose of a matrix
        System.out.println("\nTranspose of matrix:");
        int[][] transpose = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                transpose[j][i] = arr[i][j];
            }
        }
        printMatrix(transpose);

        // Task 8: Rotate matrix 90 degrees clockwise
        System.out.println("\nMatrix rotated 90° clockwise:");
        rotate90(arr);


        // Activity 5: Pattern Problem
        // Task 9: Print pattern
        System.out.println("\nPattern (3x3 matrix):");
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }


        // Challenge Task: Multiply two matrices
        System.out.println("\nMatrix Multiplication:");
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        int[][] C = multiplyMatrices(A, B);
        printMatrix(C);
    }

    // Helper: Print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Helper: Rotate 90 degrees clockwise
    public static void rotate90(int[][] arr) {
        int n = arr.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = arr[i][j];
            }
        }
        printMatrix(rotated);
    }

    // Helper: Matrix Multiplication
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int r1 = A.length, c1 = A[0].length, c2 = B[0].length;
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
}
