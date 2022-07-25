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
 * Generates a Markdown version of the document.
 */
public class MarkdownStringVisitor implements TextElementVisitor<String> {
  @Override
  public String visitBasicText(BasicText basicText) {
    return basicText.getText().trim() + "\n";
  }

  @Override
  public String visitBoldText(BoldText boldText) {
    return "**" + boldText.getText().trim() + "**\n";
  }

  @Override
  public String visitHeading(Heading heading) {
    StringBuilder s = new StringBuilder();
    switch (heading.getLevel()) {
      case 1: s.append("# ");
        break;
      case 2: s.append("## ");
        break;
      case 3: s.append("### ");
        break;
      default: s.append(" ");
    }
    return s.append(heading.getText().trim()).append("\n").toString();
  }

  @Override
  public String visitHyperText(HyperText hyperText) {
    return "[" + hyperText.getText().trim() + "](" + hyperText.getUrl().trim() + ")\n";
  }

  @Override
  public String visitItalicText(ItalicText italicText) {
    return "*" + italicText.getText().trim() + "*\n";
  }

  @Override
  public String visitParagraph(Paragraph paragraph) {
    StringBuilder s = new StringBuilder();
    s.append("\n");
    List<BasicText> list = paragraph.getContent();
    for (BasicText b : list) {
      s.append(b.accept(this));
    }
    s.append("\n");
    return s.toString();
  }
}
