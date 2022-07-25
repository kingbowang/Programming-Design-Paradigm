package model;

import utils.Position;

/**
 * The Arrow class inherits BaseClass and implements ArrowInterface.
 * The Arrow class stores the sign of whether it
 * has been picked up and the position of Arrow on the map.
 *
 * @author Pengbo Wang
 */
public class ArrowImpl extends BaseClass implements Arrow {
  private boolean isTaken;

  /**
   * The constructor of the ArrowImpl class.
   *
   * @param position position of arrow
   */
  public ArrowImpl(Position position) {
    this.position = position;
    this.isTaken = false;
  }

  @Override
  public void take() {
    this.isTaken = true;
  }

  @Override
  public boolean isTaken() {
    return this.isTaken;
  }

}
