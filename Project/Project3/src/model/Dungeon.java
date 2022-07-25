package model;

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
   * Get the movable direction of the incoming Cave.
   *
   * @param cave cave and tunnel
   * @return A 1*4 array, respectively representing whether it
   *         can move in the [North, South, West, East] direction.
   */
  int[] getAvailableMove(CaveImpl cave);

  /**
   * Construct a method to get the edge.
   *
   * @return edge
   */
  int[][] getEdge();

  /**
   * Construct a method to get position.
   *
   * @return position
   */
  Position getPosition();

  /**
   * Construct a method to control player movement.
   *
   * @param type Direction of movement 0:North, 1:South, 2:West, 3:East
   */
  void playerMove(int type);

  /**
   * Player takes treasure.
   */
  void playerTakeTreasure();

  /**
   * Construct a method to describe.
   *
   * @return String
   */
  String describe();

}
