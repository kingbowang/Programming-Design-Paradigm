package battle.gear;

import battle.ability.Ability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing HeadGear class.
 *
 * @author Pengbo Wang
 */
public class HeadGearTest {
  private HeadGear headGear1;
  private HeadGear headGear2;

  @Before
  public void setUp() {
    Ability ability = new Ability(0, 7, 0, 0);
    headGear1 = new HeadGear("Helm", "Flight", ability);
    ability = new Ability(0, 3, 0, 0);
    headGear2 = new HeadGear("Headband", "Flame", ability);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testHeadGearNullName() {
    HeadGear headGear = new HeadGear("Helm", null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testHeadGearEmptyAbility() {
    HeadGear headGear = new HeadGear("Helm", "", null);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void testConstructorAttackHeadGear() {
    Ability ability = new Ability(0, 10, 0, 0);
    HeadGear headGear = new HeadGear("Hat", "Devil", ability);
    assertEquals("hat of devil", headGear.toString());
  }

  @Test
  public void testGetHeadGearName() {
    assertEquals("helm", headGear1.getName());
  }

  @Test
  public void testGetHeadGearAdjective() {
    assertEquals("flight", headGear1.getAdjective());
  }

  @Test
  public void testGetHeadGearAbility() {
    assertEquals(0, headGear1.getAbility().getStrength());
    assertEquals(7, headGear1.getAbility().getConstitution());
    assertEquals(3, headGear2.getAbility().getConstitution());
    assertEquals(0, headGear2.getAbility().getDexterity());
  }

  @Test
  public void testGetCompare() {
    assertEquals(11, headGear1.compareTo(headGear2));
  }
}
