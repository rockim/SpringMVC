<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>게시글 작성</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btnDelete").click(function(){
                if(confirm("삭제정말로 하실건가요?")) {
                    document.form1.action = "delete";
                    document.form1.submit();
                }
            });

            $('#btnUpdate').click(function(){
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
                document.form1.action="update"
                document.form1.submit();
            });
        });
    </script>
</head>
<body>
<h2>게시글 보기</h2>
<form name ="form1" ,method = "post">
    <div>
        작성일자 : <fmt:formatDate value="${dto.regDate}" pattern="yyyy-MM-dd a HH:mm:ss"/>
    </div>
    <div>
        조회수 : ${dto.viewCnt}
    </div>
    <div>
        제목
        <input name = "title" id = title" size ="80" value="${dto.title}" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name = "content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요">
            ${dto.content}
        </textarea>
    </div>
    <div>
        이름
        <input name="writer" id="writer" value="${dto.writer}" placeholder="이름을 입력해주세요">
    </div>
    <div style="width: 650px; text-align: center;">
        <input type ="hidden" name="bno" value="${dto.bno}">

        <td><a href="update">수정</a>
            <a href="delete">삭제</a>
        </td>
    </div>
</form>

</body>
</html>
