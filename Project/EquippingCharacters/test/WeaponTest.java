import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Testing the Jewelry class.
 */
public class WeaponTest {
  private Weapon weapon1;
  private Weapon weapon2;
  private Weapon weapon3;
  private Weapon weapon4;
  private Weapon weapon5;

  @Before
  public void setUp() {
    weapon1 = new Katana("katana kill", "kill forever");
    weapon2 = new Katana("Broadswords kill", "kill forever");
    weapon3 = new Katana("Two-handed swords", "kill enemy");
    weapon4 = new Katana("Axes kill", "kill forever");
    weapon5 = new Katana("Flails kill", "kill forever");
  }

  @Test
  public void getSatisfy3() {
    Character character = new Character("c");

    assertTrue(weapon1.satisfyAbility(character));
    assertTrue(weapon2.satisfyAbility(character));
    assertTrue(weapon4.satisfyAbility(character));
  }

  @Test
  public void getSatisfy4() {
    Character character = new Character("c");

    assertTrue(weapon3.satisfyAbility(character));
    assertTrue(weapon5.satisfyAbility(character));
  }

}