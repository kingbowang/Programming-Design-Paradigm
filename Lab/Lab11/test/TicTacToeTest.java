import org.junit.Test;

import tictactoe.Player;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test cases for the TicTacToeModel. Verifying that game state is properly managed, and all game
 * actions are properly validated.
 */
public class TicTacToeTest {
  private final TicTacToe ttt1 = new TicTacToeModel();

  /**
   * Test move.
   */
  @Test
  public void testMove() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    assertEquals(Player.X, ttt1.getMarkAt(0, 0));
    ttt1.move(0, 1);
    assertEquals(Player.X, ttt1.getTurn());
    assertEquals(Player.O, ttt1.getMarkAt(0, 1));
  }

  /**
   * Test invalid move.
   */
  @Test
  public void testInvalidMove() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    assertEquals(Player.X, ttt1.getMarkAt(0, 0));
    try {
      ttt1.move(0, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      ttt1.move(-1, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  /**
   * Test the turn.
   */
  @Test
  public void testGetTurn() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(1, 1);
    assertEquals(Player.X, ttt1.getTurn());
    ttt1.move(0, 1);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(1, 0);
    assertEquals(Player.X, ttt1.getTurn());
  }

  /**
   * Test if the game is over.
   */
  @Test
  public void testIsGameOver() {
    ttt1.move(0, 0);
    assertFalse(ttt1.isGameOver());
    ttt1.move(1, 0);
    assertFalse(ttt1.isGameOver());
    ttt1.move(0, 1);
    assertFalse(ttt1.isGameOver());
    ttt1.move(2, 0);
    assertFalse(ttt1.isGameOver());
    ttt1.move(0, 2);
    assertTrue(ttt1.isGameOver());
  }

  /**
   * Test null.
   */
  @Test
  public void testNullGetWinner() {
    ttt1.move(2, 0);
    assertNull(ttt1.getWinner());
    ttt1.move(1, 0);
    assertNull(ttt1.getWinner());
    ttt1.move(0, 2);
    assertNull(ttt1.getWinner());
  }

  /**
   * Test horizontal win.
   */
  @Test
  public void testHorizontalWin() {
    ttt1.move(0, 0);
    assertFalse(ttt1.isGameOver());
    ttt1.move(1, 0);
    ttt1.move(0, 1);
    assertNull(ttt1.getWinner());
    ttt1.move(2, 0);
    ttt1.move(0, 2);
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.X, ttt1.getWinner());
  }

  /**
   * Test vertical win.
   */
  @Test
  public void testVerticalWin() {
    ttt1.move(1, 0);
    assertFalse(ttt1.isGameOver());
    ttt1.move(0, 1);
    ttt1.move(0, 0);
    assertNull(ttt1.getWinner());
    ttt1.move(0, 2);
    ttt1.move(2, 0);
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.X, ttt1.getWinner());
  }

  // set up situation where game is over,
  // O wins on the diagonal, board is not full
  private void diagonalWinHelper() {
    ttt1.move(0, 0);
    assertFalse(ttt1.isGameOver());
    ttt1.move(2, 0);
    ttt1.move(1, 0);
    assertNull(ttt1.getWinner());
    ttt1.move(1, 1);
    ttt1.move(0, 1);
    ttt1.move(0, 2);
  }

  /**
   * Test diagonal win.
   */
  @Test
  public void testDiagonalWin() {
    diagonalWinHelper();
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.O, ttt1.getWinner());
  }

  /**
   * Test move attempt after game is over.
   */
  @Test(expected = IllegalStateException.class)
  public void testMoveAttemptAfterGameOver() {
    diagonalWinHelper();
    ttt1.move(2, 2);
  }

  /**
   * Tests a tied game.
   */
  @Test
  public void testCatsGame() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(1, 1);
    assertEquals(Player.X, ttt1.getTurn());
    ttt1.move(0, 2);
    ttt1.move(0, 1);
    ttt1.move(2, 1);
    ttt1.move(1, 0);
    ttt1.move(1, 2);
    ttt1.move(2, 2);
    ttt1.move(2, 0);
    assertTrue(ttt1.isGameOver());
    assertNull(ttt1.getWinner());
  }

  /**
   * Tests the board.
   */
  @Test
  public void testGetBoard() {
    diagonalWinHelper();
    Player[][] bd = ttt1.getBoard();
    assertEquals(Player.X, bd[0][0]);
    assertEquals(Player.O, bd[1][1]);
    assertEquals(Player.X, bd[0][1]);
    assertEquals(Player.O, bd[2][0]);
    assertEquals(Player.O, ttt1.getMarkAt(2, 0));
    bd[2][0] = Player.X;
    assertEquals(Player.O, ttt1.getMarkAt(2, 0));
    Player[][] bd2 = ttt1.getBoard();
    assertEquals(Player.O, bd2[2][0]);
  }

  /**
   * Test the current mark at a given row and column.
   */
  @Test
  public void testGetMarkAt() {
    diagonalWinHelper();
    Player[][] bd = ttt1.getBoard();
    ttt1.getMarkAt(2, 0);
    assertEquals(Player.O, bd[2][0]);
  }

  /**
   * Test an illegal row.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtRow() {
    ttt1.getMarkAt(-12, 0);
  }

  /**
   * Test an illegal column.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtCol() {
    ttt1.getMarkAt(0, -30);
  }
}
