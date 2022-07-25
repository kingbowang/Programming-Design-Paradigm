package document.elements;

/**
 * Representation for any of the text elements of a document.
 */
public interface TextElement {

  /**
   * Returns the text of the element.
   *
   * @return the text
   */
  public String getText();

  /**
   * The visitor that is passed in is used to call the specific method in its class.
   *
   * @param visitor the param that calls the specified method
   * @param <R> the type of the return parameter for the  visit
   */
  public <R> R accept(TextElementVisitor<R> visitor);
}
