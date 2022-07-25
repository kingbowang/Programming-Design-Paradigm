package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing CaveImpl class.
 *
 * @author Pengbo Wang
 */
public class CaveTest {

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidId() {
    CaveImpl cave1 = new CaveImpl(1, 1, -4);
    CaveImpl cave2 = new CaveImpl(1, 1, -2);
  }

  @Test
  public void testSetGetTreasure() {
    CaveImpl cave = new CaveImpl(1, 1, 1);
    Position position = new Position(1, 1);
    List<Treasure> treasureList = new ArrayList<>();
    Treasure treasure = new Diamonds(position, 1, 2);
    treasureList.add(treasure);
    cave.setTreasure(treasure);
    assertEquals(cave.getTreasures(), treasureList);
  }

  @Test
  public void testGetId() {
    CaveImpl cave = new CaveImpl(1, 1, 12);
    assertEquals(cave.getId(), 12);
  }

  @Test
  public void testGetPosition() {
    Position position = new Position(10, 20);
    CaveImpl cave = new CaveImpl(10, 20, 14);
    assertEquals(cave.getPosition().col, position.col);
    assertEquals(cave.getPosition().row, position.row);
  }

}