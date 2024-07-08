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
<h2>sampleTB 수정페이지!</h2>
<form action="modify.do" method="post">
<input type="hidden" name="sno" value="<%=svo.getSno()%>">
	<table>
		<tbody>
			<tr>
				<th align="right">글번호:</th>
				<td><%=svo.getSno() %></td>
			</tr>
			<tr>
				<th align="right">제목:</th>
				<td><input type="text" name="title" value="<%=svo.getTitle() %>"></td>
			</tr>
			<tr>
				<th align="right">작성자:</th>
				<td><input type="text" name="writer" value="<%=svo.getWriter() %>"></td>
			</tr>
			<tr>
				<th align="right">작성일:</th>
				<td><%=svo.getRdate() %></td>
			</tr>
			<tr>
				<th align="right">내용:</th>
				<td><textarea name="body"><%=svo.getBody() %></textarea></td>
			</tr>
		</tbody>
	</table>
	<button>저장</button>
</form>
</body>
</html>