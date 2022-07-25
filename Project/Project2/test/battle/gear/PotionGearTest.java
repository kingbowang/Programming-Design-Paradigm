package battle.gear;

import battle.ability.Ability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing PotionGear class.
 *
 * @author Pengbo Wang
 */
public class PotionGearTest {
  private PotionGear potionGear1;
  private PotionGear potionGear2;

  @Before
  public void setUp() {
    Ability ability = new Ability(9, 1, 3, 0);
    potionGear1 = new PotionGear("Potion", "Explosion", ability);
    ability = new Ability(4, 0, 2, 2);
    potionGear2 = new PotionGear("Water", "Justice", ability);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPotionGearNullName() {
    PotionGear potionGear = new PotionGear("Potion", null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPotionGearEmptyAbility() {
    PotionGear potionGear = new PotionGear("Water", "", null);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void testConstructorAttackPotionGear() {
    Ability ability = new Ability(10, 10, 0, 0);
    PotionGear potionGear = new PotionGear("Potion", "Healing", ability);
    assertEquals("potion of healing", potionGear.toString());
  }

  @Test
  public void testGetPotionGearName() {
    assertEquals("potion", potionGear1.getName());
  }

  @Test
  public void testGetPotionGearAdjective() {
    assertEquals("explosion", potionGear1.getAdjective());
  }

  @Test
  public void testGetPotionAbility() {
    assertEquals(9, potionGear1.getAbility().getStrength());
    assertEquals(1, potionGear1.getAbility().getConstitution());
    assertEquals(3, potionGear1.getAbility().getDexterity());
    assertEquals(0, potionGear1.getAbility().getCharisma());
    assertEquals(4, potionGear2.getAbility().getStrength());
    assertEquals(0, potionGear2.getAbility().getConstitution());
    assertEquals(2, potionGear2.getAbility().getDexterity());
    assertEquals(2, potionGear2.getAbility().getCharisma());
  }

  @Test
  public void testGetCompare() {
    assertEquals(-7, potionGear1.compareTo(potionGear2));
  }
}
