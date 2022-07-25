package model;

import utils.Position;

/**
 * Implement sapphires class extends treasure class.
 * Sapphire is a kind of treasure.
 *
 * @author Pengbo Wang
 */
public class Sapphires extends Treasure {

  /**
   * The constructor of the Sapphires class.
   *
   * @param position position of the sapphire
   */
  public Sapphires(Position position) {
    super(position);
  }

  @Override
  public String getType() {
    return "Sapphire";
  }

}
