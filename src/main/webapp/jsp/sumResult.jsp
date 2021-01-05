<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	start : <%=session.getAttribute("start") %><br>
	end : <%=session.getAttribute("end") %><br>
	result : <%=session.getAttribute("result") %>
	
</body>
</html>