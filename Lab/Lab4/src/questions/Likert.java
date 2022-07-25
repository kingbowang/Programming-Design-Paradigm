package questions;

/**
 * The Likert class.
 * Likert can be answered on a fixed, 5-point Likert scale.
 *
 * @author Pengbo Wang
 */
public class Likert extends AbstractQuestion {

  /**
   * The constructor of the Likert class.
   *
   * @param question The question of this object.
   */
  public Likert(String question) {
    super(question);
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
    if (!(anAnswer.trim().equals("1") | anAnswer.trim().equals("2") | anAnswer.trim().equals("3")
            | anAnswer.trim().equals("4") | anAnswer.trim().equals("5"))) {
      return INCORRECT;
    }
    return CORRECT;
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
    return a1Question.compareToLikert(this);
  }

  /**
   * Compares the question for two different Likert objects.
   *
   * @param o The Question object being compared to this object.
   * @return comparison
   */
  @Override
  public int compareToLikert(Question o) {
    return o.getText().compareTo(this.getText());
  }

  /**
   * Returns the toString.
   *
   * @return toString
   */
  @Override
  public String toString() {
    return String.format("%s \n1 for Strongly Agree,2 for Agree, "
            + "3 for Neither Agree nor Disagree, "
            + "4 for Disagree, 5 for Strongly Disagree.", question);
  }
}
