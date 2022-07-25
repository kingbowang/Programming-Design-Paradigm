
enum BeltType{
    SMALL, MEDIUM, LARGE
}

/**
 * This class represents the information of a foot gear.
 */
public class BeltGear extends AbstractGear {
    // belt size type
    private BeltType type;

  /**
   * The constructor of the belt gear class which calls the abstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @param ability         the defense value for gear
   * @throws IllegalArgumentException If the attack is 0
   */
  public BeltGear(String gearsName, String gearsAdjective,
      Ability ability, BeltType type) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, ability);
    this.type = type;
  }

    @Override
    public int compareTo(Gear gear) {
        if(gear instanceof BeltGear){
            return getName().compareTo(gear.getName());
        }else if(gear instanceof FootGear){
            return -1;
        }else{
            return 1;
        }
    }

    /**
     * get size type
     * @return size
     */
    public BeltType getType() {
        return type;
    }
}
