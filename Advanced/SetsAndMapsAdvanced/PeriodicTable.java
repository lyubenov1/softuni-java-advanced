package Advanced.SetsAndMapsAdvanced.Ex;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            List<String> lines = List.of(scan.nextLine().split("\\s+"));
            set.addAll(lines);
        }
        System.out.println(String.join(" ", set));
    }
}
