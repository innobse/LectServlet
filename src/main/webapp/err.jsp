<%@ page import="LectServlet.Const" %><%--
  Created by IntelliJ IDEA.
  User: bse71
  Date: 22.02.2017
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <h1>Упс! Пинцет случился...</h1>

  <%= request.getParameter(Const.REQ_ERROR) %>
  <br>
  <a href="/">В начало</a>

  </body>
</html>
