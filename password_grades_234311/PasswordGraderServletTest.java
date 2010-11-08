package password_grades_234311;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpException;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;


/**
 * Unit tests for PasswordTotalGrader.
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */
public class PasswordGraderServletTest extends TestCase {
  ServletRunner sr;
  ServletUnitClient sc;
  WebRequest req;
  WebResponse res;

  @Before
  public void setUp() {
    sr = new ServletRunner();
    sr.registerServlet("grade.jsp", PasswordGraderServlet.class.getName());
    sc = sr.newClient();
    req = new PostMethodWebRequest("http://web.com/grade.jsp");
  }

  @Test
  public void testDoesntAcceptGetRequests() {
    req = new GetMethodWebRequest("http://web.com/grade.jsp");
    try {
      res = sc.getResponse(req);
    } catch (HttpException e) {
      assertEquals(HttpServletResponse.SC_METHOD_NOT_ALLOWED,
          e.getResponseCode());
      return;
    } catch (Exception e) {
      fail(e.getMessage());
    }
    fail("Server should not accept GET requests");
  }

  @Test
  public void testDoesntAcceptPostRequestsMissingPassword() {
    try {
      res = sc.getResponse(req);
    } catch (HttpException e) {
      assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
          e.getResponseCode());
      return;
    } catch (Exception e) {
      fail(e.getMessage());
    }
    fail("Server should not accept POST requests missing a password parameter");
  }

  @Test
  public void testAcceptsProperRequests() {
    req.setParameter(PasswordGraderServlet.PASSWORD, "1");
    try {
      res = sc.getResponse(req);
    } catch (Exception e) {
      fail(e.getMessage());
    }
    assertEquals(HttpServletResponse.SC_OK, res.getResponseCode());
  }

  /**
   * @see StubGrader.
   */
  @Test
  public void testGradesProperly() {
    PasswordGraderServlet servlet = new PasswordGraderServlet(
        new StubGrader());
    req.setParameter(PasswordGraderServlet.PASSWORD, "0-2t-2+u 4hv24h%gv45");
    try {
      res = sc.getResponse(req);
    } catch (Exception e) {
      fail(e.getMessage());
    }
    try {
      assertEquals("0", res.getElementWithID("grade").getText());
    } catch (Exception e) {
      fail(e.getMessage());
    }
    req.setParameter(PasswordGraderServlet.PASSWORD, "magic");
    try {
      res = sc.getResponse(req);
    } catch (Exception e) {
      fail(e.getMessage());
    }
    try {
      assertEquals("42", res.getElementWithID("grade").getText());
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  private class StubGrader implements PasswordTotalGraderInterface {
    public int grade(String password) {
      if (password.equals("magic")) {
        return 42;
      }
      else {
        return 0;
      }
    }
  }
}
