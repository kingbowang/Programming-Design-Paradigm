package polynomial;

/**
 * This class should store the polynomial using the linked list with nodes.
 * This representation must be implemented by you (i.e. you are not allowed to use.
 * existing List classes in Java).
 *
 * @author Pengbo Wang
 */
public class PolynomialImpl implements Polynomial {
  private ListOfTerm head;

  public PolynomialImpl() {
    head = new TermEmptyNode();
  }

  /**
   * Split array for getting coefficient and power of each term.
   * use addTerm to add to Polynomial.
   *
   * @param p String of polynomial.
   */
  public PolynomialImpl(String p) {
    head = new TermEmptyNode();
    String[] list = p.split("\\s+");

    for (String a : list) {
      if (!a.contains("x")) {
        head = head.addTerm(Integer.parseInt(a), 0);
      } else {
        String[] term = a.split("x\\^");
        int coefficient = Integer.parseInt(term[0]);
        int power = Integer.parseInt(term[1]);
        head = head.addTerm(coefficient, power);
      }
    }

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
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Negative powers are not allowed");
    }
    this.head = this.head.addTerm(coefficient, power);
  }

  @Override
  public boolean isSame(Polynomial poly) {
    if (!(poly instanceof PolynomialImpl)) {
      return false;
    }
    PolynomialImpl otherpoly = (PolynomialImpl) poly;
    return head.equals(otherpoly.head);
  }

  @Override
  public double evaluate(double x) {
    return head.evaluate(x);
  }

  @Override
  public int getCoefficient(int power) {
    return head.getCoefficient(power);
  }

  @Override
  public int getDegree() {
    return this.head.getDegree();
  }

  /**
   * toString for print polynomial.
   *
   * @return String.
   */
  @Override
  public String toString() {
    // remove the first space
    String s = head.toString().replaceFirst(" ", "");
    if (s.equals("")) {
      return "0";
    }
    // remove the plus sign at the beginning
    if (s.startsWith("+")) {
      s = s.substring(1);
    }
    return s;
  }

}
