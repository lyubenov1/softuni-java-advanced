package Advanced.SetsAndMapsAdvanced.Ex;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class First {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> set = new LinkedHashSet<String>();

        for (int i = 0; i < n; i++) {
            set.add(scan.nextLine());
        }

        set.forEach(System.out::println);
    }
}
