package model;

import utils.Position;
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

  @Test
  public void testSetGetTreasure() {
    CaveImpl cave = new CaveImpl(1, 1);
    Position position = new Position(1, 1);
    List<Treasure> treasureList = new ArrayList<>();
    Treasure treasure = new Diamonds(position);
    treasureList.add(treasure);
    cave.setTreasure(treasure);
    assertEquals(cave.getTreasures(), treasureList);
  }

  @Test
  public void testGetPosition() {
    int x = 10;
    int y = 20;
    Position position = new Position(x, y);
    CaveImpl cave = new CaveImpl(x, y);
    assertEquals(cave.getPosition().col, position.col);
    assertEquals(cave.getPosition().row, position.row);
  }

  @Test
  public void testGetArrows() {
    CaveImpl cave = new CaveImpl(1, 1);
    Position position = new Position(1, 1);
    for (int i = 0; i < 1000; ++i) {
      ArrowImpl arrow = new ArrowImpl(position);
      cave.setArrows(arrow);
      assertEquals(cave.getArrows().size(), i + 1);
    }
  }

  @Test
  public void testGetOtyughs() {
    CaveImpl cave = new CaveImpl(1, 1);
    Position position = new Position(1, 1);
    for (int i = 0; i < 1000; ++i) {
      OtyughsImpl otyughs = new OtyughsImpl(position);
      cave.addOtyughs(otyughs);
      assertEquals(cave.getOtyughs().size(), i + 1);
    }
  }

}