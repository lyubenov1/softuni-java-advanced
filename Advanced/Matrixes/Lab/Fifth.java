package Advanced.Matrixes.Lab;

import java.util.Scanner;

public class Fifth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int rows = Integer.parseInt(line.split(", ")[0]);
        int cols = Integer.parseInt(line.split(", ")[1]);
        int[][] matrix = new int[rows][cols];
        int maxSum = 0;

        for (int i = 0; i < rows; i++) {
            String[] row = scan.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        int rowIndex = 0, colIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = checkSubmatrix(matrix, i, j);
                if (current > maxSum) {
                    maxSum = current;
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }

        for (int i = rowIndex; i < rowIndex + 2; i++) {
            for (int j = colIndex; j < colIndex + 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }

    private static int checkSubmatrix(int[][] matrix, int row, int col) {
        int submatrix = 0;
        if (isValidIndex(matrix, row, col)) {
            for (int i = row; i < row + 1; i++) {
                for (int j = col; j < col + 1; j++) {
                    submatrix = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                }
            }
        }
        return submatrix;
    }

    private static boolean isValidIndex(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length - 1 && col >= 0 && col < matrix[0].length - 1;
    }

}
