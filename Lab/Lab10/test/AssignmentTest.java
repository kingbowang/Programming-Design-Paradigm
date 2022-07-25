import static org.junit.Assert.assertEquals;

import assignments.AlphabeticalSchedulingStrategy;
import assignments.AssignedSchedulingStrategy;
import assignments.Assignment;
import assignments.AssignmentList;
import assignments.DeadlineSchedulingStrategy;
import assignments.DifficultySchedulingStrategy;
import assignments.SchedulingStrategy;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Class that tests the tasks.
 */
public class AssignmentTest {
  private AssignmentList todo;
  private Assignment beer;
  private Assignment review;
  private Assignment take;
  private Assignment complete;
  private Assignment turnIn;
  private Assignment extra;
  private SchedulingStrategy strategy;

  /**
   * Setup for all tests.
   */
  @Before
  public void setup() {
    todo = new AssignmentList();

    beer = new Assignment("buy beer");
    beer.setDeadline(11, 1, 2022);
    beer.setStart(11, 1, 2022);
    todo.add(beer);

    review = new Assignment("review module materials");
    review.setDeadline(11, 5, 2022);
    review.setStart(11, 1, 2022);
    todo.add(review);

    take = new Assignment("take quiz");
    take.setDeadline(11, 5, 2022);
    take.setStart(11, 5, 2022);
    todo.add(take);

    complete = new Assignment("complete self evaluation for Lab 8");
    complete.setDeadline(11, 11, 2022);
    complete.setStart(11, 9, 2022);
    todo.add(complete);

    turnIn = new Assignment("turn in CS5010 Module 9 Lab");
    turnIn.setDeadline(11, 7, 2022);
    turnIn.setStart(11, 2, 2022);
    todo.add(turnIn);

    extra = new Assignment("relax and have fun");
    extra.setDeadline(1, 11, 2022);
    extra.setStart(12, 20, 2021);
  }

  /**
   * Testing constructor and toString().
   */
  @Test
  public void testConstructor() {
    LocalDate now = LocalDate.now();
    System.out.println(now);
    Assignment t1 = new Assignment("task 1");
    assertEquals("task 1, starting " + now + ", ending " + now, t1.toString());
    Assignment t2 = new Assignment("task 2");
    t2.setDeadline(3, 4, 2025);
    assertEquals("task 2, starting " + now + ", ending 2025-03-04", t2.toString());
  }

