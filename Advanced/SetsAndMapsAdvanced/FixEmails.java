package Advanced.SetsAndMapsAdvanced.Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> nameEmailMap = new HashMap<>();

        while (true) {
            String name = scanner.nextLine();

            if (name.equals("stop")) {
                break;
            }

            String email = scanner.nextLine();

            // Check if the email domain ends with "us", "uk", or "com" (case insensitive)
            if (!email.toLowerCase().endsWith("us") &&
                    !email.toLowerCase().endsWith("uk") &&
                    !email.toLowerCase().endsWith("com")) {
                nameEmailMap.put(name, email);
            }
        }

        // Print the collected names and emails
        for (Map.Entry<String, String> entry : nameEmailMap.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
