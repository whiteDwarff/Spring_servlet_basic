package exam.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import exam.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name="responseJsonServlet", urlPatterns="/response-json")
public class ResponseJsonServlet extends HttpServlet {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // json 형식으로 보내기
    resp.setContentType("application/json");
    resp.setCharacterEncoding("utf-8");

    HelloData helloData = new HelloData("kang", 28);

    // key, value 형식의 객체를 문자로 변환
    String result = objectMapper.writeValueAsString(helloData);
    resp.getWriter().write(result);

  }
}
