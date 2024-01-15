<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="exam.servlet.basic.domain.member.Member" %>
<%@ page import="exam.servlet.basic.domain.member.MemberRepository" %>

<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
     <title>Title</title>
 </head>
<body>
    <h1>성공</h1>
    <ul>
        <li>id = <%= member.getId() %></li>
        <li>id = <%= member.getUsername() %></li>
        <li>id = <%= member.getAge() %></li>
    </ul>
    <a href="/index.html">메인</a>
</body>
</html>