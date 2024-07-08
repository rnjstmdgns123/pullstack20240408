<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="frontproject.vo.SampleTBVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
	//SampleTBVO svo = (SampleTBVO)request.getAttribute("svo");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sampleTB 상세페이지!</h2>
	<table>
		<thead>
			<tr>
				<th align="right">글제목:</th>
				<td>${svo.title}</td>
			</tr>
			<tr>
				<th align="right">작성자:</th>
				<td>${svo.writer}</td>
			</tr>
			<tr>
				<th align="right">작성일:</th>
				<td>${svo.rdate}</td>
			</tr>
			<tr>
				<th align="right">내용:</th>
				<td>${svo.body}</td>
			</tr>
		</thead>
	</table>
	<button onclick="location.href='modify.do?sno=${svo.sno}'">수정</button>
	<button onclick="location.href='list.do'">목록</button>
</body>
</html>