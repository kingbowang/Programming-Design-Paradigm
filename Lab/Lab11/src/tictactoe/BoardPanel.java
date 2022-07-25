package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Public class that does the drawing of the game board and elements.
 */
public class BoardPanel extends JPanel {
  private final ReadonlyTttModel model;

  /**
   * Primary constructor that creates a new instance of a BoardPanel.
   *
   * @param model the read-only version of the given model.
   */
  public BoardPanel(ReadonlyTttModel model) {
    this.setBackground(Color.white);
    this.model = model;
  }

  public static final int FONT_SIZE = 40;
  public static final String FONT_FACE = "Helvetica";

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    // Set the font
    g2d.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));

    // Model attributes
    Player turn;
    turn = model.getTurn();
    Player winner;
    winner = model.getWinner();

    // Panel Dimensions
    int w = TicTacToeSwingView.WIDTH;
    int h = TicTacToeSwingView.HEIGHT;
    int sh = TicTacToeSwingView.STATUS_HEIGHT;

    // draw grid lines
    g2d.drawLine(w / 3, 0, w / 3, h - sh);
    g2d.drawLine(w * 2 / 3, 0, w * 2 / 3, h - sh);
    g2d.drawLine(0, (h - sh) / 3, w, (h - sh) / 3);
    g2d.drawLine(0, (h - sh) * 2 / 3, w, (h - sh) * 2 / 3);

    // iterate over board, draw X and O accordingly
    int numCells = 3;
    for (int row = 1; row <= numCells; row++) {
      for (int col = 1; col <= numCells; col++) {
        int xpo = (w * col / numCells) - (w / (numCells * 2));
        int ypo = ((h - sh) * row / numCells) - ((h - sh) / (numCells * 2));

        if (model.getMarkAt(row - 1, col - 1) != null) {
          if (model.getMarkAt(row - 1, col - 1) == Player.X) {
            g2d.drawString("X", xpo - (FONT_SIZE / 2), ypo + (FONT_SIZE / 2));
          } else {
            g2d.drawString("O", xpo - (FONT_SIZE / 2), ypo + (FONT_SIZE / 2));
          }
        }
      }
    }
    // Check if winner, then print
    if (winner != null) {
      g2d.drawString("Game over: " + winner + " wins.", w / 7, h - (sh / 2));
    } else if (model.isGameOver()) {
      g2d.drawString("Game over: Tie game.", w / 11, h - (sh / 2));
    } else {
      // turn statuses
      g2d.drawString("Turn: " + turn.toString(), w / 3, h - (sh / 2));
    }
  }
}
