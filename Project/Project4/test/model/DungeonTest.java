package model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Testing DungeonImpl class.
 *
 * @author Pengbo Wang
 */
public class DungeonTest {

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInterconnectivity() {
    DungeonImpl dungeon = new DungeonImpl(4, 6, true,
            -8, 0.2,1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTreasureRandom() {
    DungeonImpl dungeon = new DungeonImpl(4, 6, true,
            4, 0.19,1);
  }


  @Test
  public void testIsGameOver() {
    DungeonImpl dungeon = new DungeonImpl();
    assertFalse(dungeon.isGameOver());
  }

  @Test
  public void testIsWin() {
    DungeonImpl dungeon = new DungeonImpl();
    assertFalse(dungeon.isWin());
  }

}