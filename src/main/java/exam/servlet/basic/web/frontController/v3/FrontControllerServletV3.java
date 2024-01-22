package exam.servlet.basic.web.frontController.v3;

import exam.servlet.basic.web.frontController.ModelView;
import exam.servlet.basic.web.frontController.MyView;
import exam.servlet.basic.web.frontController.v3.controller.MemberFormControllerV3;
import exam.servlet.basic.web.frontController.v3.controller.MemberListControllerV3;
import exam.servlet.basic.web.frontController.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

  /*
  * String : URL
  *   - 어떤 URL이 호출되면 ControllerV1을 호출해 ~
  * */
  private Map<String, ControllerV3> controllerMap = new HashMap<>();

  /*
  * 서블릿이 생성될 때 매핑정보를 미리 담아둠
  *  */
  public FrontControllerServletV3() {
    controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
    controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
    controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 브라우저의 URI를 가져오는 객체
    String requestURI = req.getRequestURI();

   /*
    * 서블릿이 생성될 때 미리 담아둔 컨트롤러를 URI를 통해 가지고 온다.
    * Controller를 interface로 상속받았기 때문에 가능. (부모는 자식을 담을 수 있다.)
    */
    ControllerV3 controller = controllerMap.get(requestURI);

    if(controller == null) {
      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    Map<String, String> paramMap = new HashMap<>();

    req.getParameterNames().asIterator()
            .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));


    ModelView mv = controller.process(paramMap);
    /*
    * 부모의 interface를 상속받은 하위 컨트롤러 클래스들의 @Override된 process() 메서드가 호출된다.
    * */

  }
}
