package utils;

/**
 * The direction that the player can move in the dungeon.
 * North West South East
 *
 * @author Pengbo Wang
 */
public enum Direction {
  N("N"),
  W("W"),
  S("S"),
  E("E");

  private final String name;

  /**
   * The constructor of direction class.
   *
   * @param name direction name
   */
  Direction(String name) {
    this.name = name;
  }

  /**
   * Get the direction name.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

}
