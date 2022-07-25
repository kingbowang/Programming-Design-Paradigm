
/**
 * This class represents the information of a foot gear.
 */
public class FootGear extends AbstractGear {

  /**
   * The constructor of the Foot gear class which calls the abstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @param ability         the defense value for gear
   * @throws IllegalArgumentException If the attack is 0
   */
  public FootGear(String gearsName, String gearsAdjective,
      Ability ability) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, ability);
    // player's feet and affects the player's dexterity
      if(ability.getCharisma() != 0 || ability.getConstitution() != 0 || ability.getStrength() != 0){
          throw new IllegalArgumentException("HeadGear only affect player's dexterity.");
      }
  }

    @Override
    public int compareTo(Gear gear) {
        if(gear instanceof FootGear){
            return getName().compareTo(gear.getName());
        }else{
            return -1;
        }
    }
}
