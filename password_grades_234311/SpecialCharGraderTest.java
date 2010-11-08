package password_grades_234311;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for SpecialCharGrader
 * @author Abigail
 */
public class SpecialCharGraderTest {

  private static SpecialCharGrader specialCharGrader = new SpecialCharGrader();
  
  /**
   * Tests the method grade on null
   */
  @Test
  public void testGradeNull() {
    assertEquals(specialCharGrader.grade(null), 0);
  }
  
  /**
   * Tests the method grade on an empty password
   */
  @Test
  public void testGradeEmpty() {
    assertEquals(specialCharGrader.grade(""), 0);
  }
  
  /**
   * Tests the method grade- no special characters
   */
  @Test
  public void testGradeNoSpecialChars() {
    assertEquals(specialCharGrader.grade("abAB01"), 0);
  }
  
  /**
   * Tests the method grade- some special characters
   */
  @Test
  public void testGradeSomeSpecialChars() {
    assertEquals(specialCharGrader.grade("!@#Aa0"), 100);
  }
  
  /**
   * Tests the method grade- all special characters
   */
  @Test
  public void testGradeAllSpecialChars() {
    assertEquals(specialCharGrader.grade("!@#$%^&*()"), 100);
  }

}
