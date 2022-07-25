package model;

import utils.Position;

/**
 * Implement a Tunnel class.
 * This is a tunnel which has exactly 2 entrances.
 *
 * @author Pengbo Wang
 */
public class Tunnel extends BaseClass {

  /**
   * The constructor of the Tunnel class.
   *
   * @param row row of dungeon
   * @param col columns of dungeon
   */
  public Tunnel(int row, int col) {
    this.position = new Position(row, col);
  }
}
