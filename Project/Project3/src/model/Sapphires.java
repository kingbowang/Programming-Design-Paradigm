package model;

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
   * @param value    value of the sapphire
   * @param id       ID of the sapphire
   */
  public Sapphires(Position position, int value, int id) {
    super(position, value, id);
  }

  @Override
  public String getType() {
    return "Sapphire";
  }

}
