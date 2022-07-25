package questions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Testing for all questions.
 */
public class QuestionTest {
  Question trueFalse;
  Question likert;
  Question multipleChoice;
  Question multipleSelect;

  @Before
  public void setUp() {
    trueFalse = new TrueFalse("Are you a student at Northeastern University?", "true");
    likert = new Likert("Is Lebron the best basketball player?");
    multipleChoice = new MultipleChoice("How many students are "
            + "there?", "2", "1", "2", "6", "5");
    multipleSelect = new MultipleSelect("Which numbers does Peter "
            + "like?", "1 3", "3", "2", "7", "1");
  }

  /**
   * Tested getTex and constructor.
   */
  @Test
  public void testConstructorTrue() {
    Question trueFalse = new TrueFalse("Are you a student at Northeastern University?", "true");
    Assert.assertEquals("Are you a student at Northeastern University?", trueFalse.getText());
  }

  /**
   * Tested getTex and constructor.
   */
  @Test
  public void testConstructorLikert() {
    Question likert = new Likert("Is Lebron the best basketball player?");
    Assert.assertEquals("Is Lebron the best basketball player?", likert.getText());
  }

  /**
   * Tested getTex and constructor.
   */
  @Test
  public void testConstructorMultipleChoice() {
    Question multipleChoice = new MultipleChoice("How many students are "
            + "there?", "2", "4", "2", "3", "1");
    Assert.assertEquals("How many students are there?", multipleChoice.getText());
  }

