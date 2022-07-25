package assignments;

import java.util.Comparator;
import java.util.List;

/**
 * Scheduling strategy that orders assignments in lexicographical order.
 */
public class AlphabeticalSchedulingStrategy implements SchedulingStrategy {

  @Override
  public String schedule(List<Assignment> tasks) throws IllegalArgumentException {
    if (tasks == null) {
      throw new IllegalArgumentException("cannot schedule a non-existing list");
    }
    String name = "alphabetical";
    Comparator<Assignment> comp = new ThisComparator();
    tasks.sort(comp);
    return name;
  }

  private static class ThisComparator implements Comparator<Assignment> {
    @Override
    public int compare(Assignment one, Assignment two) {
      return one.getDescription().compareTo(two.getDescription());
    }
  }

}
