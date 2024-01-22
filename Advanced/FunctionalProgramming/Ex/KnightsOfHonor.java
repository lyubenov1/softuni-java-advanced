package Advanced.FunctionalProgramming.Ex;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] names = input.split("\\s+");

        Consumer<String> printName = name -> System.out.println("Sir " + name);
   //     Arrays.stream(names).forEach(printName);

        for (String name : names) {
            printName.accept(name);
        }
    }
}
