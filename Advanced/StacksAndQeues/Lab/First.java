package Advanced.StacksAndQeues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (stack.size() > 1) {
                    stack.pop();
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }

            else {
                System.out.println(command);
                stack.push(command);
            }


            command = scan.nextLine();
        }

//        stack.reversed();
//        System.out.println(stack);

    }
}