package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElementVisitor;
import java.util.List;

/**
 * Generates a simple string representation of the document.
 */
public class BasicStringVisitor implements TextElementVisitor<String> {
  @Override
  public String visitBasicText(BasicText basicText) {
    return basicText.getText().trim() + " ";
  }

  @Override
  public String visitBoldText(BoldText boldText) {
    return boldText.getText().trim() + " ";
  }

  @Override
  public String visitHeading(Heading heading) {
    return heading.getText().trim() + " ";
  }

  @Override
  public String visitHyperText(HyperText hyperText) {
    return hyperText.getText().trim() + " ";
  }

  @Override
  public String visitItalicText(ItalicText italicText) {
    return italicText.getText().trim() + " ";
  }

  @Override
  public String visitParagraph(Paragraph paragraph) {
    StringBuilder s = new StringBuilder();
    List<BasicText> list = paragraph.getContent();
    for (BasicText b : list) {
      s.append(b.accept(this));
    }
    s.append(" ");
    return s.toString();
  }
}
