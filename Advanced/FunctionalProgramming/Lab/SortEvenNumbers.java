package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        processIntegers(inputLine);
    }

    public static void processIntegers(String inputLine) {
        List<Integer> numbers = Arrays.stream(inputLine.split(", "))
                .map(Integer::parseInt)
                .toList();

        List<Integer> evenNumbers = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers.stream()
                .map(Object::toString)
                .toArray(String[]::new)));

        evenNumbers.sort(Integer::compareTo);

        System.out.println(String.join(", ", evenNumbers.stream()
                .map(Object::toString)
                .toArray(String[]::new)));
    }
}
