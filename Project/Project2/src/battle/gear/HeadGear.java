package battle.gear;

import battle.ability.Ability;

/**
 * This class represents the information of a HeadGear.
 *
 * @author Pengbo Wang
 */
public class HeadGear extends AbstractGear {

  /**
   * The constructor of the HeadGear class which calls AbstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @param ability        the defense value for gear
   * @throws IllegalArgumentException If the attack is 0
   */
  public HeadGear(String gearsName, String gearsAdjective,
                  Ability ability) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, ability);
    // is worn on the player's head and affects the player's constitution.
    // Since a player has one head, they can only wear one piece of headgear.
    if (ability.getCharisma() != 0 || ability.getDexterity() != 0 || ability.getStrength() != 0) {
      throw new IllegalArgumentException("HeadGear only affect player's constitution.");
    }
  }

  @Override
  public int compareTo(Gear gear) {
    if (gear instanceof HeadGear) {
      return getName().compareTo(gear.getName());
    } else {
      return 1;
    }
  }
}
