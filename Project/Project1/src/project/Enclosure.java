package project;

import java.util.ArrayList;
import java.util.List;

/**
 * Enclosure class.
 * species type, enclosure's size
 * store all monkeys with the same species type
 */
public final class Enclosure implements House {
  private String species;
  private final int size;
  private final List<Monkey> monkeys;

  /**
   * Construct.
   *
   * @param species Monkey type
   * @param size    Enclosure size
   */
  public Enclosure(String species, int size) {
    this.species = species;
    this.size = size;
    this.monkeys = new ArrayList<>();
  }

  /**
   * Construct.
   * store all monkeys with the same species type
   */
  @Override
  public List<Monkey> getMonkeys() {
    return monkeys;
  }

  /**
   * Get monkey size by the size.
   *
   * @param m monkey
   * @return size
   */
  private int getMonkeySize(Monkey m) {
    if (m.getSize() < 10) {
      return 1;
    } else if (m.getSize() < 20) {
      return 5;
    } else {
      return 10;
    }
  }

  /**
   * Add Monkey to Enclosure.
   *
   * @param monkey monkey
   * @return status
   */
  @Override
  public boolean addMonkey(Monkey monkey) {
    if (!monkey.getAttention()) {
      return false;
    }
    if (monkey.getSpecies().equals(species)) {
      int totalSize = 0;
      for (Monkey m : monkeys) {
        totalSize += getMonkeySize(m);
      }
      if (totalSize + getMonkeySize(monkey) < size) {
        monkeys.add(monkey);
        return true;
      }
    }
    return false;
  }

  /**
   * Remove Monkey from Enclosure.
   *
   * @param monkey monkey
   * @return status
   */
  @Override
  public boolean removeMonkey(Monkey monkey) {
    // move monkey away
    for (Monkey m : monkeys) {
      if (m.equals(monkey)) {
        monkeys.remove(monkey);
        return true;
      }
    }
    return false;
  }

  /**
   * Get species.
   *
   * @return species
   */
  public String getSpecies() {
    return species;
  }

  /**
   * Set enclosure species.
   *
   * @param species type
   * @return set status
   */
  public boolean setSpecies(String species) {
    if (this.monkeys.size() == 0) {
      this.species = species;
      return true;
    }
    return false;
  }

  /**
   * Get size.
   *
   * @return size
   */
  public int getSize() {
    return size;
  }
}
