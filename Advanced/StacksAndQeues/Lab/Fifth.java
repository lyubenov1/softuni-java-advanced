package Advanced.StacksAndQeues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Fifth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String task = scan.nextLine();

        while (!task.equals("print")) {
            if (task.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledTask = queue.poll();
                    System.out.println("Canceled " + canceledTask);
                }
            } else {
                queue.offer(task);
            }

            task = scan.nextLine();
        }
// -------------------------------------------------------------------------------
        //for (String file : queue) {
        //    System.out.println(file);
        //}
// -------------------------------------------------------------------------------
        // while (!queue.isEmpty) {
        //     System.out.println(queue.poll());
        // }
// -------------------------------------------------------------------------------
        String result = queue.stream().map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(result);
    }
}