package assignments;

import java.util.Comparator;
import java.util.List;

/**
 * Scheduling strategy that orders assignments in the order they were assigned.
 */
public class AssignedSchedulingStrategy implements SchedulingStrategy {

  @Override
  public String schedule(List<Assignment> tasks) throws IllegalArgumentException {
    if (tasks == null) {
      throw new IllegalArgumentException("cannot schedule a non-existing list");
    }
    String name = "assigned";
    Comparator<Assignment> comp = new ThisComparator();
    tasks.sort(comp);
    return name;
  }

  private static class ThisComparator implements Comparator<Assignment> {
    @Override
    public int compare(Assignment one, Assignment two) {
      return one.getNumber() - two.getNumber();
    }
  }

}
