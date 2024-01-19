package Advanced.Matrixes.Exer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RadioactiveBunnies {

    public static int[] getNextPos(int row, int col, char command) {
        return switch (command) {
            case 'U' -> new int[]{row - 1, col};
            case 'D' -> new int[]{row + 1, col};
            case 'L' -> new int[]{row, col - 1};
            case 'R' -> new int[]{row, col + 1};
            default -> new int[]{row, col};
        };
    }

    public static boolean isOutside(int row, int col, int rows, int cols) {
        return row < 0 || col < 0 || row >= rows || col >= cols;
    }

    public static Set<String> getChildren(int row, int col, int rows, int cols) {
        Set<String> result = new HashSet<>();
        int[][] possibleChildren = {
                {row - 1, col},
                {row, col - 1},
                {row, col + 1},
                {row + 1, col}
        };

        for (int[] child : possibleChildren) {
            int childRow = child[0];
            int childCol = child[1];
            if (!isOutside(childRow, childCol, rows, cols)) {
                result.add(childRow + " " + childCol);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            Set<String> bunnies = new HashSet<>();
            int playerRow = 0;
            int playerCol = 0;

            char[][] matrix = new char[rows][cols];

            for (int row = 0; row < rows; row++) {
                String rowElements = scanner.next();
                char[] elementsArray = rowElements.toCharArray();
                for (int col = 0; col < cols; col++) {
                    if (elementsArray[col] == 'P') {
                        playerRow = row;
                        playerCol = col;
                    } else if (elementsArray[col] == 'B') {
                        bunnies.add(row + " " + col);
                    }
                    matrix[row][col] = elementsArray[col];
                }
            }

            String commands = scanner.next();

            boolean won = false;
            boolean dead = false;

            for (char command : commands.toCharArray()) {
                int[] nextPos = getNextPos(playerRow, playerCol, command);
                int nextRow = nextPos[0];
                int nextCol = nextPos[1];

                matrix[playerRow][playerCol] = '.';
                if (isOutside(nextRow, nextCol, rows, cols)) {
                    won = true;
                } else if (matrix[nextRow][nextCol] == 'B') {
                    dead = true;
                    playerRow = nextRow;
                    playerCol = nextCol;
                } else {
                    matrix[nextRow][nextCol] = 'P';
                    playerRow = nextRow;
                    playerCol = nextCol;
                }

                Set<String> newBunnies = new HashSet<>();
                for (String bunny : bunnies) {
                    String[] bunnyCoords = bunny.split(" ");
                    int bunnyRow = Integer.parseInt(bunnyCoords[0]);
                    int bunnyCol = Integer.parseInt(bunnyCoords[1]);
                    Set<String> children = getChildren(bunnyRow, bunnyCol, rows, cols);
                    newBunnies.addAll(children);
                    for (String child : children) {
                        String[] childCoords = child.split(" ");
                        int childRow = Integer.parseInt(childCoords[0]);
                        int childCol = Integer.parseInt(childCoords[1]);
                        matrix[childRow][childCol] = 'B';
                        if (childRow == playerRow && childCol == playerCol) {
                            dead = true;
                        }
                    }
                }

                bunnies.addAll(newBunnies);

                if (won || dead) {
                    break;
                }
            }

            for (char[] row : matrix) {
                System.out.println(new String(row));
            }

            if (won) {
                System.out.println("won: " + playerRow + " " + playerCol);
            }

            if (dead) {
                System.out.println("dead: " + playerRow + " " + playerCol);
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
}
