package Advanced.SetsAndMapsAdvanced.Ex;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> map = new TreeMap<>();
        Map<String, TreeSet<String>> dictionary = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String ipAddress = input[0];
            String name = input[1];
            int number = Integer.parseInt(input[2]);

            if (!map.containsKey(name)) {
                map.put(name, number);
            } else {
                map.put(name, map.get(name) + number);
            }

            if (!dictionary.containsKey(name)) {
                dictionary.put(name, new TreeSet<>());
                dictionary.get(name).add(ipAddress);
            } else {
                dictionary.get(name).add(ipAddress);
            }
        }

        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEach(entry -> {
                    System.out.printf("%s: %d %s%n", entry.getKey(), entry.getValue(), dictionary.get(entry.getKey()));
                    });


    }
}
