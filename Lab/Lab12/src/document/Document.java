package document;

import document.elements.TextElement;
import document.elements.TextElementVisitor;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a document. It contains a list of the elements of the
 * document in the order that they appear in the document. This class is
 * provided as a starting point for the Visitor lab in CS 5010.
 */
public class Document {

  private List<TextElement> content;

  /** Default constructor initializes the fields of the class. */
  public Document() {
    content = new ArrayList<>();
  }

  /**
   * Add an element to the document. Elements are added in order.
   *
   * @param e the element to add
   */
  public void add(TextElement e) {
    content.add(e);
  }

  /**
   * Returns the number of words in the document.
   *
   * @return the number of words in the document.
   */
  public int countWords() {
    int count = 0;
    TextElementVisitor<Integer> wordCountVisitor = new WordCountVisitor();
    for (TextElement textElement : content) {
      count += textElement.accept(wordCountVisitor);
    }
    return count;
  }

  /**
   * Takes in one of the "string visitors" as a parameter and returns a string for the respective
   * visitor.
   *
   * @param visitor the string visitor
   * @return the toString() of the respective visitor.
   */
  public <R> String toText(TextElementVisitor<R> visitor) {
    StringBuilder stb = new StringBuilder();
    for (TextElement textElement : content) {
      stb.append(textElement.accept(visitor));
    }
    return stb.toString().trim();
  }
}
