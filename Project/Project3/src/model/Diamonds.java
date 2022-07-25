package model;

/**
 * Implement diamonds class extends treasure class.
 * Diamond is a kind of treasure.
 *
 * @author Pengbo Wang
 */
public class Diamonds extends Treasure {

  /**
   * The constructor of the Diamonds class.
   *
   * @param position position of the diamond
   * @param value    value of the diamond
   * @param id       ID of the diamond
   */
  public Diamonds(Position position, int value, int id) {
    super(position, value, id);
  }

  @Override
  public String getType() {
    return "Diamond";
  }

}
