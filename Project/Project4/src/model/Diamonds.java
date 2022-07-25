package model;

import utils.Position;

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
   */
  public Diamonds(Position position) {
    super(position);
  }

  @Override
  public String getType() {
    return "Diamond";
  }

}
