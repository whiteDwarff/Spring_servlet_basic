`HttpServletRequest`의 역할
HTTP 요청 메시지를 개발자가 직접 파싱해서 사용해도 되지만, 매우 불편하다.
서블릿은 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 개발자 대신에 HTTP 요청 메시지를 파싱한다
그리고 그 결과를 `HttpServletRequest` 객체에 담아서 제공한다.
