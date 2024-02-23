package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class LabyrinthPaths {
    public static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] labyrinth = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            labyrinth[r] = scan.nextLine().toCharArray();
        }

        findPaths(labyrinth, 0, 0, ' ');

    }

    public static void findPaths(char[][] labyrinth, int row, int col, char direction) {
        if (!isInBounds(labyrinth, row, col)
                || labyrinth[row][col] == 'V'
                || labyrinth[row][col] == '*') {
            return;
        }

        if (' ' != direction) {
            path.add(direction);
        }


        if (isExit(labyrinth, row, col)) {
            printPath();
        } else if (!isVisited(labyrinth, row, col) && isFree(labyrinth, row, col)) {
            mark(labyrinth, row, col);
            findPaths(labyrinth, row, col + 1, 'R');
            findPaths(labyrinth, row + 1, col, 'D');
            findPaths(labyrinth, row, col - 1, 'L');
            findPaths(labyrinth, row - 1, col, 'U');
            unMark(labyrinth, row , col);

        }

        if (!path.isEmpty()) {
            path.remove(path.size() - 1);
        }
    }

    private static void unMark(char[][] labyrinth, int row, int col) {
        labyrinth[row][col] = '-';
    }

    private static void mark(char[][] labyrinth, int row, int col) {
        labyrinth[row][col] = 'V';
    }

    private static boolean isFree(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] == '-';
    }

    private static void printPath() {
        path.forEach(System.out::print);
        System.out.println();
    }

    private static boolean isVisited(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] == 'V';
    }

    private static boolean isExit(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] == 'e';
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row >= 0 && row < labyrinth.length && col >= 0 && col < labyrinth[row].length;
    }

}
