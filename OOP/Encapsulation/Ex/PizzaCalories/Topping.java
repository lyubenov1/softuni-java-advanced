package OOP.Encapsulation.Ex.PizzaCalories;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!isValidType(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private boolean isValidType(String toppingType) {
        Set<String> types = new HashSet<>(Arrays.asList("Meat", "Veggies", "Cheese", "Sauce"));
        return types.contains(toppingType);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + "weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double total = switch (this.toppingType) {
            case "Meat" -> this.weight * 1.2;
            case "Veggies" -> this.weight * 0.8;
            case "Cheese" -> this.weight * 1.1;
            case "Sauce" -> this.weight * 0.9;
            default -> 0;
        };

        return total * 2;
    }
}