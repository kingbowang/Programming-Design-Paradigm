package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import utils.Direction;
import utils.Position;

/**
 * Implement a DungeonImpl class which implements the Dungeon interface.
 *
 * @author Pengbo Wang
 */
public class DungeonImpl implements Dungeon {
  private final int rowCnt;
  private final int colCnt;
  private final Boolean wrapping;

  private final CaveImpl begin;
  private final CaveImpl end;
  private final PlayerImpl player;
  private boolean gameOver;
  private boolean win;

  private final CaveImpl[][] caves;
  private final int[][] edge;
  private Set<Direction> availableDirection;
  public static final int SEED = 100;

  /**
   * The constructor of the DungeonImpl class.
   * Default init.
   */
  public DungeonImpl() {
    this(4, 4, true, 3, 0.2, 1);
  }


  /**
   * The constructor of the DungeonImpl class.
   *
   * @param row               rows in the dungeon
   * @param col               columns in the dungeon
   * @param wrapping          wrapping dungeon or non-wrapping dungeon
   * @param interconnectivity interconnectivity
   * @param treasureRandom    random treasure
   * @param otyughsNum        the number of Otyughs
   * @throws IllegalArgumentException if interconnectivity is negative
   * @throws IllegalArgumentException if a random treasure is less than 20%
   */
  public DungeonImpl(int row, int col, boolean wrapping, int interconnectivity,
                     double treasureRandom, int otyughsNum) throws IllegalArgumentException {
    if (interconnectivity < 0) {
      throw new IllegalArgumentException("Negative interconnectivity is not supported.");
    }
    if (treasureRandom < 0.2) {
      throw new IllegalArgumentException("Should add a random treasure to at "
              + "least 20% of the caves in the dungeon.");
    }
    this.rowCnt = row;
    this.colCnt = col;
    this.wrapping = wrapping;
    this.caves = new CaveImpl[row][col];
    this.availableDirection = null;
    for (int i = 0; i < this.rowCnt; ++i) {
      for (int j = 0; j < this.colCnt; ++j) {
        this.caves[i][j] = new CaveImpl(i, j);
      }
    }
    // number of treasures
    int treasureCnt = (int) (treasureRandom * this.colCnt * this.rowCnt);
    int cnt = 0;
    // set treasures and arrows
    Random r = new Random(SEED);
    while (cnt < treasureCnt) {
      // select treasure 0-2
      BaseClass treasure;
      int treasureType = r.nextInt(4);
      int treasureRow = r.nextInt(this.rowCnt);
      int treasureCol = r.nextInt(this.colCnt);
      switch (treasureType) {
        case 0:
          treasure = new Sapphires(new Position(treasureRow, treasureCol));
          break;
        case 1:
          treasure = new Diamonds(new Position(treasureRow, treasureCol));
          break;
        case 2:
          treasure = new Rubies(new Position(treasureRow, treasureCol));
          break;
        case 3:
          treasure = new ArrowImpl(new Position(treasureRow, treasureCol));
          break;
        default:
          throw new RuntimeException("Type not found");
      }
      if (treasureType == 3) {
        if (this.caves[treasureRow][treasureCol].getArrows().isEmpty()) {
          ++cnt;
        }
        this.caves[treasureRow][treasureCol].setArrows((ArrowImpl) treasure);
        continue;
      }
      if (this.caves[treasureRow][treasureCol].getTreasures().isEmpty()) {
        ++cnt;
      }
      this.caves[treasureRow][treasureCol].setTreasure((Treasure) treasure);
    }
    // randomly select the start position and end position
    while (true) {
      int beginCave = r.nextInt(this.colCnt * this.rowCnt);
      int endCave = r.nextInt(this.colCnt * this.rowCnt);
      CaveImpl begin = this.caves[beginCave / this.colCnt][beginCave % this.colCnt];
      CaveImpl end = this.caves[endCave / this.colCnt][endCave % this.colCnt];
      if (begin.getPosition().getDistance(end.getPosition()) >= 5) {
        this.begin = begin;
        this.end = end;
        break;
      }
    }
    this.player = new PlayerImpl(this.begin.getPosition(), this.begin);
    // construct an edge
    int[][] allEdge = new int[this.rowCnt * this.colCnt][this.rowCnt * this.colCnt];
    for (int i = 0; i < this.rowCnt; ++i) {
      for (int j = 0; j < this.colCnt; ++j) {
        if (j == 0) {
          allEdge[i * this.colCnt + j][i * this.colCnt + j + 1] = 1;
        } else if (j == this.colCnt - 1) {
          allEdge[i * this.colCnt + j][i * this.colCnt + j - 1] = 1;
        } else {
          allEdge[i * this.colCnt + j][i * this.colCnt + j + 1] = 1;
          allEdge[i * this.colCnt + j][i * this.colCnt + j - 1] = 1;
        }
        if (i == 0) {
          allEdge[j][j + this.colCnt] = 1;
        } else if (i == this.rowCnt - 1) {
          allEdge[i * this.colCnt + j][i * this.colCnt + j - this.colCnt] = 1;
        } else {
          allEdge[i * this.colCnt + j][i * this.colCnt + j + this.colCnt] = 1;
          allEdge[i * this.colCnt + j][i * this.colCnt + j - this.colCnt] = 1;
        }
      }
    }
    int[][] finalEdge = this.kruskal(allEdge);
    int connectivity = 0;
    while (connectivity < interconnectivity) {
      int begin = r.nextInt(this.rowCnt * this.colCnt);
      int type = r.nextInt(4);
      int end;
      switch (type) {
        case 0:
          end = begin + 1;
          break;
        case 1:
          end = begin - 1;
          break;
        case 2:
          end = begin + this.colCnt;
          break;
        case 3:
          end = begin - this.colCnt;
          break;
        default:
          throw new IllegalStateException("Unexpected value: " + type);
      }
      if (end >= this.rowCnt * this.colCnt || end < 0) {
        continue;
      }
      if (allEdge[begin][end] == 1 && allEdge[end][begin] == 1
              && finalEdge[begin][end] == 0 && finalEdge[end][begin] == 0) {
        // additional edges
        ++connectivity;
        finalEdge[begin][end] = 1;
        finalEdge[begin][end] = 1;
        break;
      }
    }
    // dungeon construction completed
    this.edge = finalEdge;
    // set Otyughs
    int i = 0;
    while (i < otyughsNum) {
      int randomRow = r.nextInt(this.rowCnt);
      int randomCol = r.nextInt(this.colCnt);
      Cave cave = this.caves[randomRow][randomCol];
      if (begin.getPosition().equals(new Position(randomRow, randomCol))) {
        continue;
      }
      cave.addOtyughs(new OtyughsImpl(new Position(randomRow, randomCol)));
      ++i;
    }
  }