  /**
   * A test that verifies that the AssignedSchedulingStrategy orders
   * assignments according to the order they were added to the AssignmentList.
   */
  @Test
  public void testAssignedSchedulingStrategy() {
    strategy = new AssignedSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n" //
                    + "1 -- %s\n" //
                    + "2 -- %s\n" //
                    + "3 -- %s\n" //
                    + "4 -- %s\n" //
                    + "5 -- %s\n", //
            "assigned", beer.toString(), review.toString(), //
            take.toString(), complete.toString(), turnIn.toString());
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that the AssignedSchedulingStrategy works
   * even after another strategy has been used to order the tasks.
   */
  @Test
  public void testAssignedSchedulingStrategyAfterOther() {
    strategy = new AlphabeticalSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    strategy = new AssignedSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n" //
                    + "1 -- %s\n" //
                    + "2 -- %s\n" //
                    + "3 -- %s\n" //
                    + "4 -- %s\n" //
                    + "5 -- %s\n", //
            "assigned", beer.toString(), review.toString(), //
            take.toString(), complete.toString(), turnIn.toString());
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that the AlphabeticalSchedulingStrategy
   * orders assignments alphabetically.
   */
  @Test
  public void testAlphabeticalSchedulingStrategy() {
    strategy = new AlphabeticalSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n" //
                    + "1 -- %s\n" //
                    + "2 -- %s\n" //
                    + "3 -- %s\n" //
                    + "4 -- %s\n" //
                    + "5 -- %s\n", //
            "alphabetical", beer.toString(), complete.toString(), //
            review.toString(), take.toString(), turnIn.toString());
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that the AlphabeticalSchedulingStrategy works
   * even after another strategy has been used to order the tasks.
   */
  @Test
  public void testAlphabeticalSchedulingStrategyAfterOther() {
    strategy = new DeadlineSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    strategy = new AlphabeticalSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n" //
                    + "1 -- %s\n" //
                    + "2 -- %s\n" //
                    + "3 -- %s\n" //
                    + "4 -- %s\n" //
                    + "5 -- %s\n", //
            "alphabetical", beer.toString(), complete.toString(), //
            review.toString(), take.toString(), turnIn.toString());
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that the DeadlineSchedulingStrategy
   * orders assignments according to their deadlines.
   */
  @Test
  public void testDeadlineSchedulingStrategy() {
    strategy = new DeadlineSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n" //
                    + "1 -- %s\n" //
                    + "2 -- %s\n" //
                    + "3 -- %s\n" //
                    + "4 -- %s\n" //
                    + "5 -- %s\n", //
            "deadline", beer.toString(), review.toString(), //
            take.toString(), turnIn.toString(), complete.toString());
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that the DeadlineSchedulingStrategy works
   * even after another strategy has been used to order the tasks.
   */
  @Test
  public void testDeadlineSchedulingStrategyAfterOther() {
    strategy = new DifficultySchedulingStrategy();
    todo.scheduleAssignments(strategy);
    strategy = new DeadlineSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n" //
                    + "1 -- %s\n" //
                    + "2 -- %s\n" //
                    + "3 -- %s\n" //
                    + "4 -- %s\n" //
                    + "5 -- %s\n", //
            "deadline", beer.toString(), review.toString(), //
            take.toString(), turnIn.toString(), complete.toString());
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that the DifficultySchedulingStrategy
   * orders assignments according to their difficulty.
   */
  @Test
  public void testDifficultySchedulingStrategy() {
    strategy = new DifficultySchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n"
                    + "1 -- %s\n"
                    + "2 -- %s\n"
                    + "3 -- %s\n"
                    + "4 -- %s\n"
                    + "5 -- %s\n",
            "difficulty", turnIn.toString(), review.toString(), //
            complete.toString(), beer.toString(), take.toString());
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that the DifficultySchedulingStrategy works
   * even after another strategy has been used to order the tasks.
   */
  @Test
  public void testDifficultySchedulingStrategyAfterOther() {
    strategy = new AssignedSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    strategy = new DifficultySchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n"
                    + "1 -- %s\n"
                    + "2 -- %s\n"
                    + "3 -- %s\n"
                    + "4 -- %s\n"
                    + "5 -- %s\n",
            "difficulty", turnIn.toString(), review.toString(), //
            complete.toString(), beer.toString(), take.toString());
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that tasks added after the call
   * to schedule are added at the end of the assignment list.
   */
  @Test
  public void testScheduleAddEnd() {
    strategy = new AssignedSchedulingStrategy();
    todo.scheduleAssignments(strategy);
    String expected = String.format("Ordered by %s\n" //
                    + "1 -- %s\n" //
                    + "2 -- %s\n" //
                    + "3 -- %s\n" //
                    + "4 -- %s\n" //
                    + "5 -- %s\n", //
            "assigned", beer.toString(), review.toString(), //
            take.toString(), complete.toString(), turnIn.toString());
    assertEquals(expected, todo.toString());
    expected += "6 -- " + extra.toString() + "\n";
    todo.add(extra);
    assertEquals(expected, todo.toString());
  }

  /**
   * A test that verifies that schedule raises an
   * IllegalArgumentException if the assignment list is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullAssignmentList() {
    strategy = new DifficultySchedulingStrategy();
    strategy.schedule(null);
  }

  /**
   * A test that verifies that schedule raises an
   * IllegalArgumentException if an invalid assignment list is given.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAssignmentList() {
    strategy = new AlphabeticalSchedulingStrategy();
    strategy.schedule(null);
  }

  /**
   * A test that verifies that schedule raises an
   * IllegalArgumentException if an invalid strategy name is given.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStrategyName() {
    todo.scheduleAssignments(null);
  }

}
