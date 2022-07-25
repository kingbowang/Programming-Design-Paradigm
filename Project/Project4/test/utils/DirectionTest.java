package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing Direction class.
 *
 * @author Pengbo Wang
 */
public class DirectionTest {

  @Test
  public void testGetDirectionName() {
    Direction directionN = Direction.N;
    assertEquals(directionN.getName(), "N");
    Direction directionW = Direction.W;
    assertEquals(directionW.getName(), "W");
    Direction directionE = Direction.E;
    assertEquals(directionE.getName(), "E");
    Direction directionS = Direction.S;
    assertEquals(directionS.getName(), "S");
  }

}