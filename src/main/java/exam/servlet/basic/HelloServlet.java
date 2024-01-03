package exam.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


// name : 서블릿 이름, urlPatterns : url
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("HelloServlet.service");

    System.out.println("request = " + request);
    System.out.println("response = " + response);

    String username = request.getParameter("user");
    System.out.println("username = " + username);

    response.setContentType("text/plain");   // 단순 문자열
    response.setCharacterEncoding("utf-8");  // 인코딩
    response.getWriter().write("hello " + username );  // write() : http message body에 메시지가 들어감
  }
}
