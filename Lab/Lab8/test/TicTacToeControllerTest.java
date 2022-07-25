import tictactoe.TicTacToe;
import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;

import java.io.StringReader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and appendable.
 *
 * @author Pengbo Wang
 */
public class TicTacToeControllerTest {

  /**
   * Test failing Appendable.
   */
  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }

  /**
   * Test to validate that the Controller throws an IllegalArgumentException
   * if the model passed to playGame is invalid.
   */
  @Test
  public void testInvalidModel() {
    try {
      StringReader input = new StringReader("0 1 1 1 2 2 3 3 2 2 hello 2 3 1 3 2 1");
      StringBuilder gameLog = new StringBuilder();
      TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
      c.playGame(null);
      fail("Controller should throw an IllegalArgumentException for invalid model");
    } catch (IllegalArgumentException ex) {
      // this is the expected behavior
    }
  }

  /**
   * Test to validate that the Controller works correctly when given invalid input for a row.
   */
  @Test
  public void testInvalidInputRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 3 food 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("Not a valid number: food", lines[12]);
  }

  /**
   * Test to validate that the Controller works correctly when given invalid input for a column.
   */
  @Test
  public void testInvalidInputCol() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 hello q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("Not a valid number: hello", lines[12]);
  }

  /**
   * Test to validate that the Controller works correctly when given a row that is out of bounds.
   */
  @Test
  public void testRowOutsideBoard() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 3 7 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("Not a valid move: 7, 2", lines[12]);
  }

  /**
   * Test to validate that the Controller works correctly when given a column that is out of bounds.
   */
  @Test
  public void testColumnOutsideBoard() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 3 1 5 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("Not a valid move: 1, 5", lines[lines.length - 7]);
  }

  /**
   * Test to validate that the Controller works correctly when a "q" is given for the row.
   */
  @Test
  public void testQuitRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("3 1 2 2 1 3 q 1");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(30, lines.length);
    assertEquals("Game quit! Ending game state:", lines[lines.length - 6]);
  }

  /**
   * Test to validate that the Controller works correctly when a "q" is given for the column.
   */
  @Test
  public void testQuitColumn() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 2 1 3 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(30, lines.length);
    assertEquals("Game quit! Ending game state:", lines[lines.length - 6]);
  }

  /**
   * Test to validate that the Controller works correctly when given a valid move.
   */
  @Test
  public void testValidMove() {
    TicTacToe m = new TicTacToeModel();
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(new StringReader("2 2 q"), gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" + "-----------\n" + "   |   |  \n" + "-----------\n"
            + "   |   |  \n" + "Enter a move for X:\n" + "   |   |  \n" + "-----------\n"
            + "   | X |  \n" + "-----------\n" + "   |   |  \n" + "Enter a move for O:\n"
            + "Game quit! Ending game state:\n" + "   |   |  \n" + "-----------\n" + "   | X |  \n"
            + "-----------\n" + "   |   |  \n", gameLog.toString());
  }

  /**
   * Test to validate that the Controller works correctly
   * when given a move to a space that is already occupied.
   */
  @Test
  public void testValidInputButOccupiedSpace() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 2 1 1 1 2 1 3 1 2 3 1 2 1 3 1 2 3 2 2 3 2 3 3");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(64, lines.length);
    assertEquals("Not a valid move: 1, 1", lines[lines.length - 46]);
    assertEquals("Not a valid move: 1, 2", lines[lines.length - 33]);
    assertEquals("Not a valid move: 3, 1", lines[lines.length - 20]);
    assertEquals("Not a valid move: 2, 2", lines[lines.length - 13]);
    assertEquals("Game is over! Tie game.", lines[lines.length - 1]);
  }

  /**
   * Test to validate that the Controller continues to run after an invalid move is given.
   */
  @Test
  public void testInvalidMoves() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("0 1 1 1 2 2 3 3 4 9 2 0 2 3 play 1 3 3 3 2 1");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(47, lines.length);
    assertEquals("Not a valid move: 0, 1", lines[6]);
    assertEquals("Not a valid move: 4, 9", lines[25]);
    assertEquals("Not a valid move: 2, 0", lines[26]);
    assertEquals("Not a valid number: play", lines[33]);
    assertEquals("Not a valid move: 3, 3", lines[40]);
    assertEquals("Game is over! O wins.", lines[46]);
  }

  /**
   * Test to validate that the Controller works correctly when the game ends with player X winning.
   */
  @Test
  public void testPlayGameWithWinnerX() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 2 1 1 2 1 3 3");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(36, lines.length);
    assertEquals("Game is over! X wins.", lines[lines.length - 1]);
  }

  /**
   * Test to validate that the Controller works correctly when the game ends with player O winning.
   */
  @Test
  public void testPlayGameWithWinnerO() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 2 1 3 1 2 3 3 3 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(42, lines.length);
    assertEquals("Game is over! O wins.", lines[41]);
  }

  /**
   * Test to validate that the Controller works correctly when the game ends in a tie.
   */
  @Test
  public void testTieGame() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(60, lines.length);
    assertEquals("Game is over! Tie game.", lines[lines.length - 1]);
  }

}
