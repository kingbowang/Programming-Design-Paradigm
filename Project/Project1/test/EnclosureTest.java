import project.Food;
import project.Enclosure;
import project.Monkey;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Enclosure. Verifying that Enclosure state is properly managed, and all Enclosure
 * actions are properly validated.
 */
public class EnclosureTest {

  @Test
  public void testGetSize() {
    Enclosure enclosure = new Enclosure("drill", 120);
    Assert.assertEquals(enclosure.getSize(), 120);
  }

  @Test
  public void testGetSpecies() {
    Enclosure enclosure = new Enclosure("guereza", 110);
    Assert.assertEquals(enclosure.getSpecies(), "guereza");
  }

  @Test
  public void testAddMonkey() {
    Enclosure enclosure = new Enclosure("saki", 100);
    Assert.assertFalse(enclosure.addMonkey(new Monkey("saki")));
    Monkey m1 = new Monkey("saki");
    Monkey m2 = new Monkey("squirrel");
    Assert.assertFalse(enclosure.addMonkey(m2));
    m1.setAttention("m1", "male", 10, 10, 10, Food.INSECTS);
    Assert.assertTrue(enclosure.addMonkey(m1));
    Assert.assertEquals(enclosure.getMonkeys().size(), 1);
  }

  @Test
  public void testRemoveMonkey() {
    Enclosure enclosure = new Enclosure("mangabey", 90);
    Monkey m1 = new Monkey("mangabey");
    m1.setAttention("m1", "male", 30, 15, 5, Food.FRUITS);
    Assert.assertTrue(enclosure.addMonkey(m1));
    Assert.assertTrue(enclosure.removeMonkey(m1));
    Assert.assertEquals(enclosure.getMonkeys().size(), 0);
  }

  @Test
  public void testEnclosureGetter() {
    Enclosure enclosure = new Enclosure("saki", 100);
    Assert.assertFalse(enclosure.addMonkey(new Monkey("saki")));
    Monkey m1 = new Monkey("saki");
    Monkey m2 = new Monkey("squirrel");
    Assert.assertFalse(enclosure.addMonkey(m2));
    m1.setAttention("m1", "male", 10, 10, 10, Food.EGGS);
    Assert.assertEquals(enclosure.getSpecies(), "saki");
    Assert.assertEquals(enclosure.getSize(), 100);
  }

}