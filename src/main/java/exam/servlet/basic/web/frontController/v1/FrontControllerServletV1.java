package exam.servlet.basic.web.frontController.v1;

import exam.servlet.basic.web.frontController.v1.controller.MemberFormControllerV1;
import exam.servlet.basic.web.frontController.v1.controller.MemberListControllerV1;
import exam.servlet.basic.web.frontController.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

  /*
  * String : URL
  *   - 어떤 URL이 호출되면 ControllerV1을 호출해 ~
  * */
  private Map<String, ControllerV1> controllerMap = new HashMap<>();

  /*
  * 서블릿이 생성될 때 매핑정보를 미리 담아둠
  *  */
  public FrontControllerServletV1() {
    controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
    controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
    controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("FrontControllerServletV1.service");

    // 브라우저의 URI를 가져오는 객체
    String requestURI = req.getRequestURI();

   /*
    * 서블릿이 생성될 때 미리 담아둔 컨트롤러를 URI를 통해 가지고 온다.
    * Controller를 interface로 상속받았기 때문에 가능. (부모는 자식을 담을 수 있다.)
    */
    ControllerV1 controller = controllerMap.get(requestURI);

    if(controller == null) {
      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    /*
    * 부모의 interface를 상속받은 하위 컨트롤러 클래스들의 @Override된 process() 메서드가 호출된다.
    * */
    controller.process(req, resp);
  }
}
