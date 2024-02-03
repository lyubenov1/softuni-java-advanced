package OOP.Encapsulation.Ex.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
        String a = scanner.next();
        String pizzaName = scanner.next();
        int numberOfToppings = scanner.nextInt();

        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        String b = scanner.next();
        String flourType = scanner.next();
        String bakingTechnique = scanner.next();
        double doughWeight = scanner.nextDouble();
        scanner.nextLine();

        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
        pizza.setDough(dough);


        while (true) {
            String input = scanner.nextLine();
            if ("END".equals(input)) {
                break;
            }
            String toppingType = input.split(" ")[1];
            double weight = Integer.parseInt(input.split(" ")[2]);
            Topping topping = new Topping(toppingType, weight);
            pizza.addTopping(topping);
        }

            double totalCalories = pizza.getOverallCalories();
            System.out.printf("%s - %.2f\n", pizza.getName(), totalCalories);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
