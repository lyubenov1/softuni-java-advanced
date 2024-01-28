package Algorithms.SearchingSortingAndGreedyAlgorithms;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int max = findMax(arr);

        int[] countingArray = new int[max + 1];

        // Counting Phase
        for (int value : arr) {
            countingArray[value]++;
        }

        // Prefix Sum (Cumulative Count)
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] += countingArray[i - 1];
        }

        // Reconstruct the Sorted Array
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            int position = countingArray[value] - 1;
            sortedArray[position] = value;
            countingArray[value]--;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 4, 6, 5, 3};
        System.out.println("Original array: " + Arrays.toString(arr));

        countingSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}