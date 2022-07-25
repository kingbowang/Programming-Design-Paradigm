package lookandsay;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/**
 * Implementation of a LookAndSay Iterator. Represents a class that can
 * produce its next and prev values based on the LookAndSay algorithm.
 */
public class LookAndSayIterator implements RIterator<BigInteger> {
  private BigInteger seed;
  private final BigInteger end;
  private boolean seedUsed;
  private static final BigInteger DEFAULT_END = new BigInteger("9".repeat(100));
  private static final BigInteger DEFAULT_SEED = BigInteger.ONE;

  /**
   * Initializes fields with the provided values.
   * Two arguments constructor.
   *
   * @param seed the starting value
   * @param end  the end value
   */
  public LookAndSayIterator(BigInteger seed, BigInteger end) {
    if (seed.compareTo(new BigInteger("0")) <= 0 || seed.toString().indexOf('0') != -1
            || seed.compareTo(end) >= 0) {
      throw new IllegalArgumentException("Invalid seed: " + seed);
    }
    this.seed = seed;
    this.end = end;
    seedUsed = false;
  }

  /**
   * One argument constructor.
   *
   * @param seed the seed
   */
  public LookAndSayIterator(BigInteger seed) {
    this(seed, DEFAULT_END);
  }

  /**
   * No argument constructor.
   */
  public LookAndSayIterator() {
    this(DEFAULT_SEED, DEFAULT_END);
  }

  @Override
  public BigInteger prev() throws NoSuchElementException {
    if (!hasPrevious()) {
      throw new NoSuchElementException("can't go prev");
    }
    seed = computePrev(seed);
    return seed;
  }

  @Override
  public boolean hasPrevious() {
    if (seed.equals(DEFAULT_SEED)) {
      return false;
    }
    try {
      return computePrev(seed).compareTo(end) < 0;
    } catch (StringIndexOutOfBoundsException e) {
      return false;
    }
  }

  private BigInteger computePrev(BigInteger current) {
    String currentString = current.toString();
    StringBuilder soln = new StringBuilder();

    for (int i = 0; i < currentString.length(); i += 2) {
      int freq = Character.digit(currentString.charAt(i), 10);
      int num = Character.digit(currentString.charAt(i + 1), 10);
      soln.append(String.valueOf(num).repeat(Math.max(0, freq)));
    }
    return new BigInteger(soln.toString());
  }

  @Override
  public boolean hasNext() {
    if (!seedUsed) {
      return true;
    }
    return computeNext(seed).compareTo(end) < 0;
  }

  @Override
  public BigInteger next() {
    if (!hasNext()) {
      throw new NoSuchElementException("can't go next");
    }
    if (seedUsed) {
      seed = computeNext(seed);
    } else {
      seedUsed = true;
    }
    return seed;
  }

  private BigInteger computeNext(BigInteger current) {
    String currentString = current.toString();
    StringBuilder nxt = new StringBuilder();
    for (int i = 0; i < currentString.length(); ) {
      char dig = currentString.charAt(i);
      int ct = 1;
      while (i + ct < currentString.length() && currentString.charAt(i + ct) == dig) {
        ct++;
      }
      nxt.append(ct).append(dig);
      i += ct;
    }
    return new BigInteger(nxt.toString());
  }

}
