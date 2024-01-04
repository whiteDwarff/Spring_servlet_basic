## `HttpServletRequest` 의 역할 <br>

HTTP 요청 메시지를 개발자가 직접 파싱해서 사용해도 되지만, 매우 불편하다. <br>
서블릿은 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 개발자 대신에 HTTP 요청 메시지를 파싱한다. <br>
그리고 그 결과를 `HttpServletRequest` 객체에 담아서 제공한다. <br><br>

`HttpServletRequest` 를 사용하면 음과 같은 HTTP 요청 메시지를 편리하게 조회할 수 있다. <br><br>

## HTTP 요청 메시지
```
 POST /save HTTP/1.1
 Host: localhost:8080
 Content-Type: application/x-www-form-urlencoded

 username=kim&age=20
```


<hr>
