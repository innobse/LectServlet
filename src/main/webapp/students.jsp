<%@ page import="LectServlet.db.POJO.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Spisok</title>
</head>
<body>
<h1>Список студентов</h1>

<table border="1" width=80%" align="center">
    <c:forEach items="${students}" var="student">
        <tr>
            <td width="5%" align="center">${student.getId()}</td>
            <td width="30%" align="center">${student.getName()}</td>
            <td width="5%" align="center">${student.getGroup_id()}</td>
            <td width="15%" align="center">${student.getBirthday()}</td>
            <td width="5%" align="center">${student.getSex()}</td>
            <td width="10%" align="center"><a href="/students/refactor?id=${student.getId()}">Редактировать</a></td>
            <td width="10%" align="center"><a href="/students/del?id=${student.getId()}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