  @Override
  public CaveImpl getBegin() {
    return begin;
  }

  @Override
  public CaveImpl getEnd() {
    return end;
  }

  @Override
  public PlayerImpl getPlayer() {
    return player;
  }

  // Kruskal algorithm
  private int[][] kruskal(int[][] edge) {
    int[][] nowEdge = new int[this.rowCnt * this.colCnt][this.rowCnt * this.colCnt];
    Set<Integer> visitNode = new HashSet<>();
    int cnt = 0;
    Random r = new Random(SEED);
    while (cnt < (this.colCnt * this.rowCnt - 1)) {
      // pick an edge at will
      int begin = r.nextInt(this.rowCnt * this.colCnt);
      int type = r.nextInt(4);
      int end;
      switch (type) {
        case 0:
          end = begin + 1;
          break;
        case 1:
          end = begin - 1;
          break;
        case 2:
          end = begin + this.colCnt;
          break;
        case 3:
          end = begin - this.colCnt;
          break;
        default:
          throw new IllegalStateException("Unexpected value: " + type);
      }
      if (end >= this.rowCnt * this.colCnt || end < 0) {
        continue;
      }
      if (edge[begin][end] == 1 && nowEdge[begin][end] == 0) {
        // add
        nowEdge[begin][end] = 1;
        nowEdge[end][begin] = 1;
        boolean hasCircle = this.judgeCircle(nowEdge);
        // circle, do not add
        if (hasCircle) {
          nowEdge[begin][end] = 0;
          nowEdge[end][begin] = 0;
          // not circle, add
        } else {
          visitNode.add(begin);
          visitNode.add(end);
          ++cnt;
        }
      }
    }
    return nowEdge;
  }

