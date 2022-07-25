package model;

import java.util.List;

/**
 * Implement a player interface.
 *
 * @author Pengbo Wang
 */
public interface Player {

  /**
   * Construct a method to get cave.
   *
   * @return cave
   */
  CaveImpl getCave();

  /**
   * Construct a method to get node1.
   */
  void setCave(CaveImpl cave);

  /**
   * Construct a method to get position.
   *
   * @return player current position
   */
  Position getPosition();

  /**
   * Construct a method to let the player go to north.
   */
  void goNorth();

  /**
   * Construct a method to let the player go to west.
   */
  void goWest();

  /**
   * Construct a method to let the player go to south.
   */
  void goSouth();

  /**
   * Construct a method to let the player go to east.
   */
  void goEast();

  /**
   * Player takes treasure.
   *
   * @param treasure treasure
   */
  void takeTreasure(Treasure treasure);

  /**
   * Get all treasures currently collected by the player.
   *
   * @return Player's Treasure list
   */
  List<Treasure> getTreasures();

  /**
   * Construct a method to describe.
   *
   * @return String
   */
  String describe();

}
