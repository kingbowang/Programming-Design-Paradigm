package polynomial;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test for PolynomialImpl class.
 *
 * @author Pengbo Wang
 */
public class PolynomialImplTest {
  private Polynomial polynomial1;
  private Polynomial polynomial2;
  private Polynomial polynomial3;

  /**
   * Set up using Two constructors.
   */
  @Before
  public void setup() {
    polynomial1 = new PolynomialImpl();
    polynomial2 = new PolynomialImpl();
    polynomial3 = new PolynomialImpl("4x^3 +3x^1 -5");
  }

  /**
   * Test that verifies that the no-argument constructor works correctly.
   */
  @Test
  public void testNoArgConstructor() {
    assertEquals("0", polynomial1.toString());
  }

  /**
   * Test that verifies that the string argument constructor works correctly when
   * given a valid non-zero polynomial with more than one term with unique powers.
   */
  @Test
  public void testStringTermUniquePower() {
    polynomial1.addTerm(8, 4);
    polynomial1.addTerm(5, 9);
    polynomial1.addTerm(3, 2);
    assertEquals("5x^9 +8x^4 +3x^2", polynomial1.toString());
  }

  /**
   * Test that verifies that the string argument constructor works correctly when given a
   * valid non-zero polynomial with more than one term with multiple terms with the same power.
   */
  @Test
  public void testStringTermSamePower() {
    polynomial1.addTerm(8, 4);
    polynomial1.addTerm(5, 4);
    polynomial1.addTerm(3, 4);
    assertEquals("16x^4", polynomial1.toString());
  }

  /**
   * Test that verifies that the string argument constructor
   * works correctly when given a constant polynomial.
   */
  @Test
  public void testStringConstantPolynomial() {
    Polynomial p1 = new PolynomialImpl("2");
    assertEquals("2", p1.toString());
  }

  /**
   * Test that verifies that the string argument constructor works as
   * expected (as you have documented it) when given an empty string.
   */
  @Test
  public void testEmptyString() {
    Polynomial p1 = new PolynomialImpl("");
    assertEquals("", p1.toString());
  }

  /**
   * Test that verifies that the string argument constructor
   * works correctly when given a *null* string.
   */
  @Test
  public void testNullString() {
    Polynomial p1 = null;
    assertNull(p1);
  }

  /**
   * Test that verifies that the string argument constructor
   * throws an exception when given an invalid string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidString() {
    Polynomial p1 = new PolynomialImpl("Hello!");
  }

  /**
   * Test that verifies that the toString works
   * correctly when the polynomial has multiple terms.
   */
  @Test
  public void TestToStringMultiTerms() {
    polynomial1.addTerm(4, 2);
    polynomial1.addTerm(7, 3);
    polynomial1.addTerm(2, 1);
    assertEquals("7x^3 +4x^2 +2x^1", polynomial1.toString());
    assertEquals("4x^3 +3x^1 -5", polynomial3.toString());
    Polynomial p1 = new PolynomialImpl("13x^8 -5x^6");
    assertEquals("13x^8 -5x^6", p1.toString());
  }

  /**
   * Test that verifies that the toString prints 1
   * before the term if it has a coefficient of 1.
   */
  @Test
  public void TestToStringOne() {
    polynomial1.addTerm(1, 0);
    assertEquals("1", polynomial1.toString());
  }

  /**
   * Test that verifies that the add method works correctly when
   * two polynomials with multiple terms and unique powers are added.
   */
  @Test
  public void TestAddUniquePowerPolynomial() {
    polynomial1.addTerm(7, 8);
    polynomial1.addTerm(10, 9);
    assertEquals("10x^9 +7x^8", polynomial1.toString());
    polynomial2.addTerm(3, 2);
    polynomial2.addTerm(6, 4);
    assertEquals("10x^9 +7x^8 +6x^4 +3x^2", polynomial1.add(polynomial2).toString());
  }

  /**
   * Test that verifies that the add method works correctly when
   * two polynomials with multiple terms and same powers are added.
   */
  @Test
  public void TestAddSamePowerPolynomial() {
    polynomial1.addTerm(4, 2);
    polynomial1.addTerm(6, 3);
    polynomial1.addTerm(2, 1);
    assertEquals("6x^3 +4x^2 +2x^1", polynomial1.toString());
    polynomial2.addTerm(1, 1);
    polynomial2.addTerm(5, 3);
    polynomial2.addTerm(5, 2);
    assertEquals("11x^3 +9x^2 +3x^1", polynomial1.add(polynomial2).toString());
  }

  /**
   * Test that verifies that the add method works correctly
   * when one or both of the polynomials are 0.
   */
  @Test
  public void TestAddZeroPolynomial() {
    polynomial1.addTerm(5, 3);
    polynomial1.addTerm(-4, 2);
    Polynomial p1 = new PolynomialImpl("0");
    Polynomial p2 = new PolynomialImpl("0");
    assertEquals("0", p1.add(p2).toString());
    assertEquals("5x^3 -4x^2", polynomial1.add(p1).toString());
  }

