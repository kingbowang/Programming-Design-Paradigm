package polynomial;

import java.util.Objects;

/**
 * This class represent an element node class for Linked-list for Polynomial.
 *
 * @author Pengbo Wang
 */
public class TermElementNode implements ListOfTerm {
  private final Term term;
  private final ListOfTerm rest;

  /**
   * Constructs an element node object.
   *
   * @param term The term with in the node.
   * @param rest The rest terms.
   */
  public TermElementNode(Term term, ListOfTerm rest) {
    this.term = term;
    this.rest = rest;
  }

  @Override
  public ListOfTerm addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("No negative power input");
    }
    if (term.powerGetter() > power) {
      return new TermElementNode(term, rest.addTerm(coefficient, power));
    }
    if (term.powerGetter() == power) {
      this.term.setCoefficient(coefficient + this.term.coefficientGetter());
      return this;
    }
    Term p = new Term(coefficient, power);
    return new TermElementNode(p, this);
  }

  @Override
  public boolean equalsElementNode(TermElementNode elt) {
    return term.equals(elt.term) && rest.equals(elt.rest);
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof Polynomial)) {
      throw new IllegalArgumentException("Should add another Polynomial object.");
    }
    String str1 = this.toString();
    String str2 = other.toString();
    String merge = str1 + " " + str2;
    Polynomial poly = new PolynomialImpl(merge);
    return poly;
  }

  @Override
  public int getCoefficient(int power) {
    if (term.powerGetter() == power) {
      return term.getCoefficient();
    } else {
      return rest.getCoefficient(power);
    }
  }

  @Override
  public int getDegree() {
    return this.term.powerGetter();
  }

  @Override
  public double evaluate(double x) {
    double res = Math.pow(x, term.powerGetter()) * term.coefficientGetter();
    return res + rest.evaluate(x);
  }

  @Override
  public String toString() {
    return this.term.toString() + this.rest.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ListOfTerm) {
      ListOfTerm l = (ListOfTerm) o;
      return l.equalsElementNode(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(term, rest);
  }

}
