## `HttpServletRequest` 의 역할 <br>


HTTP 요청 메시지를 개발자가 직접 파싱해서 사용해도 되지만, 매우 불편하다. <br>
서블릿은 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 개발자 대신에 HTTP 요청 메시지를 파싱한다. <br>
그리고 그 결과를 `HttpServletRequest` 객체에 담아서 제공한다. <br><br>

`HttpServletRequest` 를 사용하면 음과 같은 HTTP 요청 메시지를 편리하게 조회할 수 있다. <br><br>

>*HTTP 요청 메시지*
```ruby
 POST /save HTTP/1.1
 Host: localhost:8080
 Content-Type: application/x-www-form-urlencoded

 username=kim&age=20
```
<br>

- START LINE
  - HTTP 메서드
  - URL
  - 쿼리 스트링 스키마, 프로토콜
- 헤더
  - 헤더 조회
- 바디
  - form 파라미터 형식 조회
  - message body 데이터 직접 조회

<br>

>*HttpServletRequest 객체는 추가로 여러가지 부가기능도 함께 제공한다.* 
<br>

 임시 저장소 기능
  ```
  저장: request.setAttribute(name, value)
  조회: request.getAttribute(name)
  ```
  세션 관리 기능
  ```
   request.getSession(create: true)
  ```

<hr>

## HTTP 요청 데이터 - 개요 <br>
HTTP 요청 메시지를 통해 클라이언트에서 서버로 데이터를 전달하는 방법

`GET` - 쿼리 파마미터
 ```
/url?username=hello&age=20
메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달

예) 검색, 필터, 페이징등에서 많이 사용하는 방식
```

`POST` - HTML Form**
```
content-type: application/x-www-form-urlencoded
메시지 바디에 쿼리 파리미터 형식으로 전달 username=hello&age=20

예) 회원 가입, 상품 주문, HTML Form 사용
```

`HTTP message body`에  데이터를 직접 담아서 요청
```
HTTP API에서 주로 사용, JSON, XML, TEXT
데이터 형식은 주로 JSON 사용 POST, PUT, PATCH
```


