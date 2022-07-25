package transmission;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for AutomaticTransmission class.
 */
public class AutomaticTransmissionTest {

  private Transmission t1;

  @Test
  public void testInitialization() {
    t1 = new AutomaticTransmission(2, 4, 6, 8, 10);
    assertEquals("Transmission (speed = 0, gear = 0)", t1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed1() {
    t1 = new AutomaticTransmission(-2, 4, 6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed2() {
    t1 = new AutomaticTransmission(2, -4, 6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed3() {
    t1 = new AutomaticTransmission(2, 4, -6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed4() {
    t1 = new AutomaticTransmission(2, 4, 6, -8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed5() {
    t1 = new AutomaticTransmission(2, 4, 6, 8, -10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed1() {
    t1 = new AutomaticTransmission(5, 4, 6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed2() {
    t1 = new AutomaticTransmission(2, 7, 6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed3() {
    t1 = new AutomaticTransmission(2, 3, 9, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed4() {
    t1 = new AutomaticTransmission(2, 9, 6, 11, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed5() {
    t1 = new AutomaticTransmission(2, 9, 6, 8, 1);
  }

  @Before
  public void setTransmissionObject() {
    t1 = new AutomaticTransmission(9, 14, 19, 21, 27);
  }

  @Test
  public void testIncreaseSpeed() {
    t1.increaseSpeed();
    t1.increaseSpeed();
    t1.increaseSpeed();
    assertEquals(3, t1.getSpeed());
  }

  @Test
  public void testDecreaseSpeed() {
    t1.increaseSpeed();
    t1.increaseSpeed();
    t1.increaseSpeed();
    t1.decreaseSpeed();
    assertEquals(2, t1.getSpeed());
  }

  @Test
  public void testToString() {
    assertEquals("Transmission (speed = 0, gear = 0)", t1.toString());
  }

}