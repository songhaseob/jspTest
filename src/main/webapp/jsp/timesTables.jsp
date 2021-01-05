<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ %> : 지시자-jsp페이지에 대한 설정정보 --%>
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
	<table border='1'>
	
	<% for(int i = 1; i <= 9; i++) {
	out.write("<tr>");
	 for(int j= 2; j <= 9; j++) {
	out.write("<td>");
	out.write( j + " * " + i + " = " + i * j);
	out.write("</td>");
	 }
	} %>
	</table>
</body>
</html>

