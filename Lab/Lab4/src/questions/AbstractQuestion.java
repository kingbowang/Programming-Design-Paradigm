package questions;

/**
 * An abstract class that implements the Question class.
 *
 * @author Pengbo Wang
 */
public abstract class AbstractQuestion implements Question {
  protected final String question;

  /**
   * The constructor of the abstract class.
   *
   * @param question The question that is inputted.
   * @throws IllegalArgumentException If the question is empty.
   */
  public AbstractQuestion(String question) throws IllegalArgumentException {
    if (question.trim().isEmpty()) {
      throw new IllegalArgumentException("Didn't put in a question");
    }
    this.question = question;
  }

  /**
   * Returns the question.
   *
   * @return question
   */
  @Override
  public String getText() {
    return question;
  }

  /**
   * Returns -1 when called.
   *
   * @param o The question object.
   * @return -1
   */
  public int compareToTrueFalse(Question o) {
    return -1;
  }

  /**
   * Returns -1 when called.
   *
   * @param o The question object.
   * @return -1
   */
  public int compareToMultipleChoice(Question o) {
    return -1;
  }

  /**
   * Returns -1 when called.
   *
   * @param o The question object.
   * @return -1
   */
  public int compareToMultipleSelect(Question o) {
    return -1;
  }

  /**
   * Returns 1 when called.
   *
   * @param o The question object.
   * @return 1
   */
  public int compareToLikert(Question o) {
    return 1;
  }
}
