package sentence;

/**
 * This class represents a word node in link-list.
 * with word and next nodes.
 *
 * @author Pengbo Wang
 */
public class WordNode implements Sentence {
  private final String word;
  private final Sentence rest;

  /**
   * Construct a WordNode object with the given word, and rest.
   *
   * @param word the word of WordNode
   * @param rest the rest of Sentence
   */
  public WordNode(String word, Sentence rest) {
    this.word = word;
    this.rest = rest;
  }

  @Override
  public int getNumberOfWords() {
    return 1 + rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {
    String restLongest = rest.longestWord();
    return word.length() >= restLongest.length() ? word : restLongest;
  }

  @Override
  public Sentence merge(Sentence other) {
    return new WordNode(this.word, this.rest.merge(other));
  }

  @Override
  public Sentence clone() {
    return new WordNode(this.word, this.rest.clone());
  }

  @Override
  public String toString() {
    String restToString = rest.toString();
    if (restToString.length() == 0) {
      return word + "";
    } else if (Character.isLetter(restToString.charAt(0))) {
      return word + " " + restToString;
    } else {
      return word + restToString;
    }
  }
}
