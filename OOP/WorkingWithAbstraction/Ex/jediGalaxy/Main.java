package OOP.WorkingWithAbstraction.Ex.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = readPositions(scan.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        Field field = new Field(rows, cols);
        Galaxy galaxy = new Galaxy(field);

        String command = scan.nextLine();
        long starsCollected = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = readPositions(command);
            int[] evilPosition = readPositions(scan.nextLine());

            int rowEvil = evilPosition[0];
            int colEvil = evilPosition[1];
            galaxy.moveEvil(rowEvil, colEvil);

            int rowJedi = jediPosition[0];
            int colJedi = jediPosition[1];

            starsCollected = galaxy.moveJedi(rowJedi, colJedi);

            command = scan.nextLine();
        }

        System.out.println(starsCollected);


    }

    private static int[] readPositions(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}


// ------------------------------------------------------------------------------------------------------------------------------
//                                          Inefficient implementation

//  public class Main {
//      public static void main(String[] args) {
//          Scanner scanner = new Scanner(System.in);
//
//              int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//              int x = dimestions[0];
//              int y = dimestions[1];
//
//              int[][] matrix = new int[x][y];
//
//              int value = 0;
//              for (int i = 0; i < x; i++)
//              {
//                  for (int j = 0; j < y; j++)
//                  {
//                      matrix[i][j] = value++;
//                  }
//              }
//
//              String command = scanner.nextLine();
//              long sum = 0;
//              while (!command.equals("Let the Force be with you"))
//              {
//                  int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
//                  int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//                  int xE = evil[0];
//                  int yE = evil[1];
//
//                  while (xE >= 0 && yE >= 0)
//                  {
//                      if (xE >= 0 && xE < matrix.length && yE >= 0 && yE < matrix[0].length)
//                      {
//                          matrix[xE] [yE] = 0;
//                      }
//                      xE--;
//                      yE--;
//                  }
//
//                  int xI = ivoS[0];
//                  int yI = ivoS[1];
//
//                  while (xI >= 0 && yI < matrix[1].length)
//                  {
//                      if (xI >= 0 && xI < matrix.length && yI >= 0 && yI < matrix[0].length)
//                      {
//                          sum += matrix[xI][yI];
//                      }
//
//                      yI++;
//                      xI--;
//                  }
//
//                  command = scanner.nextLine();
//              }
//
//          System.out.println(sum);
//
//
//      }
//  }
