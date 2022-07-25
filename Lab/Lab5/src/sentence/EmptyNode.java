package sentence;

/**
 * This class represents an empty node in link-list.
 * which is the last element in the link-list.
 *
 * @author Pengbo Wang
 */
public class EmptyNode implements Sentence {

  @Override
  public int getNumberOfWords() {
    return 0;
  }

  @Override
  public String longestWord() {
    return "";
  }

  @Override
  public Sentence merge(Sentence other) {
    return other.clone();
  }

  @Override
  public Sentence clone() {
    return new EmptyNode();
  }

  @Override
  public String toString() {
    return "";
  }
}
