package battle.weapon;

import battle.Character;
import battle.ability.Ability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testing Weapon class.
 */
public class WeaponTest {
  private Weapon katana;
  private Weapon broadsword;
  private Weapon twoHandedSword;
  private Weapon axes;
  private Weapon flail;

  @Before
  public void setUp() {
    katana = new Katana("Katana", "Ice");
    broadsword = new Broadsword("Broadsword", "Water");
    twoHandedSword = new TwoHandedSword("Two-handed sword", "Poison");
    axes = new Axes("Axe", "Flame");
    flail = new Flail("Flail", "Sleep");
  }

  @Test
  public void testSatisfyAbility1() {
    Character character = new Character("Vic");

    assertTrue(katana.satisfyAbility(character));
    assertTrue(broadsword.satisfyAbility(character));
    assertTrue(axes.satisfyAbility(character));
  }

  @Test
  public void testSatisfyAbility2() {
    Character character = new Character("Abdul");

    assertTrue(twoHandedSword.satisfyAbility(character));
    assertTrue(flail.satisfyAbility(character));
  }

  @Test
  public void testGetWeaponAttack1() {
    assertTrue(katana.getAttack() >= 4);
    assertTrue(katana.getAttack() <= 6);
    assertTrue(broadsword.getAttack() >= 6);
    assertTrue(broadsword.getAttack() <= 10);
    assertTrue(axes.getAttack() >= 6);
    assertTrue(axes.getAttack() <= 10);
  }

  @Test
  public void testGetWeaponAttack2() {
    Character character = new Character("Abdul");
    Ability ability = character.currentAbility();
    assertTrue(twoHandedSword.getAttack() >= 4);
    assertTrue(twoHandedSword.getAttack() <= 6);
    assertTrue(flail.getAttack() >= 4);
    assertTrue(flail.getAttack() <= 6);
  }

  @Test
  public void testGetWeaponName() {
    assertEquals(katana.getName(), "Katana");
    assertEquals(broadsword.getName(), "Broadsword");
    assertEquals(twoHandedSword.getName(), "Two-handed sword");
    assertEquals(axes.getName(), "Axe");
    assertEquals(flail.getName(), "Flail");
  }

  @Test
  public void testGetWeaponAdjective() {
    assertEquals(katana.getAdjective(), "Ice");
    assertEquals(broadsword.getAdjective(), "Water");
    assertEquals(twoHandedSword.getAdjective(), "Poison");
    assertEquals(axes.getAdjective(), "Flame");
    assertEquals(flail.getAdjective(), "Sleep");
  }
}
