package project;

import java.util.List;

/**
 * Sanctuary class.
 */
public final class Sanctuary {
  // isolation object
  private final Isolation isolation;
  // all enclosures
  private final List<Enclosure> troops;

  /**
   * Construct for Sanctuary.
   *
   * @param isolation isolation
   * @param troops    troops
   */
  public Sanctuary(Isolation isolation, List<Enclosure> troops) {
    this.isolation = isolation;
    this.troops = troops;
  }

  /**
   * Add new monkey.
   *
   * @param monkey monkey
   * @return status
   */
  public boolean addMonkey(Monkey monkey) {
    if (monkey.getAttention()) {
      for (Enclosure enclosure : getEnclosures()) {
        if (enclosure.getSpecies().equals(monkey.getSpecies())) {
          if (enclosure.addMonkey(monkey)) {
            return true;
          }
        }
      }
    } else {
      return isolation.addMonkey(monkey);
    }
    return false;
  }

  /**
   * Remove monkey.
   *
   * @param monkey monkey
   * @return status
   */
  public boolean removeMonkey(Monkey monkey) {
    if (!isolation.removeMonkey(monkey)) {
      if (monkey.getAttention()) {
        for (Enclosure enclosure : getEnclosures()) {
          if (enclosure.getSpecies().equals(monkey.getSpecies())) {
            if (enclosure.removeMonkey(monkey)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  /**
   * Get isolation.
   *
   * @return isolation
   */
  public Isolation getIsolation() {
    return isolation;
  }

  /**
   * Get enclosures.
   *
   * @return troops
   */
  public List<Enclosure> getEnclosures() {
    return troops;
  }

  /**
   * Add new enclosure.
   *
   * @return troops
   */
  public boolean addEnclosure(Enclosure troop) {
    troops.add(troop);
    return true;
  }
}
