package Advanced.Matrixes.Lab;

import java.util.Scanner;

public class Sixth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[size - 1 - i][i] + " ");
        }
    }
}