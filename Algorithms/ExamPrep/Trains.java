package Algorithms.ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class Trains {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] arrivals = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .sorted()
                .toArray();

        double[] departures = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .sorted()
                .toArray();


        int platforms = 0;
        int maxPlatforms = 0;
        for (int i = 0, j = 0; i < arrivals.length;) {
            if (arrivals[i] < departures[j]) {
                platforms++;
                i++;

                maxPlatforms = Math.max(platforms, maxPlatforms);
            }
            else
            {
                platforms--;
                j++;
            }
        }

        System.out.println(maxPlatforms);
    }
}
