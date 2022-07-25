package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import model.ArrowImpl;
import model.DungeonImpl;
import model.Treasure;
import utils.Direction;
import utils.Position;

/**
 * Implement a DungeonControllerImpl class which implements DungeonController interface.
 *
 * @author Pengbo Wang
 */
public class DungeonControllerImpl implements DungeonController {
  private DungeonImpl dungeon;
  private static volatile DungeonControllerImpl instance;
  public static int TERRIBLESMELL = 2;
  public static int SLIGHTSMELL = 1;
  public static int NOSMELL = 0;

  /**
   * The constructor of DungeonControllerImpl class.
   */
  public DungeonControllerImpl() {
    this.dungeon = null;
  }

  /**
   * The constructor of DungeonControllerImpl getInstance.
   *
   * @return instance
   */
  public static DungeonControllerImpl getInstance() {
    if (instance == null) {
      synchronized (DungeonControllerImpl.class) {
        instance = new DungeonControllerImpl();
      }
    }
    return instance;
  }

  @Override
  public void parseCommonLine(String[] userInput) {
    if (userInput.length == 0) {
      this.dungeon = new DungeonImpl();
      return;
    }
    int row = Integer.parseInt(userInput[0]);
    int col = Integer.parseInt(userInput[1]);
    boolean wrapping = Boolean.parseBoolean(userInput[2]);
    int interconnectivity = Integer.parseInt(userInput[3]);
    double treasureRandom = Double.parseDouble(userInput[4]);
    int otyughsNum = Integer.parseInt(userInput[5]);
    this.dungeon = new DungeonImpl(row, col, wrapping,
            interconnectivity, treasureRandom, otyughsNum);
  }

  @Override
  public void playerMove(Direction direction) {
    this.dungeon.playerMove(direction);
  }

  @Override
  public boolean playerShoot(int caveDistance, Direction direction) {
    return this.dungeon.shoot(caveDistance, direction);
  }

  @Override
  public boolean playerPickUp(String treasureType) {
    if (treasureType.equals("Arrow")) {
      return this.dungeon.playerTakeArrow();
    }
    return this.dungeon.playerTakeTreasure(treasureType);
  }

  @Override
  public Map<String, Integer> getPickUp() {
    List<Treasure> treasures = this.dungeon.getTreasure();
    Map<String, Integer> ans = new HashMap<>();
    for (Treasure treasure : treasures) {
      if (ans.containsKey(treasure.getType())) {
        ans.put(treasure.getType(), ans.get(treasure.getType()) + 1);
      } else {
        ans.put(treasure.getType(), 1);
      }
    }
    List<ArrowImpl> arrows = this.dungeon.getArrow();
    if (arrows.size() != 0) {
      ans.put("Arrow", arrows.size());
    }
    return ans;
  }

  @Override
  public boolean gameOver() {
    return this.dungeon.isGameOver();
  }

  @Override
  public boolean isWin() {
    return this.dungeon.isWin();
  }

  @Override
  public Set<Direction> getAvailableDirection() {
    return this.dungeon.getAvailableMove();
  }

  @Override
  public int getOtyughs() {
    int otyughsCnt = 0;
    otyughsCnt += this.dungeon.otyughsDistance(1);
    if (otyughsCnt > 0) {
      return TERRIBLESMELL;
    }
    otyughsCnt += this.dungeon.otyughsDistance(2);
    if (otyughsCnt >= 2) {
      return TERRIBLESMELL;
    }
    if (otyughsCnt == 1) {
      return SLIGHTSMELL;
    }
    return NOSMELL;
  }

  @Override
  public boolean inCave() {
    return true;
  }

  @Override
  public int getArrowsCnt() {
    return this.dungeon.getPlayer().getArrowCnt();
  }

  @Override
  public Position getBegin() {
    return this.dungeon.getBegin().getPosition();
  }

  @Override
  public Position getEnd() {
    return this.dungeon.getEnd().getPosition();
  }

  @Override
  public Map<String, Object> getPlayerInformation() {
    Map<String, Object> info = new HashMap<>();
    Position position = this.dungeon.getPlayer().getPosition();
    info.put("position", "(" + position.row + "," + position.col + ")");
    Map<String, Integer> treasureInfo = new HashMap<>();
    List<Treasure> treasures = this.dungeon.getPlayer().getTreasures();
    for (Treasure treasure : treasures) {
      if (treasureInfo.containsKey(treasure.getType())) {
        treasureInfo.put(treasure.getType(), treasureInfo.get(treasure.getType()) + 1);
      } else {
        treasureInfo.put(treasure.getType(), 1);
      }
    }
    int arrows = this.dungeon.getPlayer().getArrowCnt();
    treasureInfo.put("Arrow", arrows);
    info.put("treasure", treasureInfo);
    return info;
  }

