package password_grades_234311; //TODO should be with . instead of _ !

/**
 * A grader that checks whether or not the password has special characters
 * (not a letter or a digit).
 * @author Abigail
 */
public class SpecialCharGrader implements PasswordGrader {

  /**
   * @param password the password to be graded
   * @return 100 if a given password has special characters (see above), 0 if not
   * @see password_grades_234311.PasswordGrader#grade(java.lang.String)
   */
  @Override
  public int grade(String password) {
    
    // Illegal password
    if (password == null) {
      return 0;
    }
    
    for (int i = 0; i < password.length(); ++i) {
      char current = password.charAt(i);
      
      // If it's not a character or a digit- it's a special character 
      if (!((current >= 'a' && current <= 'z') ||
           (current >= 'A' && current <= 'Z') ||
           (current >= '0' && current <= '9'))) {
        return 100;
      }
    }
    
    return 0;
  }

  /**
   * @return the name of the grader (the parameter it checks)
   * @see password_grades_234311.PasswordGrader#name()
   */
  @Override
  public String name() { //TODO should be getName!
    return "Special Charachters";
  }

}
