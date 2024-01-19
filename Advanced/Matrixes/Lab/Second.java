package Advanced.Matrixes.Lab;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int numberToFind = scanner.nextInt();

        findAndPrintNumberPositions(matrix, numberToFind);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static void findAndPrintNumberPositions(int[][] matrix, int number) {
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == number) {
                    System.out.printf("%d %d%n", i, j);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("not found");
        }
    }
}