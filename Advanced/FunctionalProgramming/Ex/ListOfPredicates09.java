package Advanced.FunctionalProgramming.Ex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split("\\s+")).map(Integer::parseInt)
                        .collect(Collectors.toList());

        BiFunction<List<Integer>, Integer, Boolean> isDivisible = ((list, number) -> {
            for (int numberInList : list) {
                if (number % numberInList != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int number = 1; number <= n; number++) {
            if (isDivisible.apply(numbers, number)) {
                System.out.print(number + " ");
            }
        }

    }
}
