package polynomial;

/**
 * This interface represents a linked-list. It is the super-type for.
 * any other type of linked-list we might create.
 *
 * @author Pengbo Wang
 */
public interface ListOfTerm {

  /**
   * Takes a coefficient and a power (both integral numbers).
   * and adds the resulting term to the polynomial.
   * throw an IllegalArgumentException if a negative power is passed to it.
   *
   * @param coefficient int coefficient.
   * @param power       int power.
   * @return a linked list of polynomial.
   */
  ListOfTerm addTerm(int coefficient, int power) throws IllegalArgumentException;

  default boolean equalsEmptyNode(TermEmptyNode emptyNode) {
    return false;
  }

  default boolean equalsElementNode(TermElementNode elementNode) {
    return false;
  }

  /**
   * Add this polynomial to another and return the result as another polynomial.
   *
   * @param other the other polynomial to be added
   * @return the resulting polynomial
   * @throws IllegalArgumentException if parameter is not the same concrete type
   *                                  as the current object.
   */
  Polynomial add(Polynomial other) throws IllegalArgumentException;

  /**
   * takes a power and returns the coefficient for the term with that power.
   *
   * @param power int power
   * @return the coefficient for the term with that power.
   */
  int getCoefficient(int power);

  /**
   * Get the greatest degree of polynomial.
   *
   * @return the degree of this polynomial.
   */
  int getDegree();

  /**
   * takes a double-precision decimal number and returns a double-precision result.
   *
   * @param x double.
   * @return a double result.
   */
  double evaluate(double x);

}
