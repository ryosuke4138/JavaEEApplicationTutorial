<%@ page import="java.util.Date" %>
<%--
  Created by Ryosuke Okamae on 2020/01/26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web App Tutorial Page</title>
</head>
<body>
<h1>Hello World</h1>
<p>Body text. This is my first webapp.</p>
<a href="/login.jsp">Login Page</a>

<%
    Date date = new Date();
    out.print("<h2>" + date.toString() + "</h2>");
%>
</body>
</html>
