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
    <script type="text/javascript">

        $(document).ready(function () {
            $("#btnSave").click(function(){
                var title = $("#title").val();
                var content = $("#content").val();
                var writer = $("#writer").val();
                if(title == ""){
                    alert("제목을 입력하세요");
                    document.form1.title.focus();
                    return;
                }
                if(content ==""){
                    alert("내용을 입력하세요");
                    document.form1.content.focus();
                    return;
                }
                if(writer ==""){
                    alert("이름을 입력하세요");
                    document.form1.content.focus();
                    return;
                }
                document.form1.submit();
            });
        });
    </script>
</head>
<body>
<h2>게시글 보기</h2>
<form:form id ="writerForm" method = "post" action="insert">

    <div>
        제목
        <input name = "title" id = title" size ="80" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name = "content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요">
        </textarea>
    </div>
    <div>
        이름
        <input name="writer" id="writer"  placeholder="이름을 입력해주세요">
    </div>
    <div style="width: 650px; text-align: center;">
        <td><a href="insert">확인</a></td>
        <button type = "reset">취소</button>
    </div>
</form:form>
</body>
</html>