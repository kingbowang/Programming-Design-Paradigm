package polynomial;

import java.util.Objects;

/**
 * This class represents an empty node in linked-list for polynomial.
 * which is the last element in the link-list.
 *
 * @author Pengbo Wang
 */
public class TermEmptyNode implements ListOfTerm {

  @Override
  public ListOfTerm addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Negative powers are not allowed");
    }
    Term term = new Term(coefficient, power);
    return new TermElementNode(term, this);
  }

  @Override
  public boolean equalsEmptyNode(TermEmptyNode emptyNode) {
    return true;
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof Polynomial)) {
      throw new IllegalArgumentException("Should add another Polynomial object.");
    }
    return other;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public double evaluate(double x) {
    return 0;
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ListOfTerm) {
      ListOfTerm l = (ListOfTerm) o;
      return l.equalsEmptyNode(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

}
