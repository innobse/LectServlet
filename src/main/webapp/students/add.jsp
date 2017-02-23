<%--
  Created by IntelliJ IDEA.
  User: bse71
  Date: 23.02.2017
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавляем нового студента</title>
</head>
<body>
<h1>Добавляем нового студента</h1>
<div>
    <form action="/students/add" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name"} value="" placeholder="Input"><br />
        <label for="group_id">Group ID:</label>
        <input type="text" name="group_id" id="group_id" value="" placeholder="Input"><br />
        <p>Sex</p>
            <input type="radio" name="sex" value="m"> male<br />
            <input type="radio" name="sex" value="f"> female<br />
        <br />
        <label for="birthday">Birthday:</label>
        <input type="date" name="birthday" id="birthday" value="" placeholder="Input"><br />
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
