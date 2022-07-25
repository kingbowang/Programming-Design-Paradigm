import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing the Jewelry class.
 */
public class PotionGearTest {
  private PotionGear potionGear1;
  private PotionGear potionGear2;

  @Before
  public void setUp() {
    Ability ability = new Ability(10, 10, 0, 0);
    potionGear1 = new PotionGear("Necklace", "Invincibility", ability);
    ability = new Ability(10, 10, 0, 0);
    potionGear2 = new PotionGear("Boots", "Electricity", ability);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    PotionGear potionGear = new PotionGear("Helm", null, null);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAbility() {
    PotionGear potionGear = new PotionGear("Helm", " ", null);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorAttackJewelry() {
    Ability ability = new Ability(10, 10, 0, 0);
    PotionGear potionGear = new PotionGear("Amulet", "Magic ", ability);
    assertEquals("amulet of magic", potionGear.toString());
  }

  @Test
  public void getDefenseName() {
    assertEquals("necklace", potionGear1.getName());
  }

  @Test
  public void getDefenseAdjective() {
    assertEquals("invincibility", potionGear1.getAdjective());
  }

  @Test
  public void getGetAbility() {
    assertEquals(10, potionGear1.getAbility().getStrength());
    assertEquals(10, potionGear1.getAbility().getConstitution());
  }


  @Test
  public void getCompare() {
    assertEquals(12, potionGear1.compareTo(potionGear2));
  }
}