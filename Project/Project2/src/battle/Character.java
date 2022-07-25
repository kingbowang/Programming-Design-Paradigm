package battle;

import battle.ability.Ability;
import battle.gear.AbstractGear;
import battle.gear.BeltGear;
import battle.gear.BeltType;
import battle.gear.FootGear;
import battle.gear.Gear;
import battle.gear.HeadGear;
import battle.gear.PotionGear;
import battle.weapon.Weapon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * This class represents the information of a character.
 *
 * @author Pengbo Wang
 */
public class Character {
  private final String characterName;
  private final Ability ability;
  private final List<AbstractGear> headGears;
  private final List<AbstractGear> potionGears;
  private final List<AbstractGear> beltGears;
  private final List<AbstractGear> footGears;

  private int beltSize;
  private int lossHealth;

  private final List<Weapon> weapons;

  private int randomProperty() {
    Random random = new Random();
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      numbers.add(random.nextInt(5) + 2);
    }
    numbers.sort(Comparator.reverseOrder());
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += numbers.get(i);
    }
    return sum;
  }

  private Ability randomAbility() {
    return new Ability(randomProperty(),
            randomProperty(),
            randomProperty(),
            randomProperty());
  }

  /**
   * The constructor of the Character class.
   *
   * @param characterName character name
   * @throws IllegalArgumentException if the character name is null
   * @throws IllegalArgumentException if the character name is empty
   */
  public Character(String characterName) throws IllegalArgumentException {
    if (characterName == null) {
      throw new IllegalArgumentException("Character name is needed");
    }
    if (characterName.trim().isEmpty()) {
      throw new IllegalArgumentException("Character name is needed");
    }
    Ability ability = randomAbility();
    if (ability == null || ability.getConstitution() < 0 || ability.getStrength() < 0
            || ability.getDexterity() < 0 || ability.getCharisma() < 0) {
      throw new IllegalArgumentException("Character must have a "
              + "positive ability");
    }
    this.ability = ability;
    this.characterName = characterName.trim().toLowerCase();
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
    return characterName;
  }

  /**
   * Equips the character with a gear.
   *
   * @param o Gear
   */
  public void equip(Gear o) {
    if (o instanceof HeadGear) {
      equipHeadGear((AbstractGear) o);
    } else if (o instanceof FootGear) {
      equipFootGear((AbstractGear) o);
    } else if (o instanceof PotionGear) {
      equipPotion((AbstractGear) o);
    } else if (o instanceof BeltGear) {
      equipBelt((AbstractGear) o);
    } else {
      throw new IllegalArgumentException("Can't be equipped");
    }
  }

  /**
   * Equips the character with a headgear.
   *
   * @param o HeadGear
   */
  private void equipHeadGear(AbstractGear o) {
    if (headGears.isEmpty()) {
      headGears.add(o);
    } else if (headGears.get(0).getAbility().compareTo(o.getAbility()) > 0) {
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
    if (o instanceof BeltGear) {
      BeltGear beltGear = (BeltGear) o;
      int size;
      if (beltGear.getType() == BeltType.SMALL) {
        size = 1;
      } else if (beltGear.getType() == BeltType.MEDIUM) {
        size = 2;
      } else {
        size = 4;
      }
      if (beltSize + size <= 10) {
        beltGears.add(o);
        beltSize += size;
      }
    }
  }

  /**
   * Equips the character with weapon.
   *
   * @param o weapon
   */
  public void equipWeapon(Weapon o) {
    if (o.satisfyAbility(this)) {
      weapons.add(o);
    }
  }

  /**
   * Ability.
   *
   * @return ability
   */
  public Ability getAbility() {
    return ability;
  }

  /**
   * Get current ability.
   *
   * @return curAbility
   */
  public Ability currentAbility() {
    Ability curAbility = new Ability(0, 0, 0, 0);
    curAbility.addAbility(ability);
    for (AbstractGear gear : headGears) {
      curAbility.addAbility(gear.getAbility());
    }
    for (AbstractGear gear : potionGears) {
      curAbility.addAbility(gear.getAbility());
    }
    for (AbstractGear gear : beltGears) {
      curAbility.addAbility(gear.getAbility());
    }
    for (AbstractGear gear : footGears) {
      curAbility.addAbility(gear.getAbility());
    }
    return curAbility;
  }

  /**
   * Format string.
   *
   * @return ""
   */
  private String allHeadGear() {
    if (!(headGears.isEmpty())) {
      return headGears.get(0).toString();
    }
    return "";
  }

  /**
   * Format string.
   *
   * @return ""
   */
  private String allFootGear() {
    if (!(footGears.isEmpty())) {
      return footGears.get(0).toString();
    }
    return "";
  }

  /**
   * Get weapons.
   *
   * @return weapon
   */
  public List<Weapon> getWeapons() {
    return weapons;
  }

  /**
   * Format string.
   *
   * @return toString
   */
  private String allPotionGear() {
    StringBuilder sb = new StringBuilder();
    potionGears.sort(new Comparator<AbstractGear>() {
      @Override
      public int compare(AbstractGear abstractGear, AbstractGear t1) {
        return abstractGear.getName().compareTo(t1.getName());
      }
    });
    for (int i = 0; i < potionGears.size(); i++) {
      sb.append(String.format("no#%d: %s\n", i + 1, potionGears.get(i).toString()));
    }
    return sb.toString();
  }

  /**
   * Format string.
   *
   * @return toString
   */
  private String allBeltGear() {
    StringBuilder sb = new StringBuilder();
    beltGears.sort(new Comparator<AbstractGear>() {
      @Override
      public int compare(AbstractGear abstractGear, AbstractGear t1) {
        return abstractGear.getName().compareTo(t1.getName());
      }
    });
    for (int i = 0; i < beltGears.size(); i++) {
      sb.append(String.format("no#%d: %s\n", i + 1, beltGears.get(i).toString()));
    }
    return sb.toString();
  }

  /**
   * Format string.
   *
   * @return toString
   */
  private String allWeapon() {
    if (!(weapons.isEmpty())) {
      return weapons.get(0).toString();
    }
    return "";
  }

  /**
   * Get loss health.
   *
   * @return lossHealth
   */
  public int getLossHealth() {
    return lossHealth;
  }

  /**
   * Get weapon attack.
   *
   * @return attack
   */
  public int getWeaponAttack() {
    if (weapons.size() == 0) {
      return 0;
    }
    int attack = 0;
    for (Weapon weapon : weapons) {
      attack += weapon.getAttack();
    }
    return attack;
  }

  /**
   * Add loss health.
   *
   * @param lossHealth attack value is converted to lossHealth
   */
  public void addLossHealth(int lossHealth) {
    this.lossHealth += lossHealth;
  }

  /**
   * Reset players health.
   *
   * @param gearBags gears in bag
   * @param allWeapons weapons
   */
  public void resetHealth(List<AbstractGear> gearBags, List<Weapon> allWeapons) {
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
    StringBuilder character = new StringBuilder()
            .append(characterName).append(" is currently wearing:");
    character.append("\n\nHeadGear: ").append(allHeadGear());
    character.append("\n\nPotion:\n").append(allPotionGear());
    character.append("\nBelt:\n").append(allBeltGear());
    character.append("\nFootGear: ").append(allFootGear());
    character.append("\n\nWeapon: ").append(allWeapon());
    character.append("\n\nWith total health: ").append(curAbility.getHealth());
    character.append("\nWith a base attack of: ").append(getAbility().getStrength());
    character.append("\nWith a base defense of: ").append(getAbility().getDexterity());
    character.append("\nWith a base charisma of: ").append(getAbility().getCharisma());
    character.append("\nWith a modified attack of: ").append(curAbility.getStrength());
    character.append("\nWith a modified defense of: ").append(curAbility.getDexterity());
    character.append("\nWith a modified charisma of: ").append(curAbility.getCharisma());
    return character.toString();
  }
}
