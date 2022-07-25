package model;

import utils.Position;

/**
 * Implement rubies class extends treasure class.
 * Ruby is a kind of treasure.
 *
 * @author Pengbo Wang
 */
public class Rubies extends Treasure {

  /**
   * The constructor of the Rubies class.
   *
   * @param position position of the ruby
   */
  public Rubies(Position position) {
    super(position);
  }

  @Override
  public String getType() {
    return "Ruby";
  }

}
