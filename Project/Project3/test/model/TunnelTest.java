package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing Tunnel class.
 *
 * @author Pengbo Wang
 */
public class TunnelTest {

  @Test
  public void testSetGetNode() {
    CaveImpl cave1 = new CaveImpl(10, 20, 1);
    CaveImpl cave2 = new CaveImpl(15, 25, 2);
    Tunnel tunnel = new Tunnel(cave1, cave2, 0);
    assertEquals(tunnel.getNode1(), cave1);
    assertEquals(tunnel.getNode2(), cave2);
  }

  @Test
  public void testSetGetId() {
    CaveImpl cave1 = new CaveImpl(10, 20, 1);
    CaveImpl cave2 = new CaveImpl(15, 25, 2);
    Tunnel tunnel = new Tunnel(cave1, cave2, 0);
    tunnel.setId(10);
    assertEquals(tunnel.getId(), 10);
  }

}