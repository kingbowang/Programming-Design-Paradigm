package polynomial;

import java.util.Objects;

/**
 * This class represent a single term in a polynomial.
 * Each term includes coefficient, variable and power.
 *
 * @author Pengbo Wang
 */
public class Term {
  private int coefficient;
  private final int power;

  /**
   * Constructs a polynomial term node with coefficient, variable and power.
   */
  public Term(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power of polynomial must greater than 0");
    }
    this.coefficient = coefficient;
    this.power = power;
  }

  public void setCoefficient(int coefficient) {
    this.coefficient = coefficient;
  }

  public int getCoefficient() {
    return this.coefficient;
  }

  public int getPower() {
    return this.power;
  }

  public int coefficientGetter() {
    return coefficient;
  }

  public int powerGetter() {
    return power;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Term) {
      Term t = (Term) o;
      return (coefficient == t.getCoefficient() && power == t.getPower());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(coefficient, power);
  }

  /**
   * Return a String representing this term.
   *
   * @return a String representing this term.
   */
  public String toString() {
    if (this.coefficient == 0) {
      return "";
    }
    if (this.power == 0 && this.coefficient > 0) {
      return String.format(" +%d", this.coefficient);
    }
    if (this.power == 0) {
      return String.format(" %d", this.coefficient);
    }
    if (this.coefficient > 0) {
      return String.format(" +%dx^%d", this.coefficient, this.power);
    }
    return String.format(" %dx^%d", this.coefficient, this.power);
  }

}
