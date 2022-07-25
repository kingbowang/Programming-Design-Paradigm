package tictactoe;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 * Public class represents the View for the TicTacToe game.
 */
public class TicTacToeSwingView extends JFrame implements TicTacToeView {
  private final BoardPanel boardPanel;
  // Public Constants
  public static int WIDTH = 500;
  public static int HEIGHT = 600;
  public static int STATUS_HEIGHT = 100;
  public static int CELL_DIM = WIDTH / 3;


  /**
   * Primary constructor that creates a new instance of a TicTacToeView.
   *
   * @param title the title of the game
   * @param model the ReadonlyTttModel reference passed in that is visualized by this view
   */
  public TicTacToeSwingView(String title, ReadonlyTttModel model) {
    super(title);
    this.setSize(WIDTH, HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setMinimumSize(new Dimension(WIDTH, HEIGHT));

    boardPanel = new BoardPanel(model);
    add(boardPanel);
    makeVisible();
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    // create the MouseAdapter
    MouseAdapter clickAdapter = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        int row = e.getY() / CELL_DIM;
        int col = e.getX() / CELL_DIM;
        listener.handleCellClick(row, col);
      }
    };
    boardPanel.addMouseListener(clickAdapter);
  }

  @Override
  public void refresh() {
    repaint();
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }
}
