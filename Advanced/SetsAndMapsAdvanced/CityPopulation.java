package Advanced.SetsAndMapsAdvanced.Ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CityPopulation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> countriesAndTotalPopulation = new LinkedHashMap<>();
        Map<String, Map<String, Long>> map = new LinkedHashMap<>();

        String command;

        while (!"report".equals(command = reader.readLine())) {
            String[] inputData = command.split("\\|");

            String city = inputData[0];
            String country = inputData[1];
            long population = Long.parseLong(inputData[2]);

            if (!countriesAndTotalPopulation.containsKey(country)) {
                countriesAndTotalPopulation.put(country, population);
            } else {
                countriesAndTotalPopulation.put(country, countriesAndTotalPopulation.get(country) + population);
            }

            if (!map.containsKey(country)) {
                map.put(country, new LinkedHashMap<>());
                map.get(country).put(city, population);
            } else {
                map.get(country).put(city, population);
            }
        }

        countriesAndTotalPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n",
                            entry.getKey(), entry.getValue());

                    map.get(entry.getKey()).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue()
                                    .reversed())
                            .forEach(entryInner -> System.out.printf("=>%s: %d%n", entryInner.getKey(), entryInner.getValue()));
                });

    }
}