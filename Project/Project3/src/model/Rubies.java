package model;

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
   * @param value    value of the ruby
   * @param id       ID of the ruby
   */
  public Rubies(Position position, int value, int id) {
    super(position, value, id);
  }

  @Override
  public String getType() {
    return "Ruby";
  }

}
