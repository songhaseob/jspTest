<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	첫번째숫자 -> <%=session.getAttribute("gob1") %><br>
	두번째숫자 -> <%=session.getAttribute("gob2") %><br>
	결과값 -> <%=session.getAttribute("result") %>
	
</body>
</html>