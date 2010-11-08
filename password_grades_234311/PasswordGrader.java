package password_grades_234311;

/**
 * Interface declare basic functionality of password grader
 * @author szvulon
 */
public interface PasswordGrader {
	
  /**
   * Evaluates strength of provided password.
   * @param password to evaluate.
   * @return integer  from 0 to 99, when 0 is weakest password
   */
  int grade( String password );
	
  /**
	 * Description name of grader.
	 * @return Name of grader.
	 */
  String name ();
}
