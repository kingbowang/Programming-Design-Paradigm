package battle.gear;

import battle.ability.Ability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing the Belts.
 *
 * @author Pengbo Wang
 */
public class BeltTest {
  private BeltGear beltGear1;
  private BeltGear beltGear2;
  private BeltGear beltGear3;

  @Before
  public void setUp() {
    Ability ability = new Ability(9, 6, 0, 0);
    beltGear1 = new BeltGear("Belt", "Strength", ability, BeltType.SMALL);
    ability = new Ability(0, 0, 5, 8);
    beltGear2 = new BeltGear("Belt", "Speed", ability, BeltType.LARGE);
    ability = new Ability(0, 0, 4, 8);
    beltGear3 = new BeltGear("Belt", "Wind", ability, BeltType.MEDIUM);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBeltGearNullName() {
    BeltGear beltGear = new BeltGear(null, null, null, BeltType.SMALL);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBeltGearEmptyAdjective() {
    BeltGear beltGear = new BeltGear("Belt", "", null, BeltType.SMALL);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void testConstructorAttackBelt() {
    Ability ability = new Ability(4, 18, 0, 0);
    BeltGear beltGear = new BeltGear("Belt", "Magic ", ability, BeltType.MEDIUM);
    assertEquals("belt of magic", beltGear.toString());
  }

  @Test
  public void testGetBeltGearName() {
    assertEquals("belt", beltGear1.getName());
  }

  @Test
  public void testGetBeltGearAdjective() {
    assertEquals("strength", beltGear1.getAdjective());
  }

  @Test
  public void testGetBeltType() {
    assertEquals(BeltType.SMALL, beltGear1.getType());
    assertEquals(BeltType.LARGE, beltGear2.getType());
    assertEquals(BeltType.MEDIUM, beltGear3.getType());
  }

  @Test
  public void testGetBeltAbility() {
    assertEquals(9, beltGear1.getAbility().getStrength());
    assertEquals(6, beltGear1.getAbility().getConstitution());
    assertEquals(5, beltGear2.getAbility().getDexterity());
    assertEquals(8, beltGear2.getAbility().getCharisma());
  }

  @Test
  public void testGetCompare() {
    assertEquals(0, beltGear1.compareTo(beltGear2));
  }
}
