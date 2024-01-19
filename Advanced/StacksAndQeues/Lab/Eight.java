package Advanced.StacksAndQeues.Lab;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class Eight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        ArrayDeque<String> deque = new ArrayDeque<>();
        ArrayDeque<String> history = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (deque.size() > 1) {
                    history.offerFirst(deque.pollLast());
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println("no previous URLs");
                }
            }
            else if (command.equals("forward")) {
                if (!history.isEmpty()) {
                    System.out.println(history.peekFirst());
                    deque.offer(Objects.requireNonNull(history.pollFirst()));
                } else {
                    System.out.println("no next URLs");
                }
            }

            else {
                System.out.println(command);
                deque.offer(command);
            }


            command = scan.nextLine();
        }

//        stack.reversed();
//        System.out.println(stack);


    }
}
