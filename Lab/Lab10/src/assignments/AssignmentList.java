package assignments;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of task that need to be completed.
 */
public class AssignmentList {

  private final List<Assignment> tasks;
  private String ordering;

  /**
   * Default constructor.
   */
  public AssignmentList() {
    tasks = new ArrayList<>();
    ordering = "assigned";
  }

  /**
   * Add a task to the task list.
   *
   * @param t the task
   */
  public void add(Assignment t) {
    tasks.add(t);
  }

  /**
   * Schedules the assignments in the assignment list according to the provided
   * strategy.
   *
   * @param strategy the strategy to use
   */
  public void scheduleAssignments(SchedulingStrategy strategy) {
    if (strategy == null) {
      throw new IllegalArgumentException("Must provide a scheduling strategy");
    }
    ordering = strategy.schedule(tasks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Ordered by ");
    sb.append(ordering);
    sb.append("\n");
    for (int i = 0; i < tasks.size(); i++) {
      sb.append(i + 1);
      sb.append(" -- ");
      sb.append(tasks.get(i));
      sb.append("\n");
    }
    return sb.toString();
  }
}
