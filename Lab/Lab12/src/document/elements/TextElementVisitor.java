package document.elements;

/**
 * This is an interface for the visitor on textElement This interface
 * offers a chance to visit every kind of concrete textElement in the hierarchy.
 * Some visitors may want this level of granularity, others may not.
 *
 * @param <R> the type of the return parameter for the visit
 */
public interface TextElementVisitor<R> {

  /**
   * Performs the appropriate visit for the basicText.
   *
   * @param basicText the BasicText object
   */
  R visitBasicText(BasicText basicText);

  /**
   * Performs the appropriate visit for the BoldText.
   *
   * @param boldText the BoldText object
   */
  R visitBoldText(BoldText boldText);

  /**
   * Performs the appropriate visit for the Heading.
   *
   * @param heading the Heading object
   */
  R visitHeading(Heading heading);

  /**
   * Performs the appropriate visit for the HyperText.
   *
   * @param hyperText the HyperText object
   */
  R visitHyperText(HyperText hyperText);

  /**
   * Performs the appropriate visit for the ItalicText.
   *
   * @param italicText the ItalicText object
   */
  R visitItalicText(ItalicText italicText);

  /**
   * Performs the appropriate visit for the Paragraph.
   *
   * @param paragraph the Paragraph object
   */
  R visitParagraph(Paragraph paragraph);
}