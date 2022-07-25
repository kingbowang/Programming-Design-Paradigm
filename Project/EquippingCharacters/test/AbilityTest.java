import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing the Jewelry class.
 */
public class AbilityTest {
  private Ability ability1;
  private Ability ability2;

  @Before
  public void setUp() {
    ability1 = new Ability(10, 10, 5, 1);
    ability2 = new Ability(10, 10, 5, 2);
  }

  @Test
  public void getStrength() {
    assertEquals(10, ability1.getStrength());
  }

  @Test
  public void getConstitution() {
    assertEquals(10, ability1.getConstitution());
  }

  @Test
  public void getDexterity() {
    assertEquals(5, ability1.getDexterity());
  }

  @Test
  public void getCharisma() {
    assertEquals(1, ability1.getCharisma());
  }

  @Test
  public void testComparator() {
    assertEquals(0, ability1.compareTo(ability2));
  }
}