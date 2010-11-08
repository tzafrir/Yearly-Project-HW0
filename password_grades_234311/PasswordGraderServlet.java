package password_grades_234311;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class PasswordGraderServlet extends HttpServlet {
  public static final String SCORE = "score";
  public static final String PASSWORD = "password";

  private PasswordTotalGraderInterface ptg;

  public PasswordGraderServlet() {
    ptg = new PasswordTotalGrader();
  }

  /**
   * Testing constructor.
   */
  public PasswordGraderServlet(PasswordTotalGraderInterface ptgi) {
    ptg = ptgi;
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException {
    if (req.getParameter(PASSWORD) == null) {
      throw new ServletException("Missing parameter: '" + PASSWORD + "'");
    }
    int grade = ptg.grade(req.getParameter(PASSWORD));
    req.setAttribute(SCORE, grade);
    try {
      getServletConfig().getServletContext().getRequestDispatcher(
          "/grader_page.jsp").forward(req, res);
    } catch (IOException e) {
      throw new ServletException(e.getMessage());
    }
  }
}
