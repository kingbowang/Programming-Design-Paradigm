package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * The MultipleChoice class.
 * MultipleChoice offers several options, only one of which is correct.
 *
 * @author Pengbo Wang
 */
public class MultipleChoice extends AbstractQuestion {
  private final String answer;
  private final List<String> options;

  /**
   * The constructor of the MultipleChoice class.
   *
   * @param question    The question of this object.
   * @param rightAnswer The answer to the question.
   * @param allOptions  All the options choices.
   * @throws IllegalArgumentException If the answer is empty.
   * @throws IllegalArgumentException If there aren't enough options.
   * @throws IllegalArgumentException If there are too many options.
   * @throws IllegalArgumentException If the answer is not in the option.
   * @throws IllegalArgumentException One of the option is empty.
   */
  public MultipleChoice(String question, String rightAnswer, String... allOptions)
          throws IllegalArgumentException {
    super(question);
    if (rightAnswer.trim().isEmpty()) {
      throw new IllegalArgumentException("Didn't put in an answer");
    }
    if (allOptions.length < 3) {
      throw new IllegalArgumentException("Didn't put in enough options, at least 3");
    }
    if (allOptions.length > 8) {
      throw new IllegalArgumentException("Put in too much options, at most 8");
    }
    rightAnswer = rightAnswer.trim().toLowerCase();
    options = new ArrayList<>();
    boolean badOptions = false;
    for (String i : allOptions) {
      if (i.trim().isEmpty()) {
        badOptions = true;
      }
      options.add(i.trim().toLowerCase());
    }
    answer = rightAnswer;
    if (Integer.parseInt(answer) > options.size() | Integer.parseInt(answer) < 0) {
      throw new IllegalArgumentException("The right answer isn't one of the options");
    }
    if (badOptions) {
      throw new IllegalArgumentException("One of the options is empty");
    }
  }

  /**
   * Checks if the guessed answer is the right answer.
   *
   * @param anAnswer Guessed answer.
   * @return Correct or incorrect when applicable.
   * @throws IllegalArgumentException If the answer is empty.
   */
  @Override
  public String answer(String anAnswer) {
    if (anAnswer.toLowerCase().trim().isEmpty()) {
      throw new IllegalArgumentException("You need to put in an answer");
    }
    if (anAnswer.trim().equalsIgnoreCase(answer)) {
      return CORRECT;
    }
    return INCORRECT;
  }

  /**
   * Compares two different Question objects.
   *
   * @param o The Question object being compared to this object.
   * @return comparison
   * @throws IllegalArgumentException If the object doesn't extend AbstractQuestion.
   */
  @Override
  public int compareTo(Question o) {
    if (!(o instanceof AbstractQuestion)) {
      throw new IllegalArgumentException("Can not be compared");
    }
    AbstractQuestion a1Question = (AbstractQuestion) o;
    return a1Question.compareToMultipleChoice(this);
  }

  /**
   * Compares the question for two different MultipleChoice objects.
   *
   * @param o The Question object being compared to this object.
   * @return comparison
   */
  @Override
  public int compareToMultipleChoice(Question o) {
    return o.getText().compareTo(this.getText());
  }

  /**
   * Returns 1 when the method is called.
   *
   * @param o The Question object being compared to this object.
   * @return 1
   */
  @Override
  public int compareToMultipleSelect(Question o) {
    return 1;
  }

  /**
   * Returns the toString.
   *
   * @return toString
   */
  @Override
  public String toString() {
    return String.format("%s with options %s.", question, options);
  }
}