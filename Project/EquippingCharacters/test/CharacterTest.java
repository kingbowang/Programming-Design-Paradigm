import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CharacterTest {
  private Character player;
  private Character equipPlayer;
  private List<Gear> gears;

  @Before
  public void setUp() {
    player = new Character("Abdul");
    equipPlayer = new Character("Vic");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    player = new Character(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyName() {
    player = new Character(" ");
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructor() {
    Character playerTwo = new Character("Sam");
    assertNotNull(playerTwo);
  }

  @Test
  public void getName() {
    assertEquals("abdul", player.getName());
  }

  /**
   * Test the modifiedAttack method and equip method.
   */
  @Test
  public void getModifiedAttack() {
    Gear foot = new FootGear("Boots", "electricity",
        new Ability(0, 0, 10, 0));
    player.equip(foot);

    Gear attackHand = new HeadGear("Helm", "Flight",
        new Ability(0, 10, 0, 0));
    player.equip(attackHand);
  }
}