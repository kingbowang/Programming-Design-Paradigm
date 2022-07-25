import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * This class represents the information of a character.
 */
public class Character {
  private final String cName;
  private final Ability ability;
  private List<AbstractGear> headGears;
  private List<AbstractGear> potionGears;
  private List<AbstractGear> beltGears;
  private List<AbstractGear> footGears;

  private int beltSize;
  private int lossHealth;

  private List<Weapon> weapons;

  private int randomProperty(){
    Random random = new Random();
    List<Integer> nums = new ArrayList<>();
    for(int i = 0; i < 4; i ++){
      nums.add(random.nextInt(6)+1);
    }
    nums.sort(Comparator.reverseOrder());
    int sum = 0;
    for(int i = 0; i < 3; i ++){
      sum += nums.get(i);
    }
    return sum;
  }

  private Ability randomAbility(){
    return new Ability(randomProperty(),
        randomProperty(),
        randomProperty(),
        randomProperty());
  }

  /**
   * The constructor of the Character class.
   *
   * @param cName     character name
   * @throws IllegalArgumentException if the character name is null
   * @throws IllegalArgumentException if the character name is empty
   * @throws IllegalArgumentException if the character hitpoint, attack and defense are non
   *                                  positive
   */
  public Character(String cName) throws IllegalArgumentException {
    if (cName == null) {
      throw new IllegalArgumentException("Character name is needed");
    }
    if (cName.trim().isEmpty()) {
      throw new IllegalArgumentException("Character name is needed");
    }
    Ability ability = randomAbility();
    if (ability == null || ability.getConstitution() < 0 || ability.getStrength() < 0
        || ability.getDexterity() < 0 || ability.getCharisma() < 0) {
      throw new IllegalArgumentException("Character must have a "
              + "positive ability");
    }
    this.ability = ability;
    this.cName = cName.trim().toLowerCase();
    headGears = new ArrayList<>();
    footGears = new ArrayList<>();
    potionGears = new ArrayList<>();
    beltGears = new ArrayList<>();
    weapons = new ArrayList<>();
    beltSize = 0;
  }

  /**
   * Returns the name of the character.
   *
   * @return name
   */
  public String getName() {
    return cName;
  }

  /**
   * Equips the character with a gear.
   *
   * @param o Gear
   */
  public void equip(Gear o) {
    if (o instanceof HeadGear) {
      equipHeadGear((AbstractGear)o);
    } else if (o instanceof FootGear) {
      equipFootGear((AbstractGear)o);
    } else if (o instanceof PotionGear) {
      equipPotion((AbstractGear)o);
    } else if (o instanceof BeltGear) {
      equipBelt((AbstractGear)o);
    }else{
      throw new IllegalArgumentException("Can't be equipped");
    }
  }

  /**
   * Equips the character with a head gear.
   *
   * @param o head gear
   */
  private void equipHeadGear(AbstractGear o) {
    if (headGears.isEmpty()) {
      headGears.add(o);
    } else if (headGears.get(0).getAbility().compareTo(o.getAbility()) > 0) {
      System.out.printf("Replacing the %s "
              + "with the %s%n", headGears.get(0).toString(), o.toString());
      headGears.remove(0);
      headGears.add(o);
    }
    Collections.sort(headGears);
  }

  /**
   * Equips the character with a foot gear.
   *
   * @param o foot gear
   */
  private void equipFootGear(AbstractGear o) {
    if (footGears.size() < 2) {
      footGears.add(o);
    } else {
      if (footGears.get(1).getAbility().compareTo(o.getAbility()) > 0) {
        System.out.printf("Replacing the %s "
                + "with the %s%n", footGears.get(1).toString(), o.toString());
        footGears.remove(1);
        footGears.add(o);
      }
    }
    Collections.sort(footGears);
  }

  /**
   * Equips the character with a potion gear.
   * no limit size
   *
   * @param o potion gear
   */
  private void equipPotion(AbstractGear o) {
    potionGears.add(o);
  }

  /**
   * Equips the character with a jewelry.
   *
   * @param o jewelry
   */
  private void equipBelt(AbstractGear o) {
    if(o instanceof BeltGear){
      BeltGear beltGear = (BeltGear)o;
      int size = 0;
      if(beltGear.getType() == BeltType.SMALL){
        size = 1;
      }else if(beltGear.getType() == BeltType.MEDIUM){
        size = 2;
      }else{
        size = 4;
      }
      if(beltSize + size < 10){
        beltGears.add(o);
        beltSize += size;
      }
    }
  }

  /**
   * Equips the character with weapon
   * @param o weapon
   */
  public boolean equipWeapon(Weapon o){
    if(o.satisfyAbility(this)){
      weapons.add(o);
      return true;
    }
    return false;
  }

