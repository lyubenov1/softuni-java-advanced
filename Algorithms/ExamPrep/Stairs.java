package Algorithms.ExamPrep;

import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int result = permute(n);
        System.out.println(result);
    }

    private static int permute(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return permute(n - 1) + permute(n - 2);
    }
}
