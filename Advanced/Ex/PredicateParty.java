package Advanced.FunctionalProgramming.Ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        List<String> guests = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());

        while (!"Party!".equals(line = reader.readLine())) {
            String[] commandTokens = line.split("\\s+");
            String command = commandTokens[0];
            String predicateType = commandTokens[1];
            String predicateArgument = commandTokens[2];

            if (command.equals("Remove")) {
                guests.removeIf(getPredicate(predicateType, predicateArgument));
            } else if (command.equals("Double")) {
                guests = guests.stream()
                        .flatMap(guest -> getPredicate(predicateType, predicateArgument).test(guest)
                                ? Stream.of(guest, guest)
                                : Stream.of(guest))
                        .collect(Collectors.toList());
            }
        }

        String result = guests.isEmpty()
                ? "Nobody is going to the party!"
                : guests.stream().sorted().collect(Collectors.joining(", ", "", " are going to the party!"));

        System.out.println(result);
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        return switch (type) {
            case "StartsWith" -> text -> text.startsWith(parameter);
            case "EndsWith" -> text -> text.endsWith(parameter);
            case "Length" -> text -> text.length() == Integer.parseInt(parameter);
            default -> text -> false;
        };
    }
}