<%@ page import="LectServlet.db.POJO.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Spisok</title>
</head>
<body>
<h1>Хм... Чего же я хочу...</h1>

<ul type="square">
    <a href="/students">Хочу список студентов</a>
    <a href="/students/add">Хочу добавить студента</a>
    <a href="/students/refactor">Хочу отредактировать студента</a>
    <a href="/students/del">Хочу удалить студента</a>
</ul>
</body>
</html>
