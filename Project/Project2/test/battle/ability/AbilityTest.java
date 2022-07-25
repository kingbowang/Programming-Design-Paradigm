package battle.ability;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing Ability class.
 *
 * @author Pengbo Wang
 */
public class AbilityTest {
  private Ability ability1;
  private Ability ability2;

  @Before
  public void setUp() {
    ability1 = new Ability(10, 15, 5, 2);
    ability2 = new Ability(8, 12, 7, 3);
  }

  @Test
  public void testGetStrength() {
    assertEquals(10, ability1.getStrength());
    assertEquals(8, ability2.getStrength());
  }

  @Test
  public void testGetConstitution() {
    assertEquals(15, ability1.getConstitution());
    assertEquals(12, ability2.getConstitution());
  }

  @Test
  public void testGetDexterity() {
    assertEquals(5, ability1.getDexterity());
    assertEquals(7, ability2.getDexterity());
  }

  @Test
  public void testGetCharisma() {
    assertEquals(2, ability1.getCharisma());
    assertEquals(3, ability2.getCharisma());
  }

  @Test
  public void testComparator() {
    assertEquals(1, ability1.compareTo(ability2));
  }
}