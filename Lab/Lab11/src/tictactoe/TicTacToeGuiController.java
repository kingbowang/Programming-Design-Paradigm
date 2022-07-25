package tictactoe;

/**
 * Public class represents a visual controller of the TicTacToe game.
 */
public class TicTacToeGuiController implements TicTacToeController {
  private final TicTacToeView view;
  private TicTacToe model;

  /**
   * Primary public constructor that creates a new TicTacToeUIController.
   *
   * @param view v the given View passed in
   */
  public TicTacToeGuiController(TicTacToeView view) {
    if (view == null) {
      throw new IllegalArgumentException("Given view cannot be null!");
    }
    this.view = view;
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException("Given model cannot be null!");
    }
    this.model = m;

    view.addClickListener(this);
    view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
    try {
      model.move(row, col);
      view.refresh();
    } catch (IllegalArgumentException | IllegalStateException e) {
      // do nothing since move is illegal
    }
  }
}
