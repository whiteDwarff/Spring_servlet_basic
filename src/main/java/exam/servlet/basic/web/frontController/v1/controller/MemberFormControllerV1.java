package exam.servlet.basic.web.frontController.v1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
  @Override
  public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String viewPath = "/WEB-INF/views/new-form.jsp";
    RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
    dispatcher.forward(req, resp);
  }
}
