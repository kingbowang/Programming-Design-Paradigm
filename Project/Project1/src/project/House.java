package project;

import java.util.List;

/**
 * Abstract class for house.
 */
public interface House {

  /**
   * Get all monkeys in this house.
   *
   * @return monkeys
   */
  List<Monkey> getMonkeys();

  /**
   * Add monkey to house.
   *
   * @param monkey monkey
   * @return status
   */
  boolean addMonkey(Monkey monkey);

  /**
   * Remove monkey from house.
   *
   * @param monkey monkey
   * @return status
   */
  boolean removeMonkey(Monkey monkey);
}
