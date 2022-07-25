import java.util.Scanner;
import model.CaveImpl;
import model.DungeonImpl;

/**
 * This is Driver class.
 *
 * @author Pengbo Wang
 */
public class Driver {

  /**
   * The constructor of the main method.
   *
   * @param args put the args in to driver class
   */
  public static void main(String[] args) {
    // order of args: int row, int col, boolean wrapping,
    // int interconnectivity, double treasureRandom
    try {
      int row = Integer.parseInt(args[0]);
      int col = Integer.parseInt(args[1]);
      boolean wrapping = Boolean.parseBoolean(args[2]);
      int interconnectivity = Integer.parseInt(args[3]);
      double treasureRandom = Double.parseDouble(args[4]);
      DungeonImpl game = new DungeonImpl(row, col, wrapping, interconnectivity, treasureRandom);
      // Write the connected edge
      System.out.println("Row: " + row);
      System.out.println("Column: " + col);
      System.out.println("Interconnectivity: " + interconnectivity);
      System.out.println("TreasureRandom: " + treasureRandom);
      System.out.println("Wrapping: " + wrapping);
      System.out.println("Begin Game");
      System.out.println("Connect:");
      int[][] edge = game.getEdge();
      for (int i = 1; i <= row * col; ++i) {
        for (int j = 1; j <= row * col; ++j) {
          if (edge[i][j] == 1) {
            System.out.println(i + " <==> " + j);
          }
        }
      }
      CaveImpl begin = game.getBegin();
      CaveImpl end = game.getEnd();
      System.out.println("The initial position: (" + begin.getPosition().row
              + ", " + begin.getPosition().col + ")");
      System.out.println("End position: (" + end.getPosition().row
              + ", " + end.getPosition().col + ")");
      while (game.getPlayer().getPosition().row != end.getPosition().row
              || game.getPlayer().getPosition().col != end.getPosition().col) {
        System.out.println(game.describe());
        System.out.println("Please choice, 0: north | "
                + "1: south | 2: west | 3: east | 4: pick up treasure");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        switch (type) {
          case 0:
          case 1:
          case 2:
          case 3:
            game.playerMove(type);
            break;
          case 4:
            game.playerTakeTreasure();
            break;
          default:
            throw new IllegalStateException("Unexpected value: " + type);
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
    System.out.println("The player reaches the end, the game is over!");
  }
}
