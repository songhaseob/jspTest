<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ %> : 지시자-jsp페이지에 대한 설정정보 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		background: yellow;
		text-align: center;	
		width: 100%;
		border: 1px solid black;
		
	}
	
</style>
</head>
<body>
	<h1>구구단</h1>
	<table border='1'>

		<c:forEach begin="1" end="9" var="i">
			<tr>
				<c:forEach begin="2" end="9" var="j">
					<td>${j}*${i}=${i*j}</td>

				</c:forEach>
			</tr>
		</c:forEach>

	</table>
</body>
</html>

