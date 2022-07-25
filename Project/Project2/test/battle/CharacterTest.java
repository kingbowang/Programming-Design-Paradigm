package battle;

import battle.ability.Ability;
import battle.gear.Gear;
import battle.gear.FootGear;
import battle.gear.HeadGear;
import battle.weapon.Broadsword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testing Character class.
 *
 * @author Pengbo Wang
 */
public class CharacterTest {
  private Character player1;

  @Before
  public void setUp() {
    player1 = new Character("Abdul");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNameNull() {
    player1 = new Character(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNameEmpty() {
    player1 = new Character("");
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void testConstructor() {
    Character player2 = new Character("Vic");
    assertNotNull(player2);
  }

  @Test
  public void testGetName() {
    assertEquals("abdul", player1.getName());
  }

  @Test
  public void testGetWeapon() {
    assertEquals(player1.getWeapons().size(), 0);
  }

  @Test
  public void testGetLossHealth() {
    assertEquals(player1.getLossHealth(), 0);
  }

  @Test
  public void testGetAbility() {
    assertNotNull(player1.getAbility());
  }

  @Test
  public void testGetWeapons() {
    assertEquals(player1.getWeaponAttack(), 0);
    player1.equipWeapon(new Broadsword("Katana", "Ice"));
    assertEquals(player1.getWeapons().size(), 1);
  }

  @Test
  public void testGetWeaponAttack() {
    assertEquals(player1.getWeaponAttack(), 0);
    player1.equipWeapon(new Broadsword("Broadsword", "Water"));
    assertEquals(player1.getWeapons().size(), 1);
    assertTrue(player1.getWeaponAttack() >= 7);
  }

  /**
   * Test the modifiedAttack method and equip method.
   */
  @Test
  public void testGetModifiedAttack() {
    Character player1 = new Character("Vic");
    Gear footGear = new FootGear("Boots", "electricity",
            new Ability(0, 0, 2, 0));
    player1.equip(footGear);

    Gear headGear = new HeadGear("Helm", "Flight",
            new Ability(0, 3, 0, 0));
    player1.equip(headGear);
    assertNotNull(player1);
  }

}