package Advanced.SetsAndMapsAdvanced.Ex;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentElement = input.charAt(i);
            if (map.containsKey(currentElement)) {
                map.put(currentElement, map.get(currentElement) + 1);
            } else {
                map.put(currentElement, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
