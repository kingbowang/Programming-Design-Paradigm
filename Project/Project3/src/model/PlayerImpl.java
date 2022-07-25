package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a PlayerImpl class which implements the Player interface.
 * All the information representing the player in this class.
 *
 * @author Pengbo Wang
 */
public class PlayerImpl implements Player {
  private final Position position;
  private CaveImpl cave;
  private final List<Treasure> treasures;

  /**
   * The constructor of the PlayerImpl class.
   *
   * @param position the position of the player
   * @param cave     cave and special cave(tunnel)
   */
  public PlayerImpl(Position position, CaveImpl cave) {
    this.position = position;
    this.cave = cave;
    this.treasures = new ArrayList<>();
  }

  @Override
  public CaveImpl getCave() {
    return cave;
  }

  @Override
  public void setCave(CaveImpl cave) {
    this.cave = cave;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public void goNorth() {
    --this.position.row;
  }

  @Override
  public void goWest() {
    --this.position.col;
  }

  @Override
  public void goSouth() {
    ++this.position.row;
  }

  @Override
  public void goEast() {
    ++this.position.col;
  }

  @Override
  public void takeTreasure(Treasure treasure) {
    if (!treasure.isTaken()) {
      this.treasures.add(treasure);
      treasure.takeTreasure();
    }
  }

  @Override
  public List<Treasure> getTreasures() {
    return treasures;
  }

  @Override
  public String describe() {
    StringBuilder ans = new StringBuilder("Treasure: ");
    for (Treasure treasure : this.treasures) {
      ans.append(treasure.getType());
    }
    return ans.toString();
  }

}
