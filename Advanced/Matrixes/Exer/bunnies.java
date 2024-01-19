package Advanced.Matrixes.Exer;

import java.util.*;

public class bunnies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows =  scan.nextInt();
        int cols =  scan.nextInt();
        scan.nextLine();

        Set<String> set = new HashSet<>();
        int playerRow = 0;
        int playerCol = 0;

        char[][] matrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            char[] r = scan.nextLine().toCharArray();
            for (int col = 0; col < cols; col++) {
                if (r[col] == 'B') {
                    set.add(row + " " + col);
                } else if (r[col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
            matrix[row] = r;
        }

        String commands = scan.nextLine();

        boolean won = false;
        boolean dead = false;

        for (char command : commands.toCharArray()) {
            int[] nextPosition = getNextPos(playerRow, playerCol, command);
            int nextRow = nextPosition[0];
            int nextCol = nextPosition[1];
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

            Set<String> newBunnies = new HashSet<String>();
            for (String bunny : set) {
                int bunnyRow = Integer.parseInt(bunny.split(" ")[0]);
                int bunnyCol = Integer.parseInt(bunny.split(" ")[1]);
                List<int[]> children = getChildren(bunnyRow, bunnyCol, rows, cols);
                for (int[] child : children) {
                    int childRow = child[0];
                    int childCol = child[1];

                    newBunnies.add(childRow + " " + childCol);
                    matrix[childRow][childCol] = 'B';
                    if (childRow == playerRow && childCol == playerCol) {
                        dead = true;
                    }
                }

                }
            set.addAll(newBunnies);

            if (won || dead) {
                break;
            }

        }

        for (char[] row : matrix) {
            System.out.println(row);
        }
        if (won) {
            System.out.println("won: " + playerRow + " " + playerCol);
        }

        if (dead) {
            System.out.println("dead: " + playerRow + " " + playerCol);
        }


    }

    private static List<int[]> getChildren(int row, int col, int rows, int cols) {
        List<int[]> possibleChildren = new ArrayList<>();
        possibleChildren.add(new int[]{row - 1, col});
        possibleChildren.add(new int[]{row, col - 1});
        possibleChildren.add(new int[]{row, col + 1});
        possibleChildren.add(new int[]{row + 1, col});

        List<int[]> result = new ArrayList<>();

        for (int[] child : possibleChildren) {
            if(!isOutside(child[0], child[1], rows, cols)) {
                result.add(child);
            }
        }

        return result;
    }

    private static boolean isOutside(int row, int col, int rows, int cols) {
        return row < 0 || col < 0 || row >= rows || col >= cols;
    }

    private static int[] getNextPos(int row, int col, char command) {
        int[] result = new int[2];

        if (command == 'U') {
            result[0] = row - 1;
            result[1] = col;
        } else if (command == 'D') {
            result[0] = row + 1;
            result[1] = col;
        } else if (command == 'L') {
            result[0] = row;
            result[1] = col - 1;
        } else if (command == 'R') {
            result[0] = row;
            result[1] = col + 1;
        }

        return result;
    }
}
