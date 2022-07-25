package driver;

import controller.DungeonControllerImpl;
import java.io.IOException;
import java.util.Scanner;

/**
 * Implement a DungeonDriver class.
 *
 * @author Pengbo Wang
 */
public class DungeonDriver {

  /**
   * The constructor of the main method.
   *
   * @param args put the args in to DungeonDriver class
   * @throws IOException if the input is invalid
   */
  public static void main(String[] args) throws IOException {
    // parse command line parameters
    Scanner input = new Scanner(System.in);
    Appendable output = System.out;
    DungeonControllerImpl.getInstance().startGame(input, output, args);
  }

}
