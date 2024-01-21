package Advanced.SetsAndMapsAdvanced.Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            map.put(name, number);
            input = scan.nextLine();
        }
        input = scan.nextLine();

        while (!input.equals("stop")) {
                if (map.containsKey(input)) {
                    System.out.println(input + " -> " + map.get(input));
                } else {
                    System.out.printf("Contact %s does not exist.%n", input);
                }
                input = scan.nextLine();

        }
    }
}