  // determine if there is a circle
  private boolean judgeCircle(final int[][] edge) {
    int[] node = new int[this.colCnt * this.rowCnt];
    int[][] nowEdge = new int[this.colCnt * this.rowCnt][this.colCnt * this.rowCnt + 1];
    for (int i = 0; i < colCnt * this.rowCnt; ++i) {
      if (this.rowCnt * this.colCnt >= 0) {
        System.arraycopy(edge[i], 0, nowEdge[i], 0, this.rowCnt * this.colCnt);
      }
    }
    // statistics
    for (int i = 0; i < this.rowCnt * this.colCnt; ++i) {
      for (int j = 0; j < this.rowCnt * this.colCnt; ++j) {
        if (edge[i][j] == 1) {
          ++node[i];
        }
      }
    }
    Set<Integer> deleteNode = new HashSet<>();
    while (true) {
      boolean flag = true;
      for (int i = 0; i < this.rowCnt * this.colCnt; ++i) {
        if (node[i] <= 1 && !deleteNode.contains(i)) {
          flag = false;
          for (int j = 0; j < this.rowCnt * this.colCnt; ++j) {
            if (nowEdge[i][j] == 1) {
              // delete edge
              nowEdge[i][j] = 0;
              nowEdge[j][i] = 0;
              // delete other vertex degrees
              --node[j];
            }
          }
          // delete an edge
          deleteNode.add(i);
          break;
        }
      }
      // The traversal is completed and there is no node with a
      // degree less than or equal to 1.
      if (flag) {
        break;
      }
    }
    return deleteNode.size() != this.rowCnt * this.colCnt;
  }

  @Override
  public Set<Direction> getAvailableMove() {
    Position position = this.player.getPosition();
    Set<Direction> availableDirection = new HashSet<>();
    if (position.col == 0) {
      if (this.wrapping) {
        availableDirection.add(Direction.W);
      }
      if (this.edge[position.row * this.colCnt + position.col]
              [position.row * this.colCnt + position.col + 1] == 1) {
        availableDirection.add(Direction.E);
      }
    } else if (position.col == this.colCnt - 1) {
      if (this.wrapping) {
        availableDirection.add(Direction.E);
      }
      if (this.edge[position.row * this.colCnt + position.col]
              [position.row * this.colCnt + position.col - 1] == 1) {
        availableDirection.add(Direction.W);
      }
    } else {
      if (this.edge[position.row * this.colCnt + position.col]
              [position.row * this.colCnt + position.col + 1] == 1) {
        availableDirection.add(Direction.E);
      }
      if (this.edge[position.row * this.colCnt + position.col]
              [position.row * this.colCnt + position.col - 1] == 1) {
        availableDirection.add(Direction.W);
      }
    }
    if (position.row == 0) {
      if (this.wrapping) {
        availableDirection.add(Direction.N);
      }
      if (this.edge[position.col]
              [position.col + this.colCnt] == 1) {
        availableDirection.add(Direction.S);
      }
    } else if (position.row == this.rowCnt - 1) {
      if (this.wrapping) {
        availableDirection.add(Direction.S);
      }
      if (this.edge[position.row * this.colCnt + position.col]
              [position.row * this.colCnt + position.col - this.colCnt] == 1) {
        availableDirection.add(Direction.N);
      }
    } else {
      if (this.edge[position.row * this.colCnt + position.col]
              [position.row * this.colCnt + position.col - this.colCnt] == 1) {
        availableDirection.add(Direction.N);
      }
      if (this.edge[position.row * this.colCnt + position.col]
              [position.row * this.colCnt + position.col + this.colCnt] == 1) {
        availableDirection.add(Direction.S);
      }
    }
    this.availableDirection = availableDirection;
    return availableDirection;
  }

