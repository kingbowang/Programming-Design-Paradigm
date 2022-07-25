package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElementVisitor;

/**
 * Counts the number of words that are in a document.
 */
public class WordCountVisitor implements TextElementVisitor<Integer> {
  @Override
  public Integer visitBasicText(BasicText basicText) {
    return basicText.getText().split(" ").length;
  }

  @Override
  public Integer visitBoldText(BoldText boldText) {
    return boldText.getText().split(" ").length;
  }

  @Override
  public Integer visitHeading(Heading heading) {
    return heading.getText().split(" ").length;
  }

  @Override
  public Integer visitHyperText(HyperText hyperText) {
    return hyperText.getText().split(" ").length;
  }

  @Override
  public Integer visitItalicText(ItalicText italicText) {
    return italicText.getText().split(" ").length;
  }

  @Override
  public Integer visitParagraph(Paragraph paragraph) {
    return paragraph.getText().split(" ").length;
  }
}
