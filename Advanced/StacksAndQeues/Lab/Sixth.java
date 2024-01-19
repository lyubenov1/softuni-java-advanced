package Advanced.StacksAndQeues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Sixth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(" ");
        int toss = Integer.parseInt(scanner.nextLine());

        Deque<String> players = new ArrayDeque<>(Arrays.asList(people));

        int i = 0;
        while (players.size() > 1) {
            i++;
            String person = players.removeFirst();

            if (i == toss) {
                System.out.println("Removed " + person);
                i = 0;
            } else {
                players.add(person);
            }

        }

        System.out.println("Last is " + players.poll());
    }
}