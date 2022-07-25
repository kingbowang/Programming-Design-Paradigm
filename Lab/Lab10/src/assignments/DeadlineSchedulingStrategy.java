package assignments;

import java.util.Comparator;
import java.util.List;

/**
 * Scheduling strategy that orders assignments in the order they are due.
 * Assignments that are due on the same day appear in lexicographical order.
 */
public class DeadlineSchedulingStrategy implements SchedulingStrategy {

  @Override
  public String schedule(List<Assignment> tasks) throws IllegalArgumentException {
    if (tasks == null) {
      throw new IllegalArgumentException("cannot schedule a non-existing list");
    }
    String name = "deadline";
    Comparator<Assignment> comp = new ThisComparator();
    tasks.sort(comp);
    return name;
  }

  private static class ThisComparator implements Comparator<Assignment> {
    @Override
    public int compare(Assignment one, Assignment two) {
      int result = one.getEndDate().compareTo(two.getEndDate());
      if (result == 0) {
        result = one.getDescription().compareTo(two.getDescription());
      }
      return result;
    }
  }

}
