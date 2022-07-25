package assignments;

import java.util.Comparator;
import java.util.List;

/**
 * Scheduling strategy that orders assignments by their difficulty.
 * Assignments with the same difficulty appear in lexicographical order.
 */
public class DifficultySchedulingStrategy implements SchedulingStrategy {

  @Override
  public String schedule(List<Assignment> tasks) throws IllegalArgumentException {
    if (tasks == null) {
      throw new IllegalArgumentException("cannot schedule a non-existing list");
    }
    String name = "difficulty";
    Comparator<Assignment> comp = new ThisComparator();
    tasks.sort(comp);
    return name;
  }

  private static class ThisComparator implements Comparator<Assignment> {
    @Override
    public int compare(Assignment one, Assignment two) {
      int result = two.getDifficulty() - one.getDifficulty();
      if (result == 0) {
        result = one.getDescription().compareTo(two.getDescription());
      }
      return result;
    }
  }

}
