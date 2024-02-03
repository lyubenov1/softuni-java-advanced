package OOP.Encapsulation.Ex.PizzaCalories;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public void setFlourType(String flourType) {
        if (!validType(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private boolean validType(String flourType) {
        Set<String> validTypes = new HashSet<>(Arrays.asList("White", "Wholegrain"));
        return validTypes.contains(flourType);
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!validBakingTechnique(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private boolean validBakingTechnique(String bakingTechnique) {
        Set<String> validTypes = new HashSet<>(Arrays.asList("Crispy", "Chewy", "Homemade"));
        return validTypes.contains(bakingTechnique);
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourTypeModifier;
        double bakingTechniqueModifier;

        flourTypeModifier = switch (flourType.toLowerCase()) {
            case "white" -> 1.5;
            default -> 1.0;
        };

        bakingTechniqueModifier = switch (bakingTechnique.toLowerCase()) {
            case "crispy" -> 0.9;
            case "chewy" -> 1.1;
            default -> 1.0;
        };

        return (2 * weight) * flourTypeModifier * bakingTechniqueModifier;
    }
}
