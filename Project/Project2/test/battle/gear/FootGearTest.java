package battle.gear;

import battle.ability.Ability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing FootGear class.
 *
 * @author Pengbo Wang
 */
public class FootGearTest {
  private FootGear footGear1;
  private FootGear footGear2;

  @Before
  public void setUp() {
    Ability ability = new Ability(0, 0, -3, 0);
    footGear1 = new FootGear("Shoes", "Doom", ability);
    ability = new Ability(0, 0, 3, 0);
    footGear2 = new FootGear("Boots", "Electricity", ability);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFootGearNullName() {
    FootGear footGear = new FootGear("Shoes", null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFootGearEmptyAbility() {
    FootGear footGear = new FootGear("Boots", "", null);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void testConstructorAttackFootGear() {
    Ability ability = new Ability(0, 0, 10, 0);
    FootGear footGear = new FootGear("Slipper", "Fire", ability);
    assertEquals("slipper of fire", footGear.toString());
  }

  @Test
  public void testGetFootGearName() {
    assertEquals("shoes", footGear1.getName());
  }

  @Test
  public void testGetFootGearAdjective() {
    assertEquals("doom", footGear1.getAdjective());
  }

  @Test
  public void testGetFootGearAbility() {
    assertEquals(0, footGear1.getAbility().getConstitution());
    assertEquals(-3, footGear1.getAbility().getDexterity());
    assertEquals(3, footGear2.getAbility().getDexterity());
    assertEquals(0, footGear1.getAbility().getCharisma());
  }

  @Test
  public void testGetCompare() {
    assertEquals(17, footGear1.compareTo(footGear2));
  }
}
