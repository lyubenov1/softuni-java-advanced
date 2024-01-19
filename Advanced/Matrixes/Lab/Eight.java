package Advanced.Matrixes.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Eight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = inputMatrix(scanner, rows, "\\s+");
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int number = matrix[indexes[0]][indexes[1]];
        int[][] outputMatrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            outputMatrix[row] = new int[matrix[row].length];
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    int up = 0;
                    int down = 0;
                    int left = 0;
                    int right = 0;
                    if (row == 0) {
                        if (col == 0) {
                            right = matrix[row][col + 1] == number ? 0 : matrix[row][col + 1];
                            if (matrix[row + 1].length == matrix[row].length)
                                down = matrix[row + 1][col] == number ? 0 : matrix[row + 1][col];
                        } else if (col == matrix[row].length - 1) {
                            left = matrix[row][col - 1] == number ? 0 : matrix[row][col - 1];
                            if (matrix[row + 1].length == matrix[row].length)
                                down = matrix[row + 1][col] == number ? 0 : matrix[row + 1][col];
                        } else {
                            right = matrix[row][col + 1] == number ? 0 : matrix[row][col + 1];
                            left = matrix[row][col - 1] == number ? 0 : matrix[row][col - 1];
                            if (matrix[row + 1].length == matrix[row].length)
                                down = matrix[row + 1][col] == number ? 0 : matrix[row + 1][col];
                        }
                    } else if (row == rows - 1) {
                        if (col == 0) {
                            right = matrix[row][col + 1] == number ? 0 : matrix[row][col + 1];
                            if (matrix[row - 1].length == matrix[row].length)
                                up = matrix[row - 1][col] == number ? 0 : matrix[row - 1][col];
                        } else if (col == matrix[row].length - 1) {
                            left = matrix[row][col - 1] == number ? 0 : matrix[row][col - 1];
                            if (matrix[row - 1].length == matrix[row].length)
                                up = matrix[row - 1][col] == number ? 0 : matrix[row - 1][col];
                        } else {
                            right = matrix[row][col + 1] == number ? 0 : matrix[row][col + 1];
                            left = matrix[row][col - 1] == number ? 0 : matrix[row][col - 1];
                            if (matrix[row - 1].length == matrix[row].length)
                                up = matrix[row - 1][col] == number ? 0 : matrix[row - 1][col];
                        }
                    } else {
                        if (col == 0) {
                            right = matrix[row][col + 1] == number ? 0 : matrix[row][col + 1];
                            if (matrix[row + 1].length == matrix[row].length)
                                down = matrix[row + 1][col] == number ? 0 : matrix[row + 1][col];
                            if (matrix[row - 1].length == matrix[row].length)
                                up = matrix[row - 1][col] == number ? 0 : matrix[row - 1][col];
                        } else if (col == matrix[row].length - 1) {
                            left = matrix[row][col - 1] == number ? 0 : matrix[row][col - 1];
                            if (matrix[row + 1].length == matrix[row].length)
                                down = matrix[row + 1][col] == number ? 0 : matrix[row + 1][col];
                            if (matrix[row - 1].length == matrix[row].length)
                                up = matrix[row - 1][col] == number ? 0 : matrix[row - 1][col];
                        } else {
                            right = matrix[row][col + 1] == number ? 0 : matrix[row][col + 1];
                            left = matrix[row][col - 1] == number ? 0 : matrix[row][col - 1];
                            if (matrix[row - 1].length == matrix[row].length)
                                up = matrix[row - 1][col] == number ? 0 : matrix[row - 1][col];
                            if (matrix[row + 1].length == matrix[row].length)
                                down = matrix[row + 1][col] == number ? 0 : matrix[row + 1][col];
                        }
                    }
                    int sum = left + right + up + down;
                    outputMatrix[row][col] = sum;
                } else outputMatrix[row][col] = matrix[row][col];
            }
        }
        printMatrix(outputMatrix);
    }

    private static void printMatrix(int[][] outputMatrix) {
        for (int[] matrix : outputMatrix) {
            for (int number : matrix) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static int[][] inputMatrix(Scanner scanner, int rows, String pattern) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}