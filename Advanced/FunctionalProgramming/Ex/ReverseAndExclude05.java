package Advanced.FunctionalProgramming.Ex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> checkDivision = number -> number % n == 0;
        numbers.removeIf(checkDivision);

        numbers.forEach(number -> System.out.print(number + " "));

    }
}
