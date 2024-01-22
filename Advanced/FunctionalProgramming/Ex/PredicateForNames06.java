package Advanced.FunctionalProgramming.Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Predicate<String> validLength = name -> name.length() <= n;
        String[] names = scan.nextLine().split("\\s+");

        Arrays.stream(names)
                .filter(validLength)
                .forEach(System.out::println);
    }
}
