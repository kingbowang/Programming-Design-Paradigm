package assignments;

import java.util.List;

/**
 * An interface for scheduling strategies.
 */
public interface SchedulingStrategy {

  /**
   * Schedule tasks according to the current strategy.
   *
   * @param tasks the list of tasks
   * @return description of the type of scheduling
   * @throws IllegalArgumentException if tasks is null
   */
  String schedule(List<Assignment> tasks) throws IllegalArgumentException;

}
