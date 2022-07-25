package tictactoe;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Arrays;

import org.junit.Test;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and appendable.
 */
public class TicTacToeConsoleControllerTest {

  @Test
  public void testSingleValidMove() {
    TicTacToe m = new TicTacToeModel();
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(new StringReader("2 2 q"), gameLog);
    c.playGame(m);
    assertEquals("""
               |   | \s
            -----------
               |   | \s
            -----------
               |   | \s
            Enter a move for X:
               |   | \s
            -----------
               | X | \s
            -----------
               |   | \s
            Enter a move for O:
            Game quit! Ending game state:
               |   | \s
            -----------
               | X | \s
            -----------
               |   | \s
            """, gameLog.toString());
  }

  @Test
  public void testBogusInputAsRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("!#$ 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    // split the output into an array of lines
    String[] lines = gameLog.toString().split("\n");
    // check that it's the correct number of lines
    assertEquals(13, lines.length);
    // check that the last 6 lines are correct
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("""
            Game quit! Ending game state:
               |   | \s
            -----------
               |   | \s
            -----------
               |   | \s""", lastMsg);
    // note no trailing \n here, because of the earlier split
  }

  @Test
  public void testTieGame() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(60, lines.length);
    assertEquals("Game is over! Tie game.", lines[lines.length - 1]);
  }

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }

}