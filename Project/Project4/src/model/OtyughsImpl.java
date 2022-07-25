package model;

import java.util.Random;
import utils.Position;

/**
 * Otyughs implementation class extends BaseClass and implements OtyughsInterface.
 * It mainly stores the blood volume of Otyughs and its position on the map.
 *
 * @author Pengbo Wang
 */
public class OtyughsImpl extends BaseClass implements Otyughs {
  private int blood;
  private static final int seed = 1024;

  /**
   * The constructor of the OtyughsImpl class.
   *
   * @param position the position of Otyughs
   */
  public OtyughsImpl(Position position) {
    this.position = position;
    this.blood = 2;
  }

  @Override
  public void underAttack() {
    if (this.isDead()) {
      return;
    }
    --this.blood;
  }

  @Override
  public boolean attack() {
    if (this.blood == 2) {
      return true;
    }
    if (this.blood == 0) {
      return false;
    }
    return new Random(seed).nextBoolean();
  }

  @Override
  public boolean isDead() {
    return this.blood == 0;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

}
