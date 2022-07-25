package model;

import java.util.List;

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
   * Get the id of the cave.
   *
   * @return Id
   */
  int getId();

  /**
   * Get the position of cave.
   *
   * @return the position of cave
   */
  Position getPosition();

}
