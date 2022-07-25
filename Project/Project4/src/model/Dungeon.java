package model;

import java.util.List;
import java.util.Set;
import utils.Direction;

/**
 * Implement dungeon interface.
 *
 * @author Pengbo Wang
 */
public interface Dungeon {

  /**
   * Get the starting position in the dungeon.
   *
   * @return the starting position of the cave
   */
  CaveImpl getBegin();

  /**
   * Get the ending position in the dungeon.
   *
   * @return the ending position of the cave
   */
  CaveImpl getEnd();

  /**
   * Get the player.
   *
   * @return referencing players
   */
  PlayerImpl getPlayer();

  /**
   * Get the movable direction of the incoming cave.
   *
   * @return a set, which stores all the directions in which the cave can move
   */
  Set<Direction> getAvailableMove();

  /**
   * Control player movement.
   *
   * @param direction the direction in which the player moves, South North East West,
   *                  defined in the Direction enumeration type
   */
  void playerMove(Direction direction);

  /**
   * The player picks up a treasure.
   *
   * @param treasure treasure type
   * @return whether the player picked up successfully
   */
  boolean playerTakeTreasure(String treasure);

  /**
   * The player picks up an arrow.
   *
   * @return whether the player picked up successfully
   */
  boolean playerTakeArrow();

  /**
   * Obtain treasures in the cave at the same location as the player.
   *
   * @return a list type of data, storing all treasures
   */
  List<Treasure> getTreasure();

  /**
   * Get the arrow in the cave at the same position as the player.
   *
   * @return a list type of data, storing all arrow
   */
  List<ArrowImpl> getArrow();

  /**
   * Get whether the current game is over.
   *
   * @return whether the game is over
   */
  boolean isGameOver();

  /**
   * Determine if the player has won the game.
   *
   * @return whether the player won the game
   */
  boolean isWin();

  /**
   * The player shoots an arrow.
   *
   * @param distance  distance of arrow
   * @param direction direction of arrow
   * @return a boolean, representing whether the arrow hit Otyughs.
   */
  boolean shoot(int distance, Direction direction);

  /**
   * Get how many Otyughs are around the player.
   *
   * @param distance the distance between Otyughs and the player
   * @return distance between Otyughs and the player
   */
  int otyughsDistance(int distance);

}
