package Advanced.Matrixes.Lab;

import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix dimensions
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        // Read matrix elements
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] rowElements = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(rowElements[j]);
            }
        }

        // Calculate and print properties
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(calculateSum(matrix));
    }

    private static int calculateSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;
    }
}