package password_grades_234311;

/**
 * @author Eran_Z Grader that checks whether or not there are any sequences in
 *         the password
 */
public class NoSequencesGrader implements PasswordGrader {

  /**
   * grades the given password, between 0 and 100.
   * 
   * @param password
   *          the password to be graded
   * @return the calculated grade 
   * @see password_grades_234311.PasswordGrader#grade(java.lang.String)
   */
  @Override
  public int grade(String password) {
    if (null == password) {
      // illegal password
      return 0;
    }
    if (password.length() < 3) {
      // password too short to have any sequences
      return 100;
    }

    // count letters belonging to a sequence (other than the first and last):
    int numberOfCharsInSequences = 0;
    for (int i = 1; i < password.length() - 1; ++i) {
      char prevChar = password.charAt(i - 1);
      char currChar = password.charAt(i);
      char nextChar = password.charAt(i + 1);
      
      // if the current character is part of a forward sequence
      if ((currChar - prevChar == 1 && nextChar - currChar == 1) ||
          // or of a backward sequence
          (currChar - prevChar == -1 && nextChar - currChar == -1)) {
        // then add 1 to the counter
        ++numberOfCharsInSequences;
      }
    }

    int passwordInnerPartLength = password.length() - 2;
    return ((passwordInnerPartLength - numberOfCharsInSequences) * 100 / passwordInnerPartLength);
  }

  /**
   * @return the name of the current grader
   * 
   * @see password_grades_234311.PasswordGrader#name()
   */
  @Override
  public String name() {
    return "No Sequences";
  }

}
