package battle.gear;

import battle.ability.Ability;

/**
 * This class represents the AbstractGear
 * which implements the gear interface that can be extended.
 *
 * @author Pengbo Wang
 */
public abstract class AbstractGear implements Gear {
  protected final String gearName;
  protected final String gearAdjective;
  protected Ability ability;

  /**
   * The constructor of the AbstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @throws IllegalArgumentException If the gear name or adjective is a null
   * @throws IllegalArgumentException If the gear name or adjective is empty
   */
  public AbstractGear(String gearsName, String gearsAdjective,
                      Ability ability) throws IllegalArgumentException {
    if (gearsName == null | gearsAdjective == null) {
      throw new IllegalArgumentException("Null values aren't allowed");
    }
    if (gearsName.trim().isEmpty() | gearsAdjective.trim().isEmpty()) {
      throw new IllegalArgumentException("Didn't put in a gear name and gear adjective");
    }
    if (ability == null) {
      throw new IllegalArgumentException("Must have a positive or negative attack.");
    }
    this.gearName = gearsName.toLowerCase().trim();
    this.gearAdjective = gearsAdjective.toLowerCase().trim();
    this.ability = ability;
  }

  /**
   * Returns the name of the gear.
   *
   * @return name
   */
  @Override
  public String getName() {
    return gearName;
  }

  /**
   * Returns the adjective of the gear.
   *
   * @return adjective
   */
  @Override
  public String getAdjective() {
    return gearAdjective;
  }

  /**
   * Get ability.
   *
   * @return ability
   */
  public Ability getAbility() {
    return ability;
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

