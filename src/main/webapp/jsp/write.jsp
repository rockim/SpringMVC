<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: rockim
  Date: 2020/05/22
  Time: 6:50 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
<h2>게시글 작</h2>
<form:form id ="writerForm" modelAttribute="board" method = "post" action="writeProcess">

    <div>
        <form:label path="title">제목</form:label>
        <form:input path="title" name="title" id = "title" size="80"/>
    </div>
    <div>
        <form:label path="content">내용</form:label>
        <form:textarea path="content" name="content" id = "content" rows="4" cols="80"/>
        </textarea>
    </div>
    <div>
        <form:label path="writer">이름</form:label>
        <form:input path="writer" name="write" id="write"/>
    </div>
    <div>
        <form:button value="write" name="write">확인</form:button>
        <a href="board">취소</a>
    </div>
</form:form>
</body>
</html>