  /**
   * Test that verifies that the addTerm method throws
   * an IllegalArgumentException if the power is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestAddTermNegative() {
    polynomial1.addTerm(7, -5);
  }

  /**
   * Test that verifies that the addTerm method works
   * correctly when adding a term that already exists.
   */
  @Test
  public void TestAddTermExist() {
    polynomial1.addTerm(-7, 8);
    polynomial1.addTerm(2, 3);
    polynomial1.addTerm(-4, 5);
    polynomial1.addTerm(19, 2);
    polynomial1.addTerm(9, 11);
    assertEquals("9x^11 -7x^8 -4x^5 +2x^3 +19x^2", polynomial1.toString());

    polynomial2.addTerm(2, 3);
    polynomial2.addTerm(4, 3);
    polynomial2.addTerm(7, 3);
    assertEquals(13, polynomial2.getCoefficient(3));
  }

  /**
   * Test that verifies that the addTerm method works
   * correctly when adding a term that does not exist.
   */
  @Test
  public void TestAddTermNotExist() {
    polynomial1.addTerm(0, 0);
    assertEquals("0", polynomial1.toString());
    assertEquals(0, polynomial1.getCoefficient(0));
  }

  /**
   * Test that verifies that the isSame method works correctly when two
   * polynomials with multiple terms and unique powers are checked for sameness.
   */
  @Test
  public void TestIsSameUniquePower() {
    polynomial1.addTerm(4, 2);
    polynomial1.addTerm(7, 5);
    polynomial2.addTerm(5, 4);
    polynomial2.addTerm(-8, 3);
    assertFalse(polynomial1.isSame(polynomial2));
  }

  /**
   * Test that verifies that the isSame method works correctly when two
   * polynomials with multiple terms and same powers are checked for sameness.
   */
  @Test
  public void TestIsSamePower() {
    polynomial1.addTerm(4, 2);
    polynomial1.addTerm(7, 5);
    polynomial2.addTerm(7, 5);
    polynomial2.addTerm(-4, 2);
    assertFalse(polynomial1.isSame(polynomial2));
    Polynomial p1 = new PolynomialImpl("7x^5 +4x^2");
    assertTrue(polynomial1.isSame(p1));
  }

  /**
   * Test that verifies that the isSame method works
   * correctly when one or both of the polynomials are 0.
   */
  @Test
  public void TestIsSameZero() {
    Polynomial p1 = new PolynomialImpl("0");
    Polynomial p2 = new PolynomialImpl("0");
    assertTrue(p1.isSame(p2));
    polynomial1.addTerm(4, 2);
    polynomial2.addTerm(0, 0);
    assertFalse(polynomial1.isSame(p1));
    assertTrue(p1.isSame(polynomial2));
  }

  /**
   * Test that verifies that the getDegree method works correctly
   * when the degree of a polynomial is a positive number.
   */
  @Test
  public void TestGetDegreePositive() {
    polynomial1.addTerm(4, 5);
    polynomial1.addTerm(7, 8);
    polynomial1.addTerm(2, 3);
    polynomial1.addTerm(2, 9);
    // constructor 1
    assertEquals(9, polynomial1.getDegree());
    // constructor 2
    assertEquals(3, polynomial3.getDegree());
  }

  /**
   * Test that verifies that the getDegree
   * returns 0 when the polynomial is a constant.
   */
  @Test
  public void TestGetDegreeConstant() {
    Polynomial p1 = new PolynomialImpl("123");
    assertEquals(0, p1.getDegree());
  }

  /**
   * Test that verifies that the getCoefficient method works correctly
   * when a term with the given power exists in the polynomial.
   */
  @Test
  public void TestGetCoefficientWithPower() {
    polynomial1.addTerm(7, 8);
    polynomial1.addTerm(-4, 5);
    polynomial1.addTerm(2, 3);
    // constructor 1
    assertEquals(7, polynomial1.getCoefficient(8));
    assertEquals(-4, polynomial1.getCoefficient(5));
    assertEquals(2, polynomial1.getCoefficient(3));
    // constructor 2
    assertEquals(4, polynomial3.getCoefficient(3));
  }

  /**
   * Test that verifies that the getCoefficient method works correctly
   * when no term with the given power exists in the polynomial.
   */
  @Test
  public void TestGetCoefficientNoPower() {
    polynomial1.addTerm(7, 0);
    assertEquals(7, polynomial1.getCoefficient(0));
  }

  /**
   * Test that verifies that the evaluate method
   * works correctly for negative values of x.
   */
  @Test
  public void TestEvaluateNegativeValue() {
    polynomial1.addTerm(7, 3);
    polynomial1.addTerm(-4, 2);
    polynomial1.addTerm(2, 1);
    assertEquals(-23.61, polynomial3.evaluate(-1.52), 0.01);
  }

  /**
   * Test that verifies that the evaluate method
   * works correctly for positive values of x.
   */
  @Test
  public void TestEvaluatePositiveValue() {
    polynomial1.addTerm(7, 3);
    polynomial1.addTerm(-4, 2);
    polynomial1.addTerm(2, 1);
    assertEquals(89.375, polynomial1.evaluate(2.5), 0.01);
  }

}