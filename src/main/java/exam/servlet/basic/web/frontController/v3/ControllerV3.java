package exam.servlet.basic.web.frontController.v3;

import exam.servlet.basic.web.frontController.ModelView;

import java.util.Map;

public interface ControllerV3 {

  ModelView process(Map<String, String> paramMap);
}
