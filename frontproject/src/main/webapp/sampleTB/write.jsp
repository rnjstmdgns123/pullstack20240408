<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="frontproject.vo.SampleTBVO" %>  
<%
	SampleTBVO svo = (SampleTBVO)request.getAttribute("svo");
	String msg = request.getParameter("msg");
	if(msg  != null){
		if(msg.equals("fail")){
	%>
	<script>
		alert("수정에 실패했습니다.");
	</script>
	<%
		}
	}
			
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>sampleTB 등록페이지!</h2>
<form action="write.do" method="post">
	<table>
		<tbody>
			<tr>
				<th align="right">제목:</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th align="right">작성자:</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th align="right">내용:</th>
				<td><textarea name="body"></textarea></td>
			</tr>
		</tbody>
	</table>
	<button>저장</button>
	<button onclick="location.href='list.do'">취소</button>
</form>
</body>
</html>