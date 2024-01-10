package exam.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import exam.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="RequestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

  // 문자열 데이터를 자바 객체로  변환하기 위한 객체
  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ServletInputStream inputStream = req.getInputStream();
    String msgBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

    System.out.println("msgBody = " + msgBody);

    // 변환된 객체를 HelloData DTO에 할당
    HelloData helloData = objectMapper.readValue(msgBody, HelloData.class);

    System.out.println("helloData.getUserName() = " + helloData.getUsername());
    System.out.println("helloData.getAge() = " + helloData.getAge());
  }
}
