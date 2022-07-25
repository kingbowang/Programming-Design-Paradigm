package model;

import utils.Position;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Testing ArrowImpl class.
 *
 * @author Pengbo Wang
 */
public class ArrowTest {

  @Test
  public void testTake() {
    ArrowImpl arrow = new ArrowImpl(new Position(0, 0));
    assertFalse(arrow.isTaken());
    arrow.take();
    assertTrue(arrow.isTaken());
  }

}