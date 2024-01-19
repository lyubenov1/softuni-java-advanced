package Advanced.Matrixes.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[rows][cols];
        String[][] matrix2 = new String[rows][cols];
        String[][] matrix3 = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] row = scan.nextLine().split(" ");
            matrix[i] = row;
        }
        for (int i = 0; i < rows; i++) {
            String[] row = scan.nextLine().split(" ");
            matrix2[i] = row;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j].equals(matrix2[i][j])) {
                    matrix3[i][j] = matrix[i][j];
                }
                else {
                    matrix3[i][j] = "*";
                }
            }

        }

        Arrays.stream(matrix3)
                .map(row -> String.join(" ", row))
                .forEach(System.out::println);


    }
}