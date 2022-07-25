package model;

import utils.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing PlayerImpl class.
 *
 * @author Pengbo Wang
 */
public class PlayerTest {

  @Test
  public void testSetGetCave() {
    CaveImpl cave = new CaveImpl(10, 10);
    Position position = new Position(10, 10);
    PlayerImpl player = new PlayerImpl(position, null);
    player.setCave(cave);
    assertEquals(player.getCave(), cave);
  }

  @Test
  public void testGetPosition() {
    PlayerImpl player = new PlayerImpl(new Position(10, 20), null);
    assertEquals(player.getPosition().col, 20);
    assertEquals(player.getPosition().row, 10);
  }

  @Test
  public void testGoNorth() {
    PlayerImpl player = new PlayerImpl(new Position(10, 20), null);
    player.goNorth();
    assertEquals(player.getPosition().col, 20);
    assertEquals(player.getPosition().row, 9);
  }

  @Test
  public void testGoWest() {
    PlayerImpl player = new PlayerImpl(new Position(10, 20), null);
    player.goWest();
    assertEquals(player.getPosition().col, 19);
    assertEquals(player.getPosition().row, 10);
  }

  @Test
  public void testGoSouth() {
    PlayerImpl player = new PlayerImpl(new Position(10, 20), null);
    player.goSouth();
    assertEquals(player.getPosition().col, 20);
    assertEquals(player.getPosition().row, 11);
  }

  @Test
  public void testGoEast() {
    PlayerImpl player = new PlayerImpl(new Position(10, 20), null);
    player.goEast();
    assertEquals(player.getPosition().col, 21);
    assertEquals(player.getPosition().row, 10);
  }

  @Test
  public void testTakeTreasure() {
    CaveImpl cave = new CaveImpl(1, 1);
    Position position = new Position(1, 1);
    List<Treasure> treasureList = new ArrayList<>();
    Treasure treasure = new Diamonds(position);
    PlayerImpl player = new PlayerImpl(position, cave);
    treasureList.add(treasure);
    player.takeTreasure(treasure);
    assertEquals(player.getTreasures(), treasureList);
  }

  @Test
  public void testArrow() {
    PlayerImpl player = new PlayerImpl(new Position(10, 20), null);
    for (int i = 0; i < 1000; ++i) {
      player.takeArrow(new ArrowImpl(new Position(10, 20)));
      assertEquals(player.getArrowCnt(), 3 + i + 1);
    }
    for (int i = 0; i < 1000; ++i) {
      player.shoot();
      assertEquals(player.getArrowCnt(), 1003 - i - 1);
    }
  }

}