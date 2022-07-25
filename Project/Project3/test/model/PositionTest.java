package model;

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
    Position pos1 = new Position(1, 2);
    Position pos2 = new Position(5, 4);
    assertEquals(pos1.getDistance(pos2), 6);
  }

}