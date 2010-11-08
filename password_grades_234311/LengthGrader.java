package password_grades_234311; //TODO should be with . instead of _!

import java.lang.Math;

/**
 * A grader that grades a password according to its length.
 * @author Abigail
 */
public class LengthGrader implements PasswordGrader {
 
  static final int CHARS_TO_CONSIDER = 8; // the number of characters to consider
  
  /**
   * @param password the password to be graded
   * @return a grade (0-100) according to the password's length
   * @see password_grades_234311.PasswordGrader#grade(java.lang.String)
   */
  @Override
  public int grade(String password) {
    
    // Illegal password
    if (password == null) {
      return 0;
    }
    
    int consideredLength = Math.min(CHARS_TO_CONSIDER, password.length());
    return ((100 * consideredLength) / CHARS_TO_CONSIDER);
  }

  /**
   * @return the name of the grader (the parameter it checks)
   * @see password_grades_234311.PasswordGrader#name()
   */
  @Override
  public String name() { //TODO should be getName!
    return "Length";
  }

}
