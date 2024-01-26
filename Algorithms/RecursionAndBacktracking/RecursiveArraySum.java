package Algorithms.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = recursiveFunction(array, 0);

        System.out.println(sum);
    }

    private static int recursiveFunction(int[] array, int index) {
        if (index >= array.length) {
            return 0;
        }
        return array[index] + recursiveFunction(array, index + 1);
    }
}
