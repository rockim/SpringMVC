<%--
Created by IntelliJ IDEA.
  User: rockim
  Date: 2020/05/21
  Time: 3:07 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Board List</title>
</head>
<body>
<h2>게시글 목록</h2>
<table border="1" width="600px">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내</th>
        <th>작성일</th>
        <th>작성자</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="board" items="${list}">
        <tr>
            <td>${board.bno}</td>
            <td>${board.title}</td>
            <td>${board.content}</td>
            <td>${board.regDate}</td>
            <td>${board.writer}</td>
            <td>${board.viewCnt}</td>
        </tr>
    </c:forEach>
    <tbody>

    </tbody>
</table>
</body>
</html>
