package exam.servlet.basic.web.servletMVC;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns="/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    /*
    * WEB-INF 내부의 자원은 외부에서 접근할 수 없다.
    * 컨트롤러를 통해 접근 가능하다.
    * */
    String viewPath = "/WEB-INF/views/new-form.jsp";
    RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
    /*
    * 다른 서블릿이나 JSP로 이동할 수 있는 기능. 서버 내부에서 다시 호출이 발생
    * redirect는 실제 클라이언트에 응답이 나갔다가, 클라이언트가 redirect 경로로 다시 요청한다.
    * 따라서 클라이언트가 인지할 수 있고, URL 경로도 실제로 변경된다.
    * forward는 서버 내부에서 일어나는 호출이기 때문에 클라이언트가 전혀 인지할 수 없다.
    */
    dispatcher.forward(req, resp);
  }
}