  /**
   * ability
   * @return
   */
  public Ability getAbility() {
    return ability;
  }

  /**
   * get current ability
   * @return
   */
  public Ability currentAbility(){
    Ability curAbility = new Ability(0, 0, 0, 0);
    curAbility.addAbility(ability);
    for(AbstractGear gear : headGears){
      curAbility.addAbility(gear.getAbility());
    }
    for(AbstractGear gear : potionGears){
      curAbility.addAbility(gear.getAbility());
    }
    for(AbstractGear gear : beltGears){
      curAbility.addAbility(gear.getAbility());
    }
    for(AbstractGear gear : footGears){
      curAbility.addAbility(gear.getAbility());
    }
    return curAbility;
  }

  /**
   * format string
   * @return
   */
  private String allHeadGear() {
    if (!(headGears.isEmpty())) {
      return headGears.get(0).toString();
    }
    return "";
  }

  /**
   * format string
   * @return
   */
  private String allFootGear() {
    if (!(footGears.isEmpty())) {
      return footGears.get(0).toString();
    }
    return "";
  }

  /**
   * get weapons
   * @return weapon
   */
  public List<Weapon> getWeapons() {
    return weapons;
  }

  /**
   * format string
   * @return
   */
  private String allPotionGear() {
    StringBuilder sb = new StringBuilder();
    potionGears.sort(new Comparator<AbstractGear>() {
      @Override
      public int compare(AbstractGear abstractGear, AbstractGear t1) {
        return abstractGear.getName().compareTo(t1.getName());
      }
    });
    for(int i = 0; i < potionGears.size(); i ++){
      sb.append(String.format("no#%d: %s\n", i+1, potionGears.get(i).toString()));
    }
    return sb.toString();
  }

  /**
   * format string
   * @return
   */
  private String allBeltGear() {
    StringBuilder sb = new StringBuilder();
    beltGears.sort(new Comparator<AbstractGear>() {
      @Override
      public int compare(AbstractGear abstractGear, AbstractGear t1) {
        return abstractGear.getName().compareTo(t1.getName());
      }
    });
    for(int i = 0; i < beltGears.size(); i ++){
      sb.append(String.format("no#%d: %s\n", i+1, beltGears.get(i).toString()));
    }
    return sb.toString();
  }

  /**
   * format string
   * @return
   */
  private String allWeapon() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < weapons.size(); i ++){
      sb.append(String.format("no#%d: %s\n", i+1, weapons.get(i).toString()));
    }
    return sb.toString();
  }

  /**
   * get loss health
   * @return
   */
  public int getLossHealth() {
    return lossHealth;
  }

  /**
   * get weapon attack
   * @return
   */
  public int getWeaponAttack(){
    if(weapons.size() == 0){
      return 0;
    }
    int attack = 0;
    for(Weapon weapon : weapons){
      attack += weapon.getAttack();
    }
    return attack;
  }

  /**
   * add loss health
   * @param lossHealth
   */
  public void addLossHealth(int lossHealth) {
    this.lossHealth += lossHealth;
  }

  public void resetHealth(List<AbstractGear> gearBags, List<Weapon> allWeapons){
    this.lossHealth = 0;
    gearBags.addAll(headGears);
    headGears.clear();
    gearBags.addAll(potionGears);
    potionGears.clear();
    gearBags.addAll(beltGears);
    beltGears.clear();
    gearBags.addAll(footGears);
    footGears.clear();
    allWeapons.addAll(weapons);
    weapons.clear();
  }

  /**
   * Returns the toString.
   *
   * @return toString
   */
  @Override
  public String toString() {
    Ability curAbility = currentAbility();
    StringBuilder character = new StringBuilder().append(cName).append(" is currently wearing:");
    character.append("\nHeadgear: ").append(allHeadGear());
    character.append("\nPotion: ").append(allPotionGear());
    character.append("\nBelt: ").append(allBeltGear());
    character.append("\nFootgear: ").append(allFootGear());
    character.append("\nWeapon: ").append(allWeapon());
    character.append("\nWith total health: ").append(curAbility.getHealth());
    character.append("\nWith a base attack of: ").append(getAbility().getStrength());
    character.append("\nWith a base defense of: ").append(getAbility().getDexterity());
    character.append("\nWith a base charisma of: ").append(getAbility().getCharisma());
    character.append("\nWith a modified attack of: ").append(curAbility.getStrength());
    character.append("\nWith a modified defense of: ").append(curAbility.getDexterity());
    character.append("\nWith a modified charisma of: ").append(curAbility.getCharisma());
    return character.toString();
  }
}
