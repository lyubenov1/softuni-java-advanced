package Advanced.FunctionalProgramming.Ex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindTheSmallestElement07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> printIndexOfMinElement = list -> {
            int min = Collections.min(list);
            System.out.println(list.lastIndexOf(min));
        };

        printIndexOfMinElement.accept(numbers);


    //    Function<List<Integer>, Integer> getIndexOfMinElement = list -> list.lastIndexOf(Collections.min(list));
    //    System.out.println(getIndexOfMinElement.apply(numbers));
    }
}
