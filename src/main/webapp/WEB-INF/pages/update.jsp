<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GEORGY
  Date: 21.05.2020
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update" method="post">
    <input type="hidden" name="id" value="${user.id}">
    Name:
    <input name="name" value="${user.name}">
    Password:
    <input name="password" value="${user.password}">
    Role:
    <input name="role" value="${user.role}">
    Age:
    <input name="age" value="${user.age}">
    <input type="submit">
</form>
</body>
</html>