  /**
   * Tested getTex and constructor.
   */
  @Test
  public void testConstructorMultipleSelect() {
    Question multipleSelect = new MultipleSelect("Which numbers does Peter "
            + "like?", "1 3", "4", "2", "3", "1");
    Assert.assertEquals("Which numbers does Peter like?", multipleSelect.getText());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyQuestionTrue() {
    Question trueFalse = new TrueFalse("", "true");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyQuestionLikert() {
    Question likert = new Likert("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyQuestionMultipleChoice() {
    Question multipleChoice = new MultipleChoice("", "2", "2", "1", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyQuestionMultipleSelect() {
    Question multipleSelect = new MultipleSelect("", "1 2", "2", "1", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnswerTrue() {
    Question trueFalse = new TrueFalse("What is this?", "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnswerMultipleChoice() {
    Question multipleChoice = new MultipleChoice("What is your number?", "", "2", "1", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnswerMultipleSelect() {
    Question multipleSelect = new MultipleSelect("What are your numbers?", "", "2", "1", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNotTrueOrFalse() {
    Question trueFalse = new TrueFalse("Is 1 greater than 2?", "yes");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNotEnoughMultipleChoice() {
    Question multipleChoice = new MultipleChoice("What is your number?", "1", "2", "1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNotEnoughMultipleSelect() {
    Question multipleSelect = new MultipleSelect("What are your numbers?", "1 2", "2", "1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testManyMultipleChoice() {
    Question multipleChoice = new MultipleChoice("What is your number"
            + "?", "1", "1", "2", "3", "4", "5", "6", "7", "8", "29", "10");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testManyMultipleSelect() {
    Question multipleSelect = new MultipleSelect("Which numbers does Peter "
            + "like?", "1 3", "1", "2", "3", "4", "5", "6", "7", "8", "29", "10");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoAnswerMultipleChoice() {
    Question multipleChoice = new MultipleChoice("What is your number"
            + "?", "5", "1", "2", "3", "4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoAnswerMultipleSelect() {
    Question multipleSelect = new MultipleSelect("Which numbers does Peter "
            + "like?", "5 6", "1", "2", "3", "4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyOptionMultipleChoice() {
    Question multipleChoice = new MultipleChoice("What is your number"
            + "?", "1", "1", "2", " ", "4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyOptionMultipleSelect() {
    Question multipleSelect = new MultipleSelect("Which numbers does Peter "
            + "like?", "1 2", "1", "2", " ", "4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnsweredTrue() {
    Question trueFalse = new TrueFalse("Are you a student at Northeastern University?", "true");
    trueFalse.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnsweredLikert() {
    Question likert = new Likert("How do you rate your academic adviser?");
    likert.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnsweredMultipleChoice() {
    Question multipleChoice = new MultipleChoice("How many students are "
            + "there?", "2", "4", "2", "3", "1");
    multipleChoice.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnsweredMultipleSelect() {
    Question multipleSelect = new MultipleSelect("Which numbers does Peter "
            + "like?", "1 3", "4", "2", "3", "1");
    multipleSelect.answer("");
  }

  @Test
  public void testRightAnswerTrue() {
    Question trueFalse = new TrueFalse("Are you a student at Northeastern University?", "true");
    Assert.assertEquals("Correct", trueFalse.answer("true"));
  }

  @Test
  public void testRightAnswerLikert() {
    Question likert = new Likert("How do you rate your academic adviser?");
    Assert.assertEquals("Correct", likert.answer("2"));
  }

  @Test
  public void testRightAnswerMultipleChoice() {
    Question multipleChoice = new MultipleChoice("How many students are "
            + "there?", "2", "7", "1", "3", "2");
    Assert.assertEquals("Correct", multipleChoice.answer("2"));
  }

  @Test
  public void testRightAnswerMultipleSelect() {
    Question multipleSelect = new MultipleSelect("Which numbers does Peter "
            + "like?", "1 3", "4", "2", "3", "1");
    Assert.assertEquals("Correct", multipleSelect.answer("1 3"));
  }

  @Test
  public void testWrongAnswerTrue() {
    Question trueFalse = new TrueFalse("Are you a student at Northeastern University?", "true");
    Assert.assertEquals("Incorrect", trueFalse.answer("false"));
  }

  @Test
  public void testWrongAnswerLikert() {
    Question likert = new Likert("How do you rate your academic adviser?");
    Assert.assertEquals("Incorrect", likert.answer("6"));
  }

  @Test
  public void testWrongAnswerMultipleChoice() {
    Question multipleChoice = new MultipleChoice("How many students are "
            + "there?", "3", "7", "5", "3", "1");
    Assert.assertEquals("Incorrect", multipleChoice.answer("2"));
  }

  @Test
  public void testWrongAnswerMultipleSelect() {
    Question multipleSelect = new MultipleSelect("Which numbers does Peter "
            + "like?", "1 3", "4", "2", "3", "1");
    Assert.assertEquals("Incorrect", multipleSelect.answer("2"));
  }

  @Test
  public void testToStringTrue() {
    Assert.assertEquals("Are you a student at Northeastern University? "
            + "true or false.", trueFalse.toString());
  }

  @Test
  public void testToStringLikert() {
    Assert.assertEquals("Is Lebron the best basketball player? \n"
            + "1 for Strongly Agree,2 for Agree, 3 for Neither "
            + "Agree nor Disagree, 4 for Disagree, 5 for Strongly Disagree.", likert.toString());
  }

  @Test
  public void testToStringMultipleChoice() {
    Assert.assertEquals("How many students are there? "
            + "with options [1, 2, 6, 5].", multipleChoice.toString());
  }

  @Test
  public void testToStringMultipleSelect() {
    Assert.assertEquals("Which numbers does Peter like?"
            + " with options [3, 2, 7, 1].", multipleSelect.toString());
  }

  @Test
  public void testComparingIt() {
    Assert.assertEquals(-1, trueFalse.compareTo(likert));
    Assert.assertEquals(-1, trueFalse.compareTo(multipleChoice));
    Assert.assertEquals(-1, trueFalse.compareTo(multipleSelect));
  }

  @Test
  public void testQuestionOrder() {
    List<Question> questionnaire = new ArrayList<>();
    questionnaire.add(likert);
    questionnaire.add(multipleSelect);
    questionnaire.add(multipleChoice);
    questionnaire.add(trueFalse);
    Collections.sort(questionnaire);
    System.out.println("Question Order");
    System.out.println(questionnaire);
    Assert.assertEquals(4, questionnaire.size());
  }

  /**
   * Compares every possible scenario and sort correctly.
   */
  @Test
  public void testComparingSortCorrect() {
    Question trueFalse1 = new TrueFalse("Are you human?", "true");
    Question likert1 = new Likert("Is Durant the best basketball player?");
    Question multipleChoice1 = new MultipleChoice("Which number is "
            + "even?", "2", "2", "3", "5", "1");
    Question multipleSelect1 = new MultipleSelect("Which numbers are "
            + "even?", "2 4", "2", "3", "4", "1");
    List<Question> questionnaire = new ArrayList<>();
    questionnaire.add(likert);
    questionnaire.add(multipleChoice);
    questionnaire.add(trueFalse);
    questionnaire.add(multipleSelect);
    questionnaire.add(trueFalse1);
    questionnaire.add(likert1);
    questionnaire.add(multipleChoice1);
    questionnaire.add(multipleSelect1);
    Collections.sort(questionnaire);
    System.out.println("Comparing");
    System.out.println(questionnaire);
    Assert.assertEquals(8, questionnaire.size());
  }

}