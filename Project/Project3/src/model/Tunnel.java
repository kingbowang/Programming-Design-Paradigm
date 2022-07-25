package model;

/**
 * Implement a Tunnel class.
 * This is a tunnel which has exactly 2 entrances.
 * Tunnel is a special cave.
 *
 * @author Pengbo Wang
 */
public class Tunnel {
  private CaveImpl node1;
  private CaveImpl node2;
  private int id;

  /**
   * The constructor of the Tunnel class.
   * Construct two nodes cause tunnel has exactly 2 entrances.
   *
   * @param node1 node one
   * @param node2 node two
   * @param id    ID of the tunnel
   */
  public Tunnel(CaveImpl node1, CaveImpl node2, int id) {
    this.node1 = node1;
    this.node2 = node2;
    this.id = id;
  }

  /**
   * Construct a method to get node1.
   *
   * @return node1
   */
  public CaveImpl getNode1() {
    return node1;
  }

  /**
   * Construct a method to set node1.
   *
   * @param node1 node1
   */
  public void setNode1(CaveImpl node1) {
    this.node1 = node1;
  }

  /**
   * Construct a method to get node2.
   *
   * @return node2
   */
  public CaveImpl getNode2() {
    return node2;
  }

  /**
   * Construct a method to set node2.
   *
   * @param node2 node2
   */
  public void setNode2(CaveImpl node2) {
    this.node2 = node2;
  }

  /**
   * Construct a method to get the id.
   *
   * @return id of the tunnel
   */
  public int getId() {
    return id;
  }

  /**
   * Construct a method to set the id.
   *
   * @param id id of the tunnel
   */
  public void setId(int id) {
    this.id = id;
  }

}
