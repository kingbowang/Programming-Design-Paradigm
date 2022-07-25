package model;

import java.util.ArrayList;
import java.util.List;
import utils.Position;

/**
 * Implement a PlayerImpl class which implements the Player interface.
 * All the information representing the player in this class.
 *
 * @author Pengbo Wang
 */
public class PlayerImpl extends BaseClass implements Player {
  private CaveImpl cave;
  private int arrowCnt;
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
    this.arrowCnt = 3;
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
  public int getArrowCnt() {
    return arrowCnt;
  }

  @Override
  public void takeArrow(ArrowImpl arrow) {
    if (arrow.isTaken()) {
      return;
    }
    ++this.arrowCnt;
    arrow.take();
  }

  @Override
  public void shoot() {
    if (this.arrowCnt > 0) {
      --this.arrowCnt;
    } else {
      throw new RuntimeException("Arrow is 0!!");
    }
  }

}
