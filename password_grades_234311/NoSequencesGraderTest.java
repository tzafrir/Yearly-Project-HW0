package password_grades_234311;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * unit tests for NoSequencesGrader
 * @author Eran_Z
 *
 */
public class NoSequencesGraderTest {
  private static NoSequencesGrader noSequencesGrader = new NoSequencesGrader();
  
  /**
   * Tests the method grade on null
   */
  @Test
  public void testGradeNull() {
    assertEquals(noSequencesGrader.grade(null), 0);
  }
  
  /**
   * Tests the method grade on an empty password
   */
  @Test
  public void testGradeEmpty() {
    assertEquals(noSequencesGrader.grade(""), 100);
  }
  
  /**
   * Tests the method grade on a short password
   */
  @Test
  public void testGradeShortPassword() {
    assertEquals(noSequencesGrader.grade("ab"), 100);
  }
  
  /**
   * Tests the method grade on a just-long-enough password, that's a sequence
   */
  @Test
  public void testGradeJustLongEnoughSequence() {
    assertEquals(noSequencesGrader.grade("abc"), 0);
  }
  
  /**
   * Tests the method grade on a just-long-enough password, that's a backward sequence
   */
  @Test
  public void testGradeJustLongEnoughBackwardSequence() {
    assertEquals(noSequencesGrader.grade("DCB"), 0);
  }
  
  /**
   * Tests the method grade on a just-long-enough password, that's not a sequence
   */
  @Test
  public void testGradeJustLongEnoughNoSequence() {
    assertEquals(noSequencesGrader.grade("ace"), 100);
  }
  
  /**
   * Tests the method grade on a password with a sequence
   */
  @Test
  public void testGradeWithSequence() {
    assertEquals(noSequencesGrader.grade("v23!efg0"), 5*100/6);
  }
  
  /**
   * Tests the method grade on a password with multiple sequences
   */
  @Test
  public void testGradeWithMultipleSequences() {
    assertEquals(noSequencesGrader.grade("abc4gfe~"), 4*100/6);
  }
  
  /**
   * Tests the method grade on a password with a long sequence
   */
  @Test
  public void testGradeWithLongSequence() {
    assertEquals(noSequencesGrader.grade("AAAabcde666"), 6*100/9);
  }
  
  /**
   * Tests the method grade on a password which is a sequence
   */
  @Test
  public void testGradeOnASequence() {
    assertEquals(noSequencesGrader.grade("987654321"), 0);
  }
  
  
}