  @Override
  public void playerMove(Direction direction) {
    if (!availableDirection.contains(direction)) {
      throw new RuntimeException("Can not Move!");
    }
    // check if it can be moved
    switch (direction) {
      case N:
        this.player.goNorth();
        break;
      case S:
        this.player.goSouth();
        break;
      case W:
        this.player.goWest();
        break;
      case E:
        this.player.goEast();
        break;
      default:
        throw new RuntimeException("Type not found");
    }
    if (player.getPosition().row >= this.rowCnt || player.getPosition().row < 0) {
      player.getPosition().row = (player.getPosition().row + this.rowCnt) % this.rowCnt;
    }
    if (player.getPosition().col >= this.colCnt || player.getPosition().col < 0) {
      player.getPosition().col = (player.getPosition().col + this.colCnt) % this.colCnt;
    }
    CaveImpl cave = this.caves[this.player.getPosition().row][this.player.getPosition().col];
    this.player.setCave(cave);
    if (cave.getPosition().equals(this.end.getPosition())) {
      // get the end position
      this.gameOver = true;
      this.win = true;
    }
    for (Otyughs otyughs : cave.getOtyughs()) {
      if (otyughs.attack()) {
        this.gameOver = true;
        this.win = false;
      }
    }
  }

  @Override
  public boolean playerTakeTreasure(String treasure) {
    Cave cave = this.player.getCave();
    for (Treasure t : cave.getTreasures()) {
      if (t.getType().equals(treasure)) {
        this.player.takeTreasure(t);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean playerTakeArrow() {
    CaveImpl cave = this.player.getCave();
    for (ArrowImpl arrow : cave.getArrows()) {
      this.player.takeArrow(arrow);
      return true;
    }
    return false;
  }

  @Override
  public List<Treasure> getTreasure() {
    List<Treasure> treasures = new ArrayList<>();
    Cave cave = this.caves[this.player.getPosition().row][this.player.getPosition().col];
    for (Treasure t : cave.getTreasures()) {
      if (!t.isTaken()) {
        treasures.add(t);
      }
    }
    return treasures;
  }

  @Override
  public List<ArrowImpl> getArrow() {
    CaveImpl cave = this.player.getCave();
    List<ArrowImpl> arrows = new ArrayList<>();
    for (ArrowImpl arrow : cave.getArrows()) {
      if (!arrow.isTaken()) {
        arrows.add(arrow);
      }
    }
    return arrows;
  }

  @Override
  public boolean isGameOver() {
    return gameOver;
  }

  @Override
  public boolean isWin() {
    return win;
  }

  @Override
  public boolean shoot(int distance, Direction direction) {
    // check this distance, whether this position has a direction
    CaveImpl cave = this.player.getCave();
    this.player.shoot();
    for (int i = 0; i < distance; ++i) {
      cave = this.getNext(cave, direction);
      if (cave == null) {
        return false;
      }
    }
    // reach the cave
    if (cave.getOtyughs().size() == 0) {
      return false;
    }
    for (Otyughs otyughs : cave.getOtyughs()) {
      otyughs.underAttack();
    }
    return true;
  }

  private CaveImpl getNext(CaveImpl cave, Direction direction) {
    int row = cave.getPosition().row;
    int col = cave.getPosition().col;
    switch (direction) {
      case N:
        row -= 1;
        break;
      case S:
        row += 1;
        break;
      case W:
        col -= 1;
        break;
      case E:
        col += 1;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + direction);
    }
    if (row < 0 || row >= this.rowCnt || col < 0 || col >= this.colCnt) {
      if (this.wrapping) {
        row = (row + this.rowCnt) % this.rowCnt;
        col = (col + this.colCnt) % this.colCnt;
      } else {
        return null;
      }
    }
    if (this.edge[row * this.colCnt + col][cave.getPosition().row * this.colCnt
            + cave.getPosition().col] == 1) {
      return this.caves[row][col];
    }
    return null;
  }

  @Override
  public int otyughsDistance(int distance) {
    int cnt = 0;
    Direction[] directions = new Direction[]{Direction.N, Direction.W, Direction.E, Direction.S};
    for (int dir = 0; dir < 4; ++dir) {
      CaveImpl cave = player.getCave();
      for (int i = 0; i < distance; ++i) {
        cave = getNext(cave, directions[dir]);
        if (cave == null) {
          break;
        }
      }
      if (cave == null) {
        continue;
      }
      for (Otyughs otyughs : cave.getOtyughs()) {
        if (!otyughs.isDead()) {
          cnt += 1;
        }
      }
    }
    return cnt;
  }

}
