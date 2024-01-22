package Advanced.Matrixes.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        int[][] matrix = new int[rows][cols];
        int[][] biggestSubMatrix = new int[3][3];
        int biggestSubMatrixSum = Integer.MIN_VALUE;

        for (int row = 0; row < rows; row++) {
            int[] r = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = r;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isValidIndex(i, j, rows, cols)) {
                    int[][] subMatrix = getSubMatrix(matrix, i, j);
                    int subMatrixSum = getSubMatrixSum(subMatrix);
                    if (subMatrixSum > biggestSubMatrixSum) {
                        biggestSubMatrixSum = subMatrixSum;
                        biggestSubMatrix = subMatrix;
                    }
                }
            }
        }


        System.out.println("Sum = " + biggestSubMatrixSum);
        Arrays.stream(biggestSubMatrix).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element + " "));
            System.out.println();
        });

    }

    private static int getSubMatrixSum(int[][] subMatrix) {
        return Arrays.stream(subMatrix)
                .flatMapToInt(Arrays::stream)
                .sum();
    }

    private static int[][] getSubMatrix(int[][] matrix, int i, int j) {
        int[][] subMatrix = new int[3][3];

        for (int indexRow = i; indexRow <= i + 2; indexRow++) {
            for (int indexCol = j; indexCol <= j + 2; indexCol++) {
                subMatrix[indexRow - i][indexCol - j] = matrix[indexRow][indexCol];
            }
        }
        return subMatrix;
    }

    private static boolean isValidIndex(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows - 2 && j < cols - 2;
    }
}
