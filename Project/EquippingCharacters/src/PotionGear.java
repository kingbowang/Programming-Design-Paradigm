
/**
 * This class represents the information of a foot gear.
 */
public class PotionGear extends AbstractGear {

  /**
   * The constructor of the Head gear class which calls the abstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @param attack         the defense value for gear
   * @throws IllegalArgumentException If the attack is 0
   */
  public PotionGear(String gearsName, String gearsAdjective,
      Ability ability) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, ability);
  }

    @Override
    public int compareTo(Gear gear) {
        if(gear instanceof PotionGear){
            return getName().compareTo(gear.getName());
        }else if(gear instanceof HeadGear) {
            return -1;
        }else{
            return 1;
        }
    }
}
