package battle.gear;

import battle.ability.Ability;

/**
 * This class represents the information of the potion gear.
 *
 * @author Pengbo Wang
 */
public class PotionGear extends AbstractGear {

  /**
   * The constructor of the PotionGear class which calls the AbstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @param ability        the defense value for gear
   */
  public PotionGear(String gearsName, String gearsAdjective,
                    Ability ability) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, ability);
  }

  @Override
  public int compareTo(Gear gear) {
    if (gear instanceof PotionGear) {
      return getName().compareTo(gear.getName());
    } else if (gear instanceof HeadGear) {
      return -1;
    } else {
      return 1;
    }
  }
}
