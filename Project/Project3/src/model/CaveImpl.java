package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a CaveImpl class which implements the Cave interface.
 * This is a cave which has 1, 3 or 4 entrances.
 *
 * @author Pengbo Wang
 */
public class CaveImpl implements Cave {
  private final Position position;
  private final int id;
  // treasures in the cave
  private final List<Treasure> treasures;

  /**
   * The constructor of the CaveImpl class.
   *
   * @param row rows in the dungeon
   * @param col columns in the dungeon
   * @param id  ID of the cave in the dungeon
   * @throws IllegalArgumentException if the ID is negative
   */
  public CaveImpl(int row, int col, int id) throws IllegalArgumentException {
    if (id < 0) {
      throw new IllegalArgumentException("Negative ID is not supported.");
    }
    this.position = new Position(row, col);
    this.id = id;
    this.treasures = new ArrayList<>();
  }

  @Override
  public void setTreasure(Treasure treasure) {
    this.treasures.add(treasure);
  }

  @Override
  public List<Treasure> getTreasures() {
    return this.treasures;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

}
