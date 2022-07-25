import document.Document;
import document.BasicStringVisitor;
import document.MarkdownStringVisitor;
import document.HtmlStringVisitor;
import document.elements.TextElementVisitor;
import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.Heading;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the document class.
 */
public class DocumentTest {
  BasicText basic;
  BoldText bold;
  ItalicText italic;
  Heading heading1;
  Heading heading2;
  HyperText url;
  Paragraph paragraph;
  Document document;

  /**
   * Sets up objects to be used in test functions.
   */
  @Before
  public void setUp() {
    basic = new BasicText("This is the last lab.");
    bold = new BoldText("See you again.");
    italic = new ItalicText("I love Northeastern University.");
    heading1 = new Heading("I am a student.", 1);
    heading2 = new Heading("I am smart.", 2);
    url = new HyperText("Baidu", "www.baidu.com");
    paragraph = new Paragraph();
    paragraph.add(basic);
    paragraph.add(bold);
    paragraph.add(italic);
    paragraph.add(heading1);
    paragraph.add(heading2);
    paragraph.add(url);
    document = new Document();
  }

  /**
   * Test for the WordCountVisitor.
   */
  @Test
  public void testWordCountVisitor() {
    document.add(heading1);
    assertEquals(4, document.countWords());
    document.add(heading2);
    assertEquals(7, document.countWords());
    document.add(basic);
    assertEquals(12, document.countWords());
    document.add(bold);
    assertEquals(15, document.countWords());
    document.add(italic);
    assertEquals(19, document.countWords());
    document.add(url);
    assertEquals(20, document.countWords());
  }

  /**
   * Test for the WordCountVisitor include a Paragraph element.
   */
  @Test
  public void testWordCountVisitorParagraph() {
    document.add(paragraph);
    assertEquals(20, document.countWords());
  }

  /**
   * Test for the BasicStringVisitor.
   */
  @Test
  public void testBasicStringVisitor() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();
    document.add(heading1);
    assertEquals("I am a student.", document.toText(basicStringVisitor));
    document.add(heading2);
    assertEquals("I am a student. I am smart.", document.toText(basicStringVisitor));
    document.add(basic);
    assertEquals("I am a student. I am smart. "
            + "This is the last lab.", document.toText(basicStringVisitor));
    document.add(bold);
    assertEquals("I am a student. I am smart. This is the last lab. "
            + "See you again.", document.toText(basicStringVisitor));
    document.add(italic);
    assertEquals("I am a student. I am smart. This is the last lab. "
            + "See you again. I love Northeastern University.",
            document.toText(basicStringVisitor));
    document.add(url);
    assertEquals("I am a student. I am smart. This is the last lab. "
            + "See you again. I love Northeastern University. Baidu",
            document.toText(basicStringVisitor));
  }

  /**
   * Test for the BasicStringVisitor include a Paragraph element.
   */
  @Test
  public void testBasicStringVisitorParagraph() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();
    document.add(paragraph);
    assertEquals("This is the last lab. See you again. I love Northeastern University. "
            + "I am a student. I am smart. Baidu", document.toText(basicStringVisitor));
  }

  /**
   * Test for the HtmlStringVisitor.
   */
  @Test
  public void testHtmlStringVisitor() {
    TextElementVisitor<String> htmlStringVisitor = new HtmlStringVisitor();
    document.add(heading1);
    assertEquals("<h1>I am a student.</h1>", document.toText(htmlStringVisitor));
    document.add(heading2);
    assertEquals("<h1>I am a student.</h1>\n"
            + "<h2>I am smart.</h2>", document.toText(htmlStringVisitor));
    document.add(basic);
    assertEquals("<h1>I am a student.</h1>\n"
            + "<h2>I am smart.</h2>\n"
            + "This is the last lab.", document.toText(htmlStringVisitor));
    document.add(bold);
    assertEquals("<h1>I am a student.</h1>\n"
            + "<h2>I am smart.</h2>\n"
            + "This is the last lab.\n"
            + "<b>See you again.</b>", document.toText(htmlStringVisitor));
    document.add(italic);
    assertEquals("<h1>I am a student.</h1>\n"
            + "<h2>I am smart.</h2>\n"
            + "This is the last lab.\n"
            + "<b>See you again.</b>\n"
            + "<i>I love Northeastern University.</i>", document.toText(htmlStringVisitor));
    document.add(url);
    assertEquals("<h1>I am a student.</h1>\n"
            + "<h2>I am smart.</h2>\n"
            + "This is the last lab.\n"
            + "<b>See you again.</b>\n"
            + "<i>I love Northeastern University.</i>\n"
            + "<a href=\"www.baidu.com\">Baidu</a>", document.toText(htmlStringVisitor));
  }

  /**
   * Test for the HtmlStringVisitor include a Paragraph element.
   */
  @Test
  public void testHtmlStringVisitorParagraph() {
    TextElementVisitor<String> htmlStringVisitor = new HtmlStringVisitor();
    document.add(paragraph);
    assertEquals("<p>This is the last lab.\n"
            + "<b>See you again.</b>\n"
            + "<i>I love Northeastern University.</i>\n"
            + "<h1>I am a student.</h1>\n"
            + "<h2>I am smart.</h2>\n"
            + "<a href=\"www.baidu.com\">Baidu</a>\n"
            + "</p>", document.toText(htmlStringVisitor));
  }

  /**
   * Test for the MarkdownStringVisitor.
   */
  @Test
  public void testMarkdownStringVisitor() {
    TextElementVisitor<String> markdownStringVisitor = new MarkdownStringVisitor();
    document.add(heading1);
    assertEquals("# I am a student.", document.toText(markdownStringVisitor));
    document.add(heading2);
    assertEquals("# I am a student.\n"
            + "## I am smart.", document.toText(markdownStringVisitor));
    document.add(basic);
    assertEquals("# I am a student.\n"
            + "## I am smart.\n"
            + "This is the last lab.", document.toText(markdownStringVisitor));
    document.add(bold);
    assertEquals("# I am a student.\n"
            + "## I am smart.\n"
            + "This is the last lab.\n"
            + "**See you again.**", document.toText(markdownStringVisitor));
    document.add(italic);
    assertEquals("# I am a student.\n"
            + "## I am smart.\n"
            + "This is the last lab.\n"
            + "**See you again.**\n"
            + "*I love Northeastern University.*", document.toText(markdownStringVisitor));
    document.add(url);
    assertEquals("# I am a student.\n"
            + "## I am smart.\n"
            + "This is the last lab.\n"
            + "**See you again.**\n"
            + "*I love Northeastern University.*\n"
            + "[Baidu](www.baidu.com)", document.toText(markdownStringVisitor));
  }

  /**
   * Test for the MarkdownStringVisitor include a Paragraph element.
   */
  @Test
  public void testMarkdownStringVisitorParagraph() {
    TextElementVisitor<String> markdownStringVisitor = new MarkdownStringVisitor();
    document.add(paragraph);
    assertEquals("This is the last lab.\n"
            + "**See you again.**\n"
            + "*I love Northeastern University.*\n"
            + "# I am a student.\n"
            + "## I am smart.\n"
            + "[Baidu](www.baidu.com)", document.toText(markdownStringVisitor));
  }
}
