package sentence;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for sentence and nodes.
 *
 * @author Pengbo Wang
 */
public class SentenceTest {

  private Sentence sentenceEmpty;
  private Sentence sentenceOne;
  private Sentence sentenceTwo;
  private Sentence sentenceThree;
  private Sentence sentenceFour;
  private Sentence sentenceFive;

  @Before
  public void setup() {
    sentenceEmpty = new EmptyNode();

    sentenceOne = new WordNode("I", new WordNode("love",
            new WordNode("Computer", new WordNode("Engineering", new
                    WordNode("and", new WordNode("Psychology", new EmptyNode()))))));

    sentenceTwo = new WordNode("I", new WordNode("love",
            new WordNode("Computer", new WordNode("Engineering", new
                    PunctuationNode(",", new WordNode("Psychology", new
                    PunctuationNode("!", new EmptyNode())))))));

    sentenceThree = new WordNode("The", new WordNode("dogs",
            new WordNode("there", new WordNode("are", new
                    WordNode("really", new WordNode("cute", new EmptyNode()))))));

    sentenceFour = new WordNode("I", new WordNode("like",
            new WordNode("playing", new WordNode("basketball",
                    new PunctuationNode(".", new EmptyNode())))));

    sentenceFive = new WordNode("And", new WordNode("I",
            new WordNode("can", new WordNode("dunk",
                    new PunctuationNode("!", new EmptyNode())))));

  }

  @Test
  public void testGetNumberOfWordsEmpty() {
    assertEquals(0, sentenceEmpty.getNumberOfWords());
  }

  @Test
  public void testGetNumberOfWordsNonEmpty() {
    assertEquals(6, sentenceOne.getNumberOfWords());
  }

  @Test
  public void testGetNumberOfWordsPunctuation() {
    assertEquals(5, sentenceTwo.getNumberOfWords());
  }

  @Test
  public void testLongestWordEmpty() {
    assertEquals("", sentenceEmpty.longestWord());
  }

  @Test
  public void testLongestWordAllWordDiffLen() {
    assertEquals("Engineering", sentenceOne.longestWord());
  }

  @Test
  public void testLongestWordMulSameLen() {
    assertEquals("really", sentenceThree.longestWord());
  }

  @Test
  public void testMergeEmpty() {
    Sentence temp = sentenceEmpty.merge(sentenceEmpty);
    assertEquals("", temp.toString());
  }

  @Test
  public void testMergeEndPunctuation() {
    Sentence temp = sentenceFour.merge(sentenceFive);
    assertEquals("I like playing basketball. And I can dunk!", temp.toString());
  }

  @Test
  public void testMergeMiddlePunctuation() {
    Sentence temp = sentenceTwo.merge(sentenceFour);
    assertEquals("I love Computer Engineering, Psychology! " +
            "I like playing basketball.", temp.toString());
  }

  @Test
  public void testCloneEmpty() {
    Sentence temp = sentenceEmpty.clone();
    assertEquals("", temp.toString());
  }

  @Test
  public void testCloneOnlyWords() {
    Sentence temp = sentenceOne.clone();
    assertEquals("I love Computer Engineering and Psychology", temp.toString());
  }

  @Test
  public void testClonePunctuation() {
    Sentence temp = sentenceFour.clone();
    assertEquals("I like playing basketball.", temp.toString());
  }

  @Test
  public void testToStringEmpty() {
    assertEquals("", sentenceEmpty.toString());
  }

  @Test
  public void testToStringOnlyWords() {
    assertEquals("The dogs there are really cute", sentenceThree.toString());
  }

  @Test
  public void testToStringEndPunctuation() {
    assertEquals("I like playing basketball.", sentenceFour.toString());
  }

  @Test
  public void testToMiddlePunctuation() {
    assertEquals("I love Computer Engineering, Psychology!", sentenceTwo.toString());
  }

}