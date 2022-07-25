package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Class represents a TicTacToeModel with the given board.
 */
public class TicTacToeModel implements TicTacToe {
  // add your implementation here
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
    return Arrays.stream(getBoard()).map(
                    row -> " " + Arrays.stream(row).map(
                            p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n"));
  }

  @Override
  public void move(int r, int c) {
    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("This is outside the board.");
    } else if (board[r][c] != null) {
      throw new IllegalArgumentException("A player has already marked there!");
    } else if (isGameOver()) {
      throw new IllegalStateException("Game is over!");
    } else {
      board[r][c] = this.player;

      if (this.player == Player.X) {
        this.player = Player.O;
      } else {
        this.player = Player.X;
      }

      if (isGameOver()) {
        getWinner();
      }
    }
  }

  @Override
  public Player getTurn() {
    return this.player;
  }

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

  @Override
  public Player[][] getBoard() {
    Player[][] newBoard = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      System.arraycopy(board[i], 0, newBoard[i], 0, 3);
    }
    return newBoard;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("Out of board's bounds.");
    }
    if (board[r][c] == null) {
      return null;
    }
    return board[r][c];
  }
}
