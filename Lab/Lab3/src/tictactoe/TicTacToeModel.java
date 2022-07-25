package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Class represents a TicTacToeModel with the given board.
 *
 * @author Pengbo Wang
 * @date 2021-09-29
 */
public class TicTacToeModel implements TicTacToe {
  private final Player[][] board;
  private Player player;
  private Player winner;

  /**
   * Constructs a TicTacToeModel object.
   */
  public TicTacToeModel() {
    this.board = new Player[3][3];
    this.player = Player.X;
    this.winner = null;
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(row -> " " + Arrays.stream(row)
                    .map(p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n"));
  }

  private static void validateRowCol(int r, int c) {
    if (r < 0 || r > 2 || c < 0 || c > 2) {
      throw new IllegalArgumentException("Invalid board position: " + r + "," + c);
    }
  }

  /**
   * Execute a move in the position specified by the given row and column.
   *
   * @param r the row of the intended move
   * @param c the column of the intended move
   * @throws IllegalArgumentException if the space is occupied or the position is otherwise invalid
   * @throws IllegalStateException    if the game is over
   */
  @Override
  public void move(int r, int c) {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over");
    }
    validateRowCol(r, c);
    if (board[r][c] != null) {
      throw new IllegalArgumentException("Space is occupied");
    }
    board[r][c] = player;
    player = player == Player.X ? Player.O : Player.X;
  }

  /**
   * Get the current turn, i.e., the player who will mark on the next call to move().
   *
   * @return the {@link Player} whose turn it is
   */
  @Override
  public Player getTurn() {
    return this.player;
  }

  /**
   * Return whether the game is over. The game is over when either the board is full, or
   * one player has won.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    this.winner = getWinner();
    if (this.winner != null) {
      return true;
    }
    for (Player[] each : board) {
      for (Player check : each) {
        if (check == null) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Return the winner of the game, or {@code null} if there is no winner. If the game is not
   * over, returns {@code null}.
   *
   * @return the winner, or null if there is no winner
   */
  @Override
  public Player getWinner() {
    for (Player p : Player.values()) {
      // check horizontals
      for (Player[] row : board) {
        if (Arrays.stream(row).allMatch(m -> m == p)) {
          return p;
        }
      }
      // check verticals
      for (int i = 0; i < board[0].length; i++) {
        if (board[0][i] == p && board[1][i] == p && board[2][i] == p) {
          return p;
        }
      }
      // check diagonals
      if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
        return p;
      }
      if (board[0][2] == p && board[1][1] == p && board[2][0] == p) {
        return p;
      }
    }
    return null;
  }

  /**
   * Return the current game state, as a 2D array of Player. A {@code null} value in the grid
   * indicates an empty position on the board.
   *
   * @return the current game board
   */
  @Override
  public Player[][] getBoard() {
    Player[][] newBoard = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      System.arraycopy(board[i], 0, newBoard[i], 0, 3);
    }
    return newBoard;
  }

  /**
   * Return the current {@link Player} mark at a given row and column, or {@code null} if the
   * position is empty.
   *
   * @param r the row
   * @param c the column
   * @return the player at the given position, or null if it's empty
   */
  @Override
  public Player getMarkAt(int r, int c) {
    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("Out of board's bound.");
    }
    if (board[r][c] == null) {
      return null;
    }
    return board[r][c];
  }
}
