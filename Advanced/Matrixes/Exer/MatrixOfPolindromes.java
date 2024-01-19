package Advanced.Matrixes.Exer;

import java.util.Scanner;

public class MatrixOfPolindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] palindromeMatrix = generatePalindromeMatrix(rows, cols);
        printMatrix(palindromeMatrix);
    }

    private static String[][] generatePalindromeMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        // Generate the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char firstLetter = (char) ('a' + i);
                char middleLetter = (char) ('a' + j + i);
                String palindrome = String.format("%c%c%c", firstLetter, middleLetter, firstLetter);
                matrix[i][j] = palindrome;
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(String.join(" ", row));
        }
    }
}
