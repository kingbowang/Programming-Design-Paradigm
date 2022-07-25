package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Implement a DungeonImpl class which implements the Dungeon interface.
 *
 * @author Pengbo Wang
 */
public class DungeonImpl implements Dungeon {
  private final Position position;
  private final Boolean wrapping;
  private final CaveImpl begin;
  private final CaveImpl end;
  private final PlayerImpl player;
  private final List<List<CaveImpl>> caveList;
  private final int[][] edge;

  /**
   * The constructor of the DungeonImpl class.
   *
   * @param row               rows in the dungeon
   * @param col               columns in the dungeon
   * @param wrapping          wrapping dungeon or non-wrapping dungeon
   * @param interconnectivity interconnectivity
   * @param treasureRandom    random treasure
   * @throws IllegalArgumentException if interconnectivity is negative
   * @throws IllegalArgumentException if a random treasure is less than 20%
   */
  public DungeonImpl(int row, int col, boolean wrapping, int interconnectivity,
                     double treasureRandom) throws IllegalArgumentException {
    if (interconnectivity < 0) {
      throw new IllegalArgumentException("Negative interconnectivity is not supported.");
    }
    if (treasureRandom < 0.2) {
      throw new IllegalArgumentException("Should add a random treasure to at "
              + "least 20% of the caves in the dungeon.");
    }
    this.position = new Position(row, col);
    this.wrapping = wrapping;
    this.caveList = new ArrayList<>();
    int id = 1;
    for (int i = 1; i <= this.position.row; ++i) {
      List<CaveImpl> singleLine = new ArrayList<>();
      for (int j = 1; j <= this.position.col; ++j) {
        singleLine.add(new CaveImpl(i, j, id++));
      }
      this.caveList.add(singleLine);
    }
    // number of treasures
    int treasureCnt = (int) (treasureRandom
            * this.position.col * this.position.row);
    int cnt = 0;
    int treasureId = 1;
    while (cnt < treasureCnt) {
      // select treasure 0-2
      Random r = new Random();
      Treasure treasure;
      int treasureType = r.nextInt(3);
      int treasureRow = r.nextInt(this.position.row);
      int treasureCol = r.nextInt(this.position.col);
      switch (treasureType) {
        case 0:
          treasure = new Sapphires(new Position(treasureRow, treasureCol), 1, treasureId++);
          break;
        case 1:
          treasure = new Diamonds(new Position(treasureRow, treasureCol), 2, treasureId++);
          break;
        case 2:
          treasure = new Rubies(new Position(treasureRow, treasureCol), 3, treasureId++);
          break;
        default:
          throw new RuntimeException("The type was not found.");
      }
      if (this.caveList.get(treasureRow).get(treasureCol).getTreasures().isEmpty()) {
        ++cnt;
      }
      this.caveList.get(treasureRow).get(treasureCol).setTreasure(treasure);
    }
    // randomly select the start position and end position
    while (true) {
      Random r = new Random();
      int beginCave = r.nextInt(this.position.col * this.position.row);
      int endCave = r.nextInt(this.position.col * this.position.row);
      CaveImpl begin = this.getCaveById(beginCave);
      CaveImpl end = this.getCaveById(endCave);
      if (begin.getPosition().getDistance(end.getPosition()) >= 5) {
        this.begin = begin;
        this.end = end;
        break;
      }
    }
    this.player = new PlayerImpl(this.begin.getPosition(), this.begin);
    // construct an edge
    int[][] allEdge = new int[this.position.row * this.position.col + 1][
            this.position.row * this.position.col + 1];
    for (List<CaveImpl> caves : this.caveList) {
      for (CaveImpl cave : caves) {
        if (cave.getId() % this.position.col == 1) {
          allEdge[cave.getId()][cave.getId() + 1] = 1;
        } else if (cave.getId() % this.position.col == 0) {
          allEdge[cave.getId()][cave.getId() - 1] = 1;
        } else {
          allEdge[cave.getId()][cave.getId() + 1] = 1;
          allEdge[cave.getId()][cave.getId() - 1] = 1;
        }
        if (cave.getId() <= this.position.col) {
          allEdge[cave.getId()][cave.getId() + this.position.col] = 1;
        } else if (cave.getId() > this.position.col * (this.position.row - 1)) {
          allEdge[cave.getId()][cave.getId() - this.position.col] = 1;
        } else {
          allEdge[cave.getId()][cave.getId() + this.position.col] = 1;
          allEdge[cave.getId()][cave.getId() - this.position.col] = 1;
        }
      }
    }
    int[][] finalEdge = this.kruskal(allEdge);
    int connectivity = 0;
    while (connectivity < interconnectivity) {
      Random r = new Random();
      int pos = r.nextInt(this.position.row * this.position.col + 1);
      if (pos != 0) {
        for (int i = 1; i <= this.position.row * this.position.col; ++i) {
          if (allEdge[pos][i] == 1 && allEdge[i][pos] == 1 && finalEdge[i][pos] == 0
                  && finalEdge[pos][i] == 0) {
            // additional edges
            ++connectivity;
            finalEdge[pos][i] = 1;
            finalEdge[i][pos] = 1;
            break;
          }
        }
      }
    }
    // dungeon construction completed
    this.edge = finalEdge;
    List<Tunnel> tunnelList = new ArrayList<>();
    int tunnelCnt = 1;
    for (int i = 1; i <= this.position.row * this.position.col; ++i) {
      for (int j = i + 1; j <= this.position.row * this.position.col; ++j) {
        if (finalEdge[i][j] == 1) {
          tunnelList.add(new Tunnel(this.getCaveById(i), this.getCaveById(j), tunnelCnt++));
        }
      }
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

  private CaveImpl getCaveById(int id) {
    for (List<CaveImpl> caves : this.caveList) {
      for (CaveImpl cave : caves) {
        if (cave.getId() == id) {
          return cave;
        }
      }
    }
    return this.caveList.get(0).get(0);
  }

  private int[][] kruskal(int[][] edge) {
    int[][] nowEdge = new int[this.position.row * this.position.col + 1][
            this.position.row * this.position.col + 1];
    Set<Integer> visitNode = new HashSet<>();
    int cnt = 0;
    while (cnt < (this.position.col * this.position.row - 1)) {
      // pick an edge at will
      Random r = new Random();
      int node1 = r.nextInt(this.position.col * this.position.row + 1);
      if (node1 != 0) {
        for (int i = 1; i <= this.position.col * this.position.row; ++i) {
          if (edge[node1][i] == 1 && nowEdge[node1][i] == 0) {
            // add
            nowEdge[node1][i] = 1;
            nowEdge[i][node1] = 1;
            boolean hasCircle = this.judgeCircle(nowEdge);
            // circle, do not add
            if (hasCircle) {
              nowEdge[node1][i] = 0;
              nowEdge[i][node1] = 0;
              // not circle, add
            } else {
              visitNode.add(node1);
              visitNode.add(i);
              ++cnt;
              break;
            }
          }
        }
      }
    }
    return nowEdge;
  }

  // determine if there is a circle
  private boolean judgeCircle(final int[][] edge) {
    int[] node = new int[this.position.col * this.position.row + 1];
    int[][] nowEdge = new int[this.position.row * this.position.col + 1][
            this.position.row * this.position.col + 1];
    for (int i = 1; i <= this.position.col * this.position.row; ++i) {
      if (this.position.col * this.position.row >= 0) {
        System.arraycopy(edge[i], 1, nowEdge[i], 1, this.position.col * this.position.row);
      }
    }
    // statistics
    for (int i = 1; i <= this.position.col * this.position.row; ++i) {
      for (int j = 1; j <= this.position.col * this.position.row; ++j) {
        if (edge[i][j] == 1) {
          ++node[i];
        }
      }
    }
    Set<Integer> deleteNode = new HashSet<>();
    while (true) {
      boolean flag = true;
      for (int i = 1; i <= this.position.col * this.position.row; ++i) {
        if (node[i] <= 1 && !deleteNode.contains(i)) {
          flag = false;
          for (int j = 1; j <= this.position.col * this.position.row; ++j) {
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
    return deleteNode.size() != this.position.row * this.position.col;
  }

  @Override
  public int[] getAvailableMove(CaveImpl cave) {
    // {0, 0, 0, 0} = {North, South, West, East}
    int north = 0;
    int south = 0;
    int west = 0;
    int east = 0;
    if (cave.getId() % this.position.col == 1) {
      if (this.wrapping) {
        west = 1;
      }
      if (this.edge[cave.getId()][cave.getId() + 1] == 1) {
        east = 1;
      }
    } else if (cave.getId() % this.position.col == 0) {
      if (this.wrapping) {
        east = 1;
      }
      if (this.edge[cave.getId()][cave.getId() - 1] == 1) {
        west = 1;
      }
    } else {
      if (this.edge[cave.getId()][cave.getId() + 1] == 1) {
        east = 1;
      }
      if (this.edge[cave.getId()][cave.getId() - 1] == 1) {
        west = 1;
      }
    }
    if (cave.getId() <= this.position.col) {
      if (this.wrapping) {
        north = 1;
      }
      if (this.edge[cave.getId()][cave.getId() + this.position.col] == 1) {
        south = 1;
      }
    } else if (cave.getId() > this.position.col * (this.position.row - 1)) {
      if (this.wrapping) {
        south = 1;
      }
      if (this.edge[cave.getId()][cave.getId() - this.position.col] == 1) {
        north = 1;
      }
    } else {
      if (this.edge[cave.getId()][cave.getId() - this.position.col] == 1) {
        north = 1;
      }
      if (this.edge[cave.getId()][cave.getId() + this.position.col] == 1) {
        south = 1;
      }
    }
    int[] ans = new int[4];
    ans[0] = north;
    ans[1] = south;
    ans[2] = west;
    ans[3] = east;
    return ans;
  }

  @Override
  public int[][] getEdge() {
    return edge;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public void playerMove(int type) {
    // 0: North 1: South 2: West 3: East
    switch (type) {
      case 0:
        this.player.goNorth();
        break;
      case 1:
        this.player.goSouth();
        break;
      case 2:
        this.player.goWest();
        break;
      case 3:
        this.player.goEast();
        break;
      default:
        throw new RuntimeException("The type was not found.");
    }
    if (player.getPosition().row > this.position.row) {
      player.getPosition().row = player.getPosition().row % this.position.row;
    } else if (player.getPosition().row < 1) {
      player.getPosition().row += this.position.row;
    }
    if (player.getPosition().col > this.position.col) {
      player.getPosition().col = player.getPosition().col % this.position.col;
    } else if (player.getPosition().col < 1) {
      player.getPosition().col += this.position.col;
    }
    this.player.setCave(this.caveList.get(this.player.getPosition().row - 1)
            .get(this.player.getPosition().col - 1));
  }

  @Override
  public void playerTakeTreasure() {
    int row = this.player.getPosition().row;
    int col = this.player.getPosition().col;
    CaveImpl cave = this.caveList.get(row - 1).get(col - 1);
    for (Treasure t : cave.getTreasures()) {
      this.player.takeTreasure(t);
    }
  }

  @Override
  public String describe() {
    StringBuilder ans = new StringBuilder("You can move: ");
    CaveImpl cave = this.caveList.get(this.player.getPosition().row - 1)
            .get(this.player.getPosition().col - 1);
    int[] move = this.getAvailableMove(cave);
    if (move[0] == 1) {
      ans.append("north ");
    }
    if (move[1] == 1) {
      ans.append("south ");
    }
    if (move[2] == 1) {
      ans.append("west ");
    }
    if (move[3] == 1) {
      ans.append("east ");
    }
    ans.append("| You can take: ");
    for (Treasure t : cave.getTreasures()) {
      if (!t.isTaken()) {
        ans.append(t.getType()).append(" ");
      }
    }
    ans.append("| And now you have: ");
    for (Treasure t : this.player.getTreasures()) {
      ans.append(t.getType()).append(" ");
    }
    ans.append("| Now your position = (").append(this.player.getPosition().row).append(", ")
            .append(this.player.getPosition().col).append(").");
    return ans.toString();
  }

}
