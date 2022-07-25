package model;

import java.util.List;
import utils.Position;

/**
 * Implement a cave interface.
 *
 * @author Pengbo Wang
 */
public interface Cave {

  /**
   * Put the treasure in cave.
   *
   * @param treasure treasure
   */
  void setTreasure(Treasure treasure);

  /**
   * Get the treasure which is stored in cave.
   *
   * @return list of treasure
   */
  List<Treasure> getTreasures();

  /**
   * Get the position of cave.
   *
   * @return the position of cave
   */
  Position getPosition();

  /**
   * Find Otyughs from their smell.
   *
   * @return Otyughs
   */
  List<OtyughsImpl> getOtyughs();

  /**
   * Set the arrows.
   *
   * @param arrow arrows
   */
  void setArrows(ArrowImpl arrow);

  /**
   * Get the arrows.
   *
   * @return arrows
   */
  List<ArrowImpl> getArrows();

  /**
   * Add Otyughs to the dungeon.
   *
   * @param otyughs Otyughs
   */
  void addOtyughs(OtyughsImpl otyughs);

}
