package password_grades_234311;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for LengthGrader
 * @author Abigail
 */
public class LengthGraderTest {

  private static LengthGrader lengthGrader = new LengthGrader();
  
  /**
   * Tests the method grade on null
   */
  @Test
  public void testGradeNull() {
    assertEquals(lengthGrader.grade(null), 0);
  }
  
  /**
   * Tests the method grade on an empty password
   */
  @Test
  public void testGradeEmpty() {
    assertEquals(lengthGrader.grade(""), 0);
  }
  
  /**
   * Tests the method grade on a short password
   */
  @Test
  public void testGradeShortPassword() {
    assertEquals(lengthGrader.grade("abc"), 37);
  }
  
  /**
   * Tests the method grade on a password in the maximal considered length
   */
  @Test
  public void testGradeMaxConsideredLength() {
    assertEquals(lengthGrader.grade("abcd1234"), 100);
  }
  
  /**
   * Tests the method grade on a password longer than
   * the maximal considered length
   */
  @Test
  public void testGradeLongerThanMaxConsideredLength() {
    assertEquals(lengthGrader.grade("abcd123412212112142134234"), 100);
  }
  
}
