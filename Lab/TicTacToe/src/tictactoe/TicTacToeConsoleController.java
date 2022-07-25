package tictactoe;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class represent the controller model.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private final Appendable out;
  private final Scanner scan;

  /**
   * Construct tic tac toe object.
   *
   * @param in  object.
   * @param out object.
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException("Tictactoe null");
    }
    try { // everytime you use appendable, need to do a try/block clause
      out.append(m.toString()).append("\n");
      // Print out calling move for and then whose turn it is
      out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
      Integer rowInput = null; // int can't be null, but Inter can be null
      Integer columnInput = null;
      String token = ""; // what we are splitting the string by

      while (!m.isGameOver()) {
        token = scan.next(); // will find and put next token in scanner
        if (token.equalsIgnoreCase("q")) {
          break;
        }
        try { // handle individual tokens
          int var = Integer.parseInt(token);
          if (rowInput == null) {
            rowInput = var; // represents the parsed token
          } else {
            columnInput = var;
            m.move(rowInput - 1, columnInput - 1); // starting from 0 so need to subtract 1

            if (m.isGameOver()) {
              out.append(m.toString()).append("\n"); // print out state of game when game is over
              out.append("Game is over! ");
              if (m.getWinner() != null) {
                out.append(m.getWinner().toString()).append(" wins!\n");
              } else {
                out.append("Tie game.\n");
              }
              break; // break whether winner or tie
            }
            out.append(m.toString()).append("\n");
            out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
            rowInput = columnInput = null; // reset every turn b/c receiving new values
          }

        } catch (NumberFormatException e) {
          out.append("Invalid number").append(token).append("\n");
        } catch (IllegalArgumentException e) {
          out.append("Invalid move ").append(String.valueOf(rowInput)).append(",").append(String.valueOf(columnInput)).append("\n");
          rowInput = columnInput = null;
        }
      }
      if (!m.isGameOver() && token.equalsIgnoreCase("q")) { // game isn't over and user entered quit
        out.append("Game quit! Ending game state:\n").append(m.toString()).append("\n");
      } else if (!m.isGameOver()) { // not enough inputs left
        throw new IllegalStateException("No more inputs.");
      }
    } catch (IOException e) {
      //scan.close();
      throw new IllegalStateException("Failure to append.");
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("Failure to read from readable.");
    }
    scan.close();
  }
}