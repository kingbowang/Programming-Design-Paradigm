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
 * Generates an HTML version of the document.
 */
public class HtmlStringVisitor implements TextElementVisitor<String> {
  @Override
  public String visitBasicText(BasicText basicText) {
    return basicText.getText().trim() + "\n";
  }

  @Override
  public String visitBoldText(BoldText boldText) {
    return "<b>" + boldText.getText().trim() + "</b>\n";
  }

  @Override
  public String visitHeading(Heading heading) {
    int level = heading.getLevel();
    return "<h" + level + ">" + heading.getText().trim() + "</h" + level + ">\n";
  }

  @Override
  public String visitHyperText(HyperText hyperText) {
    return "<a href=\"" + hyperText.getUrl().trim() + "\">" + hyperText.getText().trim() + "</a>\n";
  }

  @Override
  public String visitItalicText(ItalicText italicText) {
    return "<i>" + italicText.getText().trim() + "</i>\n";
  }

  @Override
  public String visitParagraph(Paragraph paragraph) {
    StringBuilder s = new StringBuilder();
    s.append("<p>");
    List<BasicText> list = paragraph.getContent();
    for (BasicText b : list) {
      s.append(b.accept(this));
    }
    s.append("</p>\n");
    return s.toString();
  }
}
