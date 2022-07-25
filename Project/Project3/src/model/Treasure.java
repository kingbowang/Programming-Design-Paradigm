package model;

/**
 * This class implements the treasure abstract class that can be extended.
 *
 * @author Pengbo Wang
 */
public abstract class Treasure {
  //treasure has been picked up
  private boolean taken;

  /**
   * The constructor of the Treasure class.
   *
   * @param position position of the treasure
   * @param value    value of the treasure
   * @param id       ID of the treasure
   */
  public Treasure(Position position, int value, int id) {
    this.taken = false;
  }

  /**
   * Construct a method to get the type of the treasure.
   *
   * @return null
   */
  public String getType() {
    return null;
  }

  /**
   * Construct a method to take the treasure.
   */
  public void takeTreasure() {
    this.taken = true;
  }

  /**
   * Construct a method to get the treasures obtained.
   *
   * @return treasure has been taken
   */
  public boolean isTaken() {
    return taken;
  }

}
