package controller;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import utils.Direction;
import utils.Position;

/**
 * Controller layer in MVC pattern.
 * The Controller layer mainly conducts data interaction between
 * Model and View to reduce coupling and improve program scalability.
 * Mainly defines some of the player's input behavior in the game
 * and the method of information that needs to be displayed to the player.
 *
 * @author Pengbo Wang
 */
public interface DungeonController {

  /**
   * Explain the command line parameters entered by the
   * user and create a Dungeon game based on these parameters.
   *
   * @param userInput command-line parameter array
   */
  void parseCommonLine(String[] userInput);

  /**
   * Change the position of the player to simulate the player's movement.
   * If the player's movement is illegal, this method will throw a RuntimeException.
   *
   * @param direction player's moving direction
   */
  void playerMove(Direction direction);

  /**
   * The player picks up the treasures or arrows of the cave located in the same position.
   * This will cause the number of gems or arrows held by the player to change.
   *
   * @param treasureType treasure type picked up by the player
   * @return whether the pickup is successful
   */
  boolean playerPickUp(String treasureType);

  /**
   * The direction and distance of the player's shooting.
   *
   * @param caveDistance caveDistance
   * @param direction    direction
   * @return player shoot direction
   */
  boolean playerShoot(int caveDistance, Direction direction);

  /**
   * Obtain treasures and arrows in the cave at the same position as the player.
   *
   * @return a Map type data, the key is the name of the
   *     treasure or arrow, and the value is the number of them
   */
  Map<String, Integer> getPickUp();

  /**
   * Get whether the current game is over.
   *
   * @return whether the game is over
   */
  boolean gameOver();

  /**
   * Determine if the player has won the game.
   *
   * @return whether the player won the game
   */
  boolean isWin();

  /**
   * Get the direction the player can move.
   *
   * @return a set that stores all the directions in which the current player can move
   */
  Set<Direction> getAvailableDirection();

  /**
   * Get Otyughts smell around the current location.
   *
   * @return an int type value, 0 means that no smell can be smelled, 1 means that a slight smell
   *     can be smelled (Slight Smell), 2 means that a strong smell can be smelled (Terrible Smell)
   */
  int getOtyughs();

  /**
   * Determine whether the Player is located in cave.
   *
   * @return whether the player is in the cave
   */
  boolean inCave();

  /**
   * Get the number of Arrows currently held by the player.
   *
   * @return an int value representing the number of Arrows held by the player
   */
  int getArrowsCnt();

  /**
   * Get the starting position of the game.
   *
   * @return the starting position
   */
  Position getBegin();

  /**
   * Get the end position of the game.
   *
   * @return the end position
   */
  Position getEnd();

  /**
   * Get the detailed information of the Player.
   *
   * @return A value of Map type, the key is the type of player information,
   *     and value is the value of the corresponding type
   */
  Map<String, Object> getPlayerInformation();

  /**
   * Start the dungeon game.
   *
   * @param in   input
   * @param out  output
   * @param args arguments
   * @throws IOException if the input is invalid
   */
  void startGame(Scanner in, Appendable out, String[] args) throws IOException;

}
