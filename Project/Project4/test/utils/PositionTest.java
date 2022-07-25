package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing Position class.
 *
 * @author Pengbo Wang
 */
public class PositionTest {

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRow() {
    Position pos1 = new Position(-7, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCol() {
    Position pos1 = new Position(1, -4);
  }

  @Test
  public void testGetDistance() {
    Position pos1 = new Position(1, 1);
    Position pos2 = new Position(2, 2);
    assertEquals(pos1.getDistance(pos2), 2);
  }

  @Test
  public void testEquals() {
    Position pos1 = new Position(1, 1);
    Position pos2 = new Position(1, 1);
    assertEquals(pos1, pos2);
  }

}