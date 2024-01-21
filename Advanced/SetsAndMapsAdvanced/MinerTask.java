package Advanced.SetsAndMapsAdvanced.Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String name = scan.nextLine();

        while (!name.equals("stop")) {
            int number = Integer.parseInt(scan.nextLine());
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + number);
            }
            map.put(name, number);
            name = scan.nextLine();
        }

        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }
}
