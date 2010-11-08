package password_grades_234311;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for PasswordTotalGrader.
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */
public class PasswordTotalGraderTest extends TestCase {
  private PasswordTotalGrader ptg;
  // (12 + 15 + 63) / 3 = 30.
  private PTestGrader pg1 = new PTestGrader(12);
  private PTestGrader pg2 = new PTestGrader(15);
  private PTestGrader pg3 = new PTestGrader(63);
  
  @Before
  public void setUp() {
    pg1.clear();
    pg2.clear();
    pg3.clear();
    ptg = new PasswordTotalGrader(pg1, pg2, pg3);
  }

  @Test
  public void testGraderChecksAllGradersExactlyOnce() {
    ptg.grade("A Password");
    assertEquals(1, pg1.getCount());
    assertEquals(1, pg2.getCount());
    assertEquals(1, pg3.getCount());
  }

  @Test
  public void testGraderCalculatesAverageOfGraderResponses() {
    assertEquals(30, ptg.grade("Anything"));
  }

  @Test
  public void testGradersAreCalledWithSamePassword() {
    String s = " aAz_12!@#{}\\\"";
    ptg.grade(s);
    assertEquals(s, pg1.getLastParameter());
    assertEquals(s, pg2.getLastParameter());
    assertEquals(s, pg3.getLastParameter());
  }

  /**
   * Helper class for testing.
   * Implements counting how many times grade() was called, and caching the last
   * parameter of grade().
   */
  private class PTestGrader implements PasswordGrader {
    private int count;
    private int fake;
    private String lastParameter;
    
    // Instance initializer.
    {
      count = 0;
      lastParameter = null;
    }

    public PTestGrader(int fake) {
      this.fake = fake;
    }

    public int getCount() {
      return count;
    }
    public String getLastParameter() {
      return lastParameter;
    }
    public void clear() {
      count = 0;
    }
    public int grade(String password) {
      count++;
      lastParameter = password;
      return fake;
    }
    public String name() { return ""; }
  }
}
