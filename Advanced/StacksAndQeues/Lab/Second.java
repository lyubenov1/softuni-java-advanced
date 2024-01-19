package Advanced.StacksAndQeues.Lab;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Second {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();
        ArrayDeque<Character> operators = new ArrayDeque<Character>();
        String command = scan.nextLine();
        String[] startingNumbers = command.split("\\D+");
        String regex = "[+-]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        ArrayList<String> startingOperators = new ArrayList<>();

        while (matcher.find()) {
            startingOperators.add(matcher.group());
        }

        for (int i = 0; i < startingNumbers.length; i++) {
            numbers.push(Integer.parseInt(startingNumbers[i]));
            if (i < startingOperators.size()) {
                operators.push(startingOperators.get(i).charAt(0));
            }
        }
        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();
        ArrayDeque<Character> reversedOperators = new ArrayDeque<>();

        while (!numbers.isEmpty()) {
            reversedNumbers.push(numbers.pop());
        }
        while (!operators.isEmpty()) {
            reversedOperators.push(operators.pop());
        }

        while (!reversedOperators.isEmpty()) {
            int firstNumber = reversedNumbers.pop();
            int secondNumber = reversedNumbers.pop();
            char operator = reversedOperators.pop();

            if (operator == '+') {
                reversedNumbers.push(firstNumber + secondNumber);
            } else if (operator == '-'){
                reversedNumbers.push(firstNumber - secondNumber);
            }
        }

        System.out.println(reversedNumbers.peek());
    }

    private static boolean operatorCheck(char character) {
        return character == '+' || character == '-';
    }
}
