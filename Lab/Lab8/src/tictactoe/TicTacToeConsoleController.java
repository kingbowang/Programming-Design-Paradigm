package tictactoe;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This starter files is for students to implement a console controller for the
 * TicTacToe MVC assignment.
 *
 * @author Pengbo Wang
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   *
   * @param in  the source to read from
   * @param out the target to print to
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null.");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException("Model can't be null.");
    }
    try {
      out.append(m.toString()).append("\n");
      out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
      Integer rowInput = null;
      Integer columnInput = null;
      String token = "";

      while (!m.isGameOver()) {
        token = scan.next();
        if (token.equalsIgnoreCase("q")) {
          break;
        }
        try {
          int var = Integer.parseInt(token);
          if (rowInput == null) {
            rowInput = var;
          } else {
            columnInput = var;
            m.move(rowInput - 1, columnInput - 1);

            if (m.isGameOver()) {
              out.append(m.toString()).append("\n");
              out.append("Game is over! ");
              if (m.getWinner() != null) {
                out.append(m.getWinner().toString()).append(" wins.\n");
              } else {
                out.append("Tie game.\n");
              }
              break;
            }
            out.append(m.toString()).append("\n");
            out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
            rowInput = columnInput = null;
          }

        } catch (NumberFormatException e) {
          out.append("Not a valid number: ").append(token).append("\n");
        } catch (IllegalArgumentException e) {
          out.append("Not a valid move: ").append(String.valueOf(rowInput))
                  .append(", ").append(String.valueOf(columnInput)).append("\n");
          rowInput = columnInput = null;
        }
      }
      if (!m.isGameOver() && token.equalsIgnoreCase("q")) {
        out.append("Game quit! Ending game state:\n").append(m.toString()).append("\n");
      } else if (!m.isGameOver()) {
        throw new IllegalStateException("No more inputs.");
      }
    } catch (IOException e) {
      throw new IllegalStateException("Failure to append.");
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("Failure to read from readable.");
    }
    scan.close();
  }

}