  @Override
  public void startGame(Scanner in, Appendable out, String []args) throws IOException {
    DungeonControllerImpl.getInstance().parseCommonLine(args);
    System.out.append("The initial position: (").append(String
            .valueOf(DungeonControllerImpl.getInstance().getBegin()
                    .row)).append(",").append(String.valueOf(DungeonControllerImpl
            .getInstance().getBegin().col)).append(")\n");
    System.out.append("End position: (").append(String.valueOf(DungeonControllerImpl
            .getInstance().getEnd().row)).append(",").append(String.valueOf(DungeonControllerImpl
            .getInstance().getEnd().col)).append(")\n");
    out.append("\n");
    boolean gameOver = false;
    while (!gameOver) {
      // get surrounding environment information and output
      if (DungeonControllerImpl.getInstance().inCave()) {
        out.append("You are in a cave\n");
      }
      Map<String, Object> playerInfo = DungeonControllerImpl.getInstance().getPlayerInformation();
      out.append("Now you position: ").append(String
              .valueOf(playerInfo.get("position"))).append("\n");
      Map<String, Integer> treasureInfo = (Map<String, Integer>) playerInfo.get("treasure");
      if (treasureInfo.size() != 0) {
        out.append("Now you have: ");
        for (String s : treasureInfo.keySet()) {
          out.append(s).append(":").append(String.valueOf(treasureInfo.get(s))).append(" ");
        }
      }
      out.append("\n");
      // available moving directions
      out.append("Doors lead to the: ");
      Set<Direction> availableDirection = DungeonControllerImpl
              .getInstance().getAvailableDirection();
      for (Direction direction : availableDirection) {
        out.append(direction.getName()).append(" ");
      }
      out.append("\n");
      // treasures which can pick up
      Map<String, Integer> treasures = DungeonControllerImpl.getInstance().getPickUp();
      if (treasures.size() != 0) {
        out.append("You find: ");
        for (String key : treasures.keySet()) {
          out.append(key).append(": ").append(String.valueOf(treasures.get(key))).append("\n");
        }
      }
      // whether there is Otyughs
      int smellLevel = DungeonControllerImpl.getInstance().getOtyughs();
      if (smellLevel == DungeonControllerImpl.SLIGHTSMELL) {
        out.append("You smell something slight nearby\n");
      } else if (smellLevel == DungeonControllerImpl.TERRIBLESMELL) {
        out.append("You smell something terrible nearby\n");
      }
      out.append("Move, Pickup, or Shoot (M-P-S)? ");
      String userMsg = in.nextLine();
      switch (userMsg) {
        case "M":
          out.append("Where to? ");
          String dir = in.nextLine();
          out.append("\n");
          Direction direction = null;
          try {
            direction = Direction.valueOf(dir);
          } catch (IllegalArgumentException e) {
            out.append("ERROR");
          }
          DungeonControllerImpl.getInstance().playerMove(direction);
          break;
        case "P":
          out.append("What? ");
          String treasure = in.nextLine();
          boolean pickUp = DungeonControllerImpl.getInstance().playerPickUp(treasure);
          if (pickUp) {
            out.append("You pick up a(n) ").append(treasure);
          } else {
            out.append("You pick up nothing!");
          }
          out.append("\n");
          out.append("\n");
          break;
        case "S":
          out.append("No. of caves (1-5)? ");
          int caveCnt;
          caveCnt = Integer.parseInt(in.nextLine());
          out.append("Where to(N S E W)? ");
          String shootDir = in.nextLine();
          out.append("\n");
          Direction shootDirection = null;
          try {
            shootDirection = Direction.valueOf(shootDir);
          } catch (IllegalArgumentException e) {
            out.append("ERROR");
          }
          boolean shoot = DungeonControllerImpl.getInstance().playerShoot(caveCnt, shootDirection);
          if (shoot) {
            out.append("You hear a great howl in the distance\n");
          } else {
            out.append("You shoot an arrow into the darkness\n");
          }
          if (DungeonControllerImpl.getInstance().getArrowsCnt() == 0) {
            out.append("You are out of arrows, explore to find more\n");
          }
          out.append("\n");
          break;
        default:
          throw new RuntimeException("Input Error");
      }
      gameOver = DungeonControllerImpl.getInstance().gameOver();
    }
    if (DungeonControllerImpl.getInstance().isWin()) {
      // output if the player is winning the game
      out.append("Great! You made it through the map!\n");
    } else {
      // output if the player is losing the game
      out.append("Chomp, chomp, chomp, you are eaten by an Otyugh!\n");
      out.append("Better luck next time\n");
    }
  }

}
