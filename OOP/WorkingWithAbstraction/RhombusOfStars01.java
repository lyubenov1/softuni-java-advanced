package OOP.WorkingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printRhombus(n);
    }

    public static void printRhombus(int size) {
        for (int i = 1; i <= size; i++) {
            printTriangle(size - i, i);
        }

        for (int i = 1; i < size; i++) {
            printTriangle(i, size - i);
        }
    }

    private static void printTriangle(int spacesToPrint, int starsToPrint) {
        for (int i = 0; i < spacesToPrint; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < starsToPrint; i++) {
            System.out.print("* ");
        }

        System.out.println();
    }
}