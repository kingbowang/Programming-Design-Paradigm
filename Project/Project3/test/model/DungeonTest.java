package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing DungeonImpl class.
 *
 * @author Pengbo Wang
 */
public class DungeonTest {

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInterconnectivity() {
    DungeonImpl dungeon = new DungeonImpl(4, 6, true, -8, 0.2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTreasureRandom() {
    DungeonImpl dungeon = new DungeonImpl(4, 6, true, 4, 0.19);
  }

  @Test
  public void testGetPosition() {
    DungeonImpl dungeon = new DungeonImpl(4, 6, false, 8, 0.2);
    Position position = new Position(4, 6);
    assertEquals(dungeon.getPosition().col, position.col);
    assertEquals(dungeon.getPosition().row, position.row);
  }

}