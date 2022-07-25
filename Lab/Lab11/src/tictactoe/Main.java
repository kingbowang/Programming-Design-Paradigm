package tictactoe;

/**
 * Run a TicTacToe game interactively.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively.
   */
  public static void main(String[] args) {
    // Old News: console-based game:
    //new TicTacToeConsoleController(new InputStreamReader(System.in),
    //    System.out).playGame(new TicTacToeModel());

    // New Hotness: Graphical User Interface:
    // 1. Create an instance of the model.
    TicTacToeModel model = new TicTacToeModel();
    // 2. Create an instance of the view.
    TicTacToeSwingView view = new TicTacToeSwingView("Tic-Tac-Toe", model);
    // 3. Create an instance of the controller.
    TicTacToeController controller = new TicTacToeGuiController(view);
    // 4. Call playGame() on the controller.
    controller.playGame(model);
  }
}
