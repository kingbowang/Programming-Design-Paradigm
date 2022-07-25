package questions;

/**
 * The TrueFalse class.
 * TrueFalse can be answered in one of two ways: true or false.
 *
 * @author Pengbo Wang
 */
public class TrueFalse extends AbstractQuestion {
  private final String answer;

  /**
   * The constructor of the trueFalse class.
   *
   * @param question    The question of this object.
   * @param rightAnswer The answer to the question.
   * @throws IllegalArgumentException If the answer is empty.
   * @throws IllegalArgumentException If the answer isn't true or false.
   */
  public TrueFalse(String question, String rightAnswer) throws IllegalArgumentException {
    super(question);
    rightAnswer = rightAnswer.trim().toLowerCase();
    if (rightAnswer.isEmpty()) {
      throw new IllegalArgumentException("Didn't put in an answer");
    }
    if (!(rightAnswer.equals("true") | rightAnswer.equals("false"))) {
      throw new IllegalArgumentException("Answer has to be true or false");
    }
    answer = rightAnswer;
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
    if (anAnswer.toLowerCase().trim().equals(answer)) {
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
      throw new IllegalArgumentException("Can't be compared");
    }
    AbstractQuestion a1Question = (AbstractQuestion) o;
    return a1Question.compareToTrueFalse(this);
  }

  /**
   * Compares the question for two different TrueFalse objects.
   *
   * @param o The Question object being compared to this object.
   * @return comparison
   */
  @Override
  public int compareToTrueFalse(Question o) {
    return o.getText().compareTo(this.getText());
  }

  /**
   * Returns 1 when the method is called.
   *
   * @param o The Question object being compared to this object.
   * @return 1
   */
  @Override
  public int compareToMultipleChoice(Question o) {
    return 1;
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
    return String.format("%s true or false.", question);
  }
}
