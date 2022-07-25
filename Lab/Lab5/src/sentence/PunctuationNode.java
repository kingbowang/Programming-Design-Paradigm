package sentence;

/**
 * This class represents a punctuation node in link-list.
 * with punctuation and next nodes.
 *
 * @author Pengbo Wang
 */
public class PunctuationNode implements Sentence {
  private final String punctuation;
  private final Sentence rest;

  /**
   * Construct a PunctuationNode object using word and rest instance variables.
   *
   * @param punctuation the information in this node
   * @param rest the rest of Sentence
   */
  public PunctuationNode(String punctuation, Sentence rest) {
    this.punctuation = punctuation;
    this.rest = rest;
  }

  @Override
  public int getNumberOfWords() {
    return rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {
    return rest.longestWord();
  }

  @Override
  public Sentence merge(Sentence other) {
    return new PunctuationNode(this.punctuation, this.rest.merge(other));
  }

  @Override
  public Sentence clone() {
    return new PunctuationNode(this.punctuation, this.rest.clone());
  }

  @Override
  public String toString() {
    String restToString = rest.toString();
    if (restToString.length() == 0) {
      return punctuation;
    } else {
      return punctuation + " " + restToString;
    }
  }
}
