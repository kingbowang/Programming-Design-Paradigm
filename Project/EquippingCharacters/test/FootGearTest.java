import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing the Jewelry class.
 */
public class FootGearTest {
  private FootGear footGear1;
  private FootGear footGear2;

  @Before
  public void setUp() {
    Ability ability = new Ability(0, 0, 10, 0);
    footGear1 = new FootGear("Necklace", "Invincibility", ability);
    ability = new Ability(0, 0, 10, 0);
    footGear2 = new FootGear("Boots", "Electricity", ability);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    FootGear footGear = new FootGear("Helm", null, null);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAbility() {
    FootGear footGear = new FootGear("Helm", " ", null);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorAttackJewelry() {
    Ability ability = new Ability(0, 0, 10, 0);
    FootGear footGear = new FootGear("Amulet", "Magic ", ability);
    assertEquals("amulet of magic", footGear.toString());
  }

  @Test
  public void getDefenseName() {
    assertEquals("necklace", footGear1.getName());
  }

  @Test
  public void getDefenseAdjective() {
    assertEquals("invincibility", footGear1.getAdjective());
  }

  @Test
  public void getGetAbility() {
    assertEquals(0, footGear1.getAbility().getConstitution());
    assertEquals(10, footGear1.getAbility().getDexterity());
  }


  @Test
  public void getCompare() {
    assertEquals(12, footGear1.compareTo(footGear2));
  }
}