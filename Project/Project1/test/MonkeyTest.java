import project.Food;
import project.Monkey;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Monkey. Verifying that Monkey state is properly managed, and all Isolation
 * actions are properly validated.
 */
public class MonkeyTest {

  @Test
  public void testGetAttention() {
    Monkey m = new Monkey("guereza");
    Assert.assertFalse(m.getAttention());
    m.setAttention("m1", "male", 10, 17, 2, Food.EGGS);
    Assert.assertTrue(m.getAttention());
  }

  @Test
  public void testGetName() {
    Monkey m = new Monkey("tamarin");
    m.setAttention("Jack", "male", 10, 16, 5, Food.LEAVES);
    Assert.assertEquals(m.getName(), "Jack");
  }

  @Test
  public void testGetSpecies() {
    Monkey m = new Monkey("howler");
    Assert.assertEquals(m.getSpecies(), "howler");
  }

  @Test
  public void testGetSex() {
    Monkey m = new Monkey("spider");
    m.setAttention("Sandy", "female", 10, 18, 3, Food.FRUITS);
    Assert.assertEquals(m.getSex(), "female");
  }

  @Test
  public void testGetSize() {
    Monkey m = new Monkey("drill");
    m.setAttention("Sasha", "female", 32, 21, 4, Food.INSECTS);
    Assert.assertEquals(m.getSize(), 32);
  }

  @Test
  public void testGetWeight() {
    Monkey n = new Monkey("saki");
    n.setAttention("Terry", "male", 13, 11, 3, Food.TREE_SAP);
    Assert.assertEquals(n.getWeight(), 11);
  }

  @Test
  public void testGetAge() {
    Monkey n = new Monkey("drill");
    n.setAttention("Paul", "male", 33, 41, 13, Food.SEEDS);
    Assert.assertEquals(n.getAge(), 13);
  }

  @Test
  public void testGetFood() {
    Monkey m = new Monkey("drill");
    m.setAttention("Paul", "male", 33, 41, 13, Food.SEEDS);
    Assert.assertEquals(m.getFood(), Food.SEEDS);
  }

  @Test
  public void testMonkeyGetter() {
    Monkey m = new Monkey("guereza");
    Assert.assertEquals(m.getSpecies(), "guereza");
    Assert.assertFalse(m.getAttention());

    m.setAttention("Bob", "male", 21, 19, 8, Food.NUTS);

    Assert.assertEquals(m.getName(), "Bob");
    Assert.assertTrue(m.getAttention());

    Assert.assertEquals(m.getSex(), "male");
    Assert.assertEquals(m.getAge(), 8);
    Assert.assertEquals(m.getSize(), 21);
    Assert.assertEquals(m.getWeight(), 19);
    Assert.assertEquals(m.getFood(), Food.NUTS);
  }
}