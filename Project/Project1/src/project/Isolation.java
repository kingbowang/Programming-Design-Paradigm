package project;

import java.util.ArrayList;
import java.util.List;

/**
 * Isolation class.
 */
public final class Isolation implements House {

  // cage size
  private int cage;

  // monkeys
  private final List<Monkey> monkeys;

  /**
   * Construct.
   *
   * @param cage size
   */
  public Isolation(int cage) {
    this.cage = cage;
    monkeys = new ArrayList<>();
  }

  /**
   * Add new cages.
   *
   * @param inCage cage
   */
  public void addCage(int inCage) {
    cage += inCage;
  }

  /**
   * Get cages.
   *
   * @return cages
   */
  public int getCage() {
    return cage;
  }

  /**
   * Get all monkeys.
   *
   * @return monkeys
   */
  @Override
  public List<Monkey> getMonkeys() {
    return monkeys;
  }

  /**
   * Add monkeys.
   *
   * @param monkey monkey
   * @return status
   */
  @Override
  public boolean addMonkey(Monkey monkey) {
    // has empty cage
    if (monkeys.size() + 1 < cage) {
      monkeys.add(monkey);
      return true;
    }
    return false;
  }

  /**
   * Remove monkeys.
   *
   * @param monkey monkey
   * @return status
   */
  @Override
  public boolean removeMonkey(Monkey monkey) {
    // move monkey away
    for (Monkey m : monkeys) {
      // test the def of monkey
      if (m == monkey) {
        monkeys.remove(monkey);
        return true;
      }
    }
    return false;
  }
}
