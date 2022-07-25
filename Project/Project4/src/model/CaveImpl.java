package model;

import java.util.ArrayList;
import java.util.List;
import utils.Position;

/**
 * Implement a CaveImpl class which implements the Cave interface.
 * This is a cave which has 1, 3 or 4 entrances.
 *
 * @author Pengbo Wang
 */
public class CaveImpl extends BaseClass implements Cave {
  private final List<Treasure> treasures;
  private final List<ArrowImpl> arrows;
  private final List<OtyughsImpl> otyughs;

  /**
   * The constructor of the CaveImpl class.
   *
   * @param row rows in the dungeon
   * @param col columns in the dungeon
   */
  public CaveImpl(int row, int col) {
    this.position = new Position(row, col);
    this.treasures = new ArrayList<>();
    this.arrows = new ArrayList<>();
    this.otyughs = new ArrayList<>();
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
  public Position getPosition() {
    return this.position;
  }

  @Override
  public List<OtyughsImpl> getOtyughs() {
    return this.otyughs;
  }

  @Override
  public void setArrows(ArrowImpl arrow) {
    this.arrows.add(arrow);
  }

  @Override
  public List<ArrowImpl> getArrows() {
    return this.arrows;
  }

  @Override
  public void addOtyughs(OtyughsImpl otyughs) {
    this.otyughs.add(otyughs);
  }

}
