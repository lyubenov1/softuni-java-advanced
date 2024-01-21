package Advanced.SetsAndMapsAdvanced.Ex;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < rows; i++) {
            firstSet.add(Integer.parseInt(scan.nextLine()));
        }
        for (int j = 0; j < cols; j++) {
            secondSet.add(Integer.parseInt(scan.nextLine()));
        }
        firstSet.retainAll(secondSet);

        System.out.println(firstSet.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
