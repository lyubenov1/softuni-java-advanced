package OOP.InterfacesAndAbstraction.Ex.FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Buyer> collection = new ArrayList<>();

        while(n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            switch (input.length) {
                case 4:
                    String id = input[2];
                    String birthDate = input[3];
                    Buyer citizen = new Citizen(name, age, id, birthDate);
                    collection.add(citizen);
                    break;
                case 3:
                    String group = input[2];
                    Buyer rebel = new Rebel(name, age, group);
                    collection.add(rebel);
                    break;
            }
        }

        while (true) {
            String input = scanner.nextLine();
            if ("End".equals(input)) {
                break;
            }

            for (Buyer buyer : collection) {
                if (buyer.getName().equals(input)) {
                    buyer.buyFood();
                    break;
                }
            }
        }

        int totalFood = 0;
        for (Buyer buyer : collection) {
            totalFood += buyer.getFood();
        }

        System.out.println(totalFood);


    }
}