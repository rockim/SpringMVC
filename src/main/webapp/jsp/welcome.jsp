<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: rockim
  Date: 2020/05/20
  Time: 3:40 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<body>
<table>
    <tr>
        <td>Welcome ${firstname}</td>
    </tr>
    <tr>
    </tr>
    <tr>
    </tr>
    <tr>
        <td><a href="/SpringMVC_war_exploded/home.jsp">Home</a>
        </td>
        <td><a href="board">Board</a>
        </td>
    </tr>
</table>
</body>
</html>