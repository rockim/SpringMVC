<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: rockim
  Date: 2020/05/22
  Time: 6:35 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 보기</title>
</head>
<body>
<h2>게시글 보기</h2>
<form:form id="viewForm" modelAttribute="board" method="post" action="viewProcess">
    <div>
        작성일자 : <fmt:formatDate value="${dto.regDate}" pattern="yyyy-MM-dd a HH:mm:ss"/>
    </div>
    <div>
        조회수 : ${dto.viewCnt}
    </div>
    <div>
        <form:label path="title">제목</form:label>
        <form:input path="title" name="title" id = "title" size="80" value="${dto.title}" placeholder="제목을 일렵해주세요"/>
    </div>
    <div>
        내용
        <form:label path="content">내용</form:label>
        <form:input path="content" name="content" id = "content" size="200" value="${dto.content}"/>
    </div>
    <div>
        <form:label path="writer">이름</form:label>
        <form:input path="writer" name="writer" id = "title" value="${dto.writer}" placeholder="이름을 일렵해주세요"/>
    </div>
    <div>
        <td>
            <form:hidden path="bno" value="${dto.bno}"/>
            <form:button value="update" name="update">수정</form:button>
            <form:button value="delete" name="update">삭제</form:button>
        </td>
    </div>
</form:form>


</body>
</html>
