package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        UnaryOperator<Double> vatCalculator = val -> val * 1.20;

        System.out.println("Prices with VAT:");

        Arrays.stream(scan.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(vatCalculator)
                .forEach(p -> System.out.printf("%.2f%n", p));
    }
}
