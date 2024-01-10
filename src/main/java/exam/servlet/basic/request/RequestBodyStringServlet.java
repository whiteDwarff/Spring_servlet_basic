package exam.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="RequestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletInputStream inputStream = req.getInputStream();

    // 사용자에 의해 전송되는 데이터
    String msgBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);  // Byte 를 문자로 바꾸기 위함

    System.out.println("msgBody = " + msgBody);

    resp.getWriter().write("ok");
  }
}
