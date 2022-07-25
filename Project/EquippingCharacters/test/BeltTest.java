import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing the Jewelry class.
 */
public class BeltTest {
  private BeltGear beltGear1;
  private BeltGear beltGear2;

  @Before
  public void setUp() {
    Ability ability = new Ability(10, 10, 0, 0);
    beltGear1 = new BeltGear("Necklace", "Invincibility", ability, BeltType.SMALL);
    ability = new Ability(10, 10, 0, 0);
    beltGear2 = new BeltGear("Boots", "Electricity", ability, BeltType.LARGE);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    BeltGear beltGear = new BeltGear("Helm", null, null, BeltType.SMALL);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAbility() {
    BeltGear beltGear = new BeltGear("Helm", " ", null, BeltType.SMALL);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorAttackJewelry() {
    Ability ability = new Ability(10, 10, 0, 0);
    BeltGear beltGear = new BeltGear("Amulet", "Magic ", ability, BeltType.MEDIUM);
    assertEquals("amulet of magic", beltGear.toString());
  }

  @Test
  public void getDefenseName() {
    assertEquals("necklace", beltGear1.getName());
  }

  @Test
  public void getDefenseAdjective() {
    assertEquals("invincibility", beltGear1.getAdjective());
  }

  @Test
  public void getGetType() {
    assertEquals(BeltType.SMALL, beltGear1.getType());
  }

  @Test
  public void getGetAbility() {
    assertEquals(10, beltGear1.getAbility().getStrength());
    assertEquals(10, beltGear1.getAbility().getConstitution());
  }


  @Test
  public void getCompare() {
    assertEquals(12, beltGear1.compareTo(beltGear2));
  }
}