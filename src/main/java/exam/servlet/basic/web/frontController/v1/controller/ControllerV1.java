package exam.servlet.basic.web.frontController.v1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV1 {

  void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
