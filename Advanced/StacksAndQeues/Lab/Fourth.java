package Advanced.StacksAndQeues.Lab;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String expression = scan.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                int begin = stack.pop();
                System.out.println(expression.substring(begin, i + 1));
            }
        }
    }
}