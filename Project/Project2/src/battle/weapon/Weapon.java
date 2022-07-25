package battle.weapon;

import battle.Character;
import battle.gear.Gear;
import java.util.Random;

/**
 * Implement Weapon class.
 *
 * @author Pengbo Wang
 */
public abstract class Weapon implements Gear {
  protected String name;
  protected String desc;
  protected int minAttack;
  protected int maxAttack;

  /**
   * The constructor of Weapon class.
   *
   * @param gearsName      name of gear
   * @param gearsAdjective adjective of the gear
   * @param minAttack      minimum attack value
   * @param maxAttack      maximum attack value
   * @throws IllegalArgumentException if the gear name or adjective is a null
   * @throws IllegalArgumentException If the gear name or adjective is empty
   */
  public Weapon(String gearsName, String gearsAdjective,
                int minAttack, int maxAttack) throws IllegalArgumentException {
    if (gearsName == null | gearsAdjective == null) {
      throw new IllegalArgumentException("Null values aren't allowed");
    }
    if (gearsName.trim().isEmpty() | gearsAdjective.trim().isEmpty()) {
      throw new IllegalArgumentException("Didn't put in a gear name and gear adjective");
    }
    if (minAttack < 0 || maxAttack < 0 || minAttack > maxAttack) {
      throw new IllegalArgumentException("Must have a positive attack.");
    }
    this.name = gearsName;
    this.desc = gearsAdjective;
    this.minAttack = minAttack;
    this.maxAttack = maxAttack;
  }

  /**
   * Judge whether player can equip this weapon.
   *
   * @param character character
   * @return null
   */
  public abstract boolean satisfyAbility(Character character);

  /**
   * Get weapon points of damage.
   *
   * @return attacked value
   */
  public int getAttack() {
    Random random = new Random();
    return minAttack + random.nextInt(maxAttack - minAttack + 1);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getAdjective() {
    return desc;
  }

  @Override
  public int compareTo(Gear gear) {
    if (gear instanceof Weapon) {
      return name.compareTo(gear.getName());
    }
    return 1;
  }

  /**
   * Returns the toString.
   *
   * @return toString
   */
  @Override
  public String toString() {
    return String.format("%s of %s", getName(), getAdjective());
  }
}
