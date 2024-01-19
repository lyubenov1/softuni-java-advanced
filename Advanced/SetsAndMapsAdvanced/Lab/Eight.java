package Advanced.SetsAndMapsAdvanced.Lab;

import java.util.*;

public class Eight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            map.putIfAbsent(name, new ArrayList<>());
            List<Double> grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .toList();

            map.get(name).addAll(grades);
        }

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            Double average = entry.getValue().stream()
                    .mapToDouble(Double::doubleValue)
                    .average().orElse(0.0);

            entry.getValue().clear();
            entry.getValue().add(average);
            System.out.printf("%s is graduated with %.2f%n", entry.getKey(), average);
        }
        }
    }

