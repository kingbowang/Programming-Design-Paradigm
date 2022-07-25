package battle.ability;

/**
 * Implement Ability class.
 * Players have four different abilities: Strength, Constitution,
 * Dexterity and Charisma.
 *
 * @author Pengbo Wang
 */
public class Ability implements Comparable<Ability> {
  // ability argument, which can be positive or negative
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;

  /**
   * Construct for abilities.
   *
   * @param strength affects how effective the player is at striking their opponent
   * @param constitution affects how much damage a player can take when they are hit in battle
   * @param dexterity affects how effective the player is at avoiding a strike from their opponent
   * @param charisma affects how their opponent views them
   */
  public Ability(int strength, int constitution, int dexterity, int charisma) {
    this.strength = strength;
    this.constitution = constitution;
    this.dexterity = dexterity;
    this.charisma = charisma;
  }

  /**
   * Add more abilities.
   *
   * @param ability ability
   */
  public void addAbility(Ability ability) {
    this.strength += ability.getStrength();
    this.constitution += ability.getConstitution();
    this.dexterity += ability.getDexterity();
    this.charisma += ability.getCharisma();
  }

  /**
   * Get all health.
   *
   * @return abilities
   */
  public int getHealth() {
    return strength + constitution + dexterity + charisma;
  }

  /**
   * Get strength.
   *
   * @return strength
   */
  public int getStrength() {
    return strength;
  }

  /**
   * Get constitution.
   *
   * @return constitution
   */
  public int getConstitution() {
    return constitution;
  }

  /**
   * Get dexterity.
   *
   * @return dexterity
   */
  public int getDexterity() {
    return dexterity;
  }

  /**
   * Get charisma.
   *
   * @return charisma
   */
  public int getCharisma() {
    return charisma;
  }

  /**
   * Compare ability exceed charisma.
   *
   * @param ability ability
   * @return compare result
   */
  @Override
  public int compareTo(Ability ability) {
    return Integer.compare(getStrength() + getDexterity() + getConstitution(),
            ability.getDexterity() + ability.getConstitution() + ability.getStrength());
  }
}
