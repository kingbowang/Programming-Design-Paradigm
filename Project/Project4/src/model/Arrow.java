package model;

/**
 * Defines some methods of arrow, including the method of being
 * picked up and judging whether it can be picked up.
 *
 * @author Pengbo Wang
 */
public interface Arrow {

  /**
   * Arrow is picked up. This method will cause arrow to
   * no longer be picked up because it has been picked up.
   */
  void take();

  /**
   * Determine whether an arrow has been picked up.
   *
   * @return a boolean value, representing whether the arrow has been picked
   */
  boolean isTaken();

}
