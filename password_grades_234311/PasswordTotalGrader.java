package password_grades_234311;

import java.util.Arrays;
import java.util.List;

/**
 * Workmaster class that runs all instances of PasswordGrader.
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */
public class PasswordTotalGrader {
  List<PasswordGrader> graders;

  /**
   * Default constructor that uses the production graders.
   */
  public PasswordTotalGrader() {
    this(new LengthGrader(),
         new NoSequencesGrader(),
         new SpecialCharGrader());
  }

  /**
   * Testing constructor.
   * @param graders The concrete graders to be used when grading a password.
   */
  public PasswordTotalGrader(PasswordGrader... graders) {
    this.graders = Arrays.asList(graders);
  }

  /**
   * Checks the strength of the given password.
   * @param password The password to be graded.
   * @return A grade between 0 and 100 of how strong the password is.
   */
  public int grade(String password) {
    int result = 0;
    for (PasswordGrader grader : graders) {
      result += grader.grade(password);
    }
    result = result / graders.size();
    return result;
  }
}
