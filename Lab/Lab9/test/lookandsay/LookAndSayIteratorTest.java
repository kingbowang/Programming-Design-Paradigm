package lookandsay;

import org.junit.Test;

import java.math.BigInteger;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for Look and Say Iterator.
 */
public class LookAndSayIteratorTest {

  /**
   * Test that verifies that the constructor with no argument works correctly.
   */
  @Test
  public void testNoArgumentConstructor() {
    LookAndSayIterator iterator = new LookAndSayIterator();
    assertEquals(new BigInteger("1"), iterator.next());
  }

  /**
   * Test that verifies that the constructor with TWO arguments
   * throws an IllegalArgumentException if given an invalid seed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTwoArgInvalidSeed() {
    BigInteger seed = new BigInteger("1403005");
    BigInteger endValue = new BigInteger("9999999999999999999");
    LookAndSayIterator iterator = new LookAndSayIterator(seed, endValue);
  }

  /**
   * Test that verifies that the constructor with TWO arguments throws
   * an IllegalArgumentException if the end is not larger than the seed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTwoArgEndNoLargerSeed() {
    BigInteger seed = new BigInteger("1236454");
    BigInteger endValue = new BigInteger("1236453");
    LookAndSayIterator iterator = new LookAndSayIterator(seed, endValue);
  }

  /**
   * Test that the constructor with ONE argument throws
   * an IllegalArgumentException if given an invalid seed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testOneArgInvalidSeed() {
    BigInteger seed = new BigInteger("-12324");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
  }

  /**
   * Test that verifies that next() returns the correct value in the sequence.
   */
  @Test
  public void testNextCorrectly() {
    BigInteger seed = new BigInteger("112321");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
    assertEquals(new BigInteger("112321"), iterator.next());
    assertEquals(new BigInteger("2112131211"), iterator.next());
    assertEquals(new BigInteger("1221121113111221"), iterator.next());
  }

  /**
   * Test that verifies that next() throws a NoSuchElementException when there is no next value.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNextNoValue() {
    BigInteger seed = new BigInteger("12451");
    BigInteger endValue = new BigInteger("99999999999999999");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed, endValue);
    assertEquals(new BigInteger("12451"), iterator.next());
    assertEquals(new BigInteger("1112141511"), iterator.next());
    assertEquals(new BigInteger("31121114111521"), iterator.next());
    assertFalse(iterator.hasNext());
    iterator.next();
  }

  /**
   * Test that verifies that prev() returns the correct value in the sequence.
   */
  @Test
  public void testPrevCorrectly() {
    BigInteger seed = new BigInteger("111211132211131114");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
    assertEquals(new BigInteger("1213221314"), iterator.prev());
    assertEquals(new BigInteger("232234"), iterator.prev());
    assertEquals(new BigInteger("3322444"), iterator.prev());
  }

  /**
   * Test that verifies that prev() throws a NoSuchElementException when there is no previous value.
   */
  @Test(expected = NoSuchElementException.class)
  public void testPrevNoValue() {
    BigInteger seed = new BigInteger("2112131211");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
    assertEquals(new BigInteger("112321"), iterator.prev());
    assertEquals(new BigInteger("13311"), iterator.prev());
    assertFalse(iterator.hasPrevious());
    iterator.prev();
  }

  /**
   * Test that verifies that hasNext() returns true when there is a next value.
   */
  @Test
  public void testHasNextTrue() {
    BigInteger seed = new BigInteger("112223333444");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
    assertEquals(new BigInteger("112223333444"), iterator.next());
    assertTrue(iterator.hasNext());
    assertEquals(new BigInteger("21324334"), iterator.next());
    assertTrue(iterator.hasNext());
    assertEquals(new BigInteger("12111312142314"), iterator.next());
    assertTrue(iterator.hasNext());
  }

  /**
   * Test that verifies that hasNext() returns false when there is no next value.
   */
  @Test
  public void testHasNextFalse() {
    BigInteger seed = new BigInteger("131425");
    BigInteger endValue = new BigInteger("999999999999999999");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed, endValue);
    assertEquals(new BigInteger("131425"), iterator.next());
    assertEquals(new BigInteger("111311141215"), iterator.next());
    assertEquals(new BigInteger("3113311411121115"), iterator.next());
    assertEquals(new BigInteger("132123211431123115"), iterator.next());
    assertFalse(iterator.hasNext());
  }

  /**
   * Test that verifies that hasPrevious() return true when there is a previous value.
   */
  @Test
  public void testHasPrevTrue() {
    BigInteger seed = new BigInteger("1215121711181319121122");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
    assertTrue(iterator.hasPrevious());
    assertEquals(new BigInteger("252718392122"), iterator.prev());
    assertTrue(iterator.hasPrevious());
    assertEquals(new BigInteger("557789991122"), iterator.prev());
    assertTrue(iterator.hasPrevious());
  }

  /**
   * Test that verifies that hasPrevious() returns false when there is no previous value.
   */
  @Test
  public void testHasPrevFalse() {
    BigInteger seed = new BigInteger("31173112311331153119");
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
    assertEquals(new BigInteger("11171112111311151119"), iterator.prev());
    assertEquals(new BigInteger("1712131519"), iterator.prev());
    assertEquals(new BigInteger("72359"), iterator.prev());
    assertFalse(iterator.hasPrevious());
  }

}
