package Advanced.FunctionalProgramming.Ex;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] names = input.split("\\s+");

        Consumer<String> printName = name -> System.out.println(name);
        for (String name : names) {
            printName.accept(name);
        }

        // Consumer<String[]> printNames = array -> {
        //     for (String name : array) {
        //        System.out.println(name);
        //     }  -----------------------------------------SECOND WAY
        // };
        // printNames.accept(names);
    }
}
