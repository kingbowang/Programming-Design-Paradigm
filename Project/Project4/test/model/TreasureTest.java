package model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Testing Treasure class.
 *
 * @author Pengbo Wang
 */
public class TreasureTest {

  @Test
  public void testGetType() {
    Treasure rubies = new Rubies(null);
    Treasure diamonds = new Diamonds(null);
    Treasure sapphires = new Sapphires(null);
    assertEquals(rubies.getType(), "Ruby");
    assertEquals(diamonds.getType(), "Diamond");
    assertEquals(sapphires.getType(), "Sapphire");
  }

  @Test
  public void testTakeTreasure() {
    Treasure rubies = new Rubies(null);
    Treasure diamonds = new Diamonds(null);
    Treasure sapphires = new Sapphires(null);
    assertFalse(rubies.isTaken());
    assertFalse(diamonds.isTaken());
    assertFalse(sapphires.isTaken());
    rubies.takeTreasure();
    diamonds.takeTreasure();
    sapphires.takeTreasure();
    assertTrue(rubies.isTaken());
    assertTrue(diamonds.isTaken());
    assertTrue(sapphires.isTaken());
  }

  @Test
  public void testTakeSameTreasure() {
    Treasure rubies1 = new Rubies(null);
    Treasure rubies2 = new Rubies(null);
    Treasure rubies3 = new Rubies(null);
    assertFalse(rubies1.isTaken());
    assertFalse(rubies2.isTaken());
    assertFalse(rubies3.isTaken());
    rubies1.takeTreasure();
    rubies2.takeTreasure();
    rubies3.takeTreasure();
    assertTrue(rubies1.isTaken());
    assertTrue(rubies2.isTaken());
    assertTrue(rubies3.isTaken());
  }

}