package Algorithms.CombinatorialProblems;

import java.util.Scanner;

public class PermutationsWithoutRepetition {

    public static String[] elements;
    public static String[] variations;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        used = new boolean[elements.length];
        variations = new String[elements.length];
        combinations(0);
    }

    private static void combinations(int index) {
        if (index == variations.length) {
            print(variations);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                variations[index] = elements[i];
                combinations(index + 1);
                used[i] = false;
            }
        }
    }
    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}