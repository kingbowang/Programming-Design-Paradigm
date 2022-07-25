package model;

import utils.Position;

/**
 * Implement Otyughs interface and defines some methods of Otyughs.
 *
 * @author Pengbo Wang
 */
public interface Otyughs {

  /**
   * Otyughs is under attack, this method will cause Otyughs' blood volume to decrease.
   */
  void underAttack();

  /**
   * Otyugh attacks the player. If its HP is 2, then the attack is sure to succeed.
   * If it is 1, then there is a 50% probability that the attack will succeed.
   *
   * @return whether the player is under attack
   */
  boolean attack();

  /**
   * Determine if Otyugh has died.
   *
   * @return a boolean value, representing whether Otyugh has died.
   */
  boolean isDead();

  /**
   * Get the location of Otyughs on the map.
   *
   * @return a position value stores the position of Otyughs
   */
  Position getPosition();

}
