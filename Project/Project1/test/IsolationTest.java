import project.Food;
import project.Isolation;
import project.Monkey;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Isolation. Verifying that Isolation state is properly managed, and all Isolation
 * actions are properly validated.
 */
public class IsolationTest {

  @Test
  public void testAddCage() {
    Isolation isolation = new Isolation(10);
    isolation.addCage(5);
    Assert.assertEquals(isolation.getCage(), 15);
  }

  @Test
  public void testGetCage() {
    Isolation isolation = new Isolation(20);
    Assert.assertEquals(isolation.getCage(), 20);
  }

  @Test
  public void testAddMonkey() {
    Isolation isolation = new Isolation(10);
    isolation.addMonkey(new Monkey("spider"));
    isolation.addMonkey(new Monkey("spider"));

    Assert.assertEquals(isolation.getMonkeys().size(), 2);
    isolation.addMonkey(new Monkey("squirrel"));

    Assert.assertEquals(isolation.getMonkeys().size(), 3);
    Assert.assertTrue(isolation.addMonkey(new Monkey("squirrel")));
  }

  @Test
  public void testRemoveMonkey() {
    Isolation isolation = new Isolation(30);
    Monkey m1 = new Monkey("drill");
    Monkey m2 = new Monkey("guereza");
    m1.setAttention("m1", "male", 10, 30, 5, Food.INSECTS);
    m1.setAttention("m2", "male", 10, 20, 5, Food.TREE_SAP);

    Assert.assertTrue(isolation.addMonkey(m1));
    Assert.assertTrue(isolation.addMonkey(m2));
    Assert.assertEquals(isolation.getMonkeys().size(), 2);

    Assert.assertTrue(isolation.removeMonkey(m1));
    Assert.assertEquals(isolation.getMonkeys().size(), 1);
  }

  @Test
  public void testIsolationGetter() {
    Isolation isolation = new Isolation(10);
    isolation.addMonkey(new Monkey(" tamarin"));
    isolation.addMonkey(new Monkey(" tamarin"));

    Assert.assertEquals(isolation.getMonkeys().size(), 2);
    Assert.assertEquals(isolation.getCage(), 10);

    isolation.addCage(5);
    Assert.assertEquals(isolation.getCage(), 15);

    isolation.addCage(-10);
    Assert.assertEquals(isolation.getCage(), 5);
  }
}