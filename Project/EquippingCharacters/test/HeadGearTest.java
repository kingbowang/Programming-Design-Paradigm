import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing the Jewelry class.
 */
public class HeadGearTest {
  private HeadGear headGear1;
  private HeadGear headGear2;

  @Before
  public void setUp() {
    Ability ability = new Ability(0, 10, 0, 0);
    headGear1 = new HeadGear("Necklace", "Invincibility", ability);
    ability = new Ability(0, 10, 0, 0);
    headGear2 = new HeadGear("Boots", "Electricity", ability);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    HeadGear headGear = new HeadGear("Helm", null, null);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAbility() {
    HeadGear headGear = new HeadGear("Helm", " ", null);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorAttackJewelry() {
    Ability ability = new Ability(0, 10, 0, 0);
    HeadGear headGear = new HeadGear("Amulet", "Magic ", ability);
    assertEquals("amulet of magic", headGear.toString());
  }

  @Test
  public void getDefenseName() {
    assertEquals("necklace", headGear1.getName());
  }

  @Test
  public void getDefenseAdjective() {
    assertEquals("invincibility", headGear1.getAdjective());
  }

  @Test
  public void getGetAbility() {
    assertEquals(0, headGear1.getAbility().getStrength());
    assertEquals(10, headGear1.getAbility().getConstitution());
  }


  @Test
  public void getCompare() {
    assertEquals(12, headGear1.compareTo(headGear2));
  }
}