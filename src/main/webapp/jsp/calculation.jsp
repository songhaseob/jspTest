<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="plus">
	<h1>더하기</h1>
		<form action="<%=request.getContextPath() %>/sumCalculation" method="POST" >
			<input type="text" name="start" placeholder="숫자만 입력하세요">&nbsp;~
			<input type="text" name="end" placeholder="숫자만 입력하세요">
			<input type="submit" value="정답은??">
		</form>
</div>
<h1>곱하기</h1>
<form action="<%=request.getContextPath() %>/mulcalculation" method="POST" >
	<input type="text" name="gob1" placeholder="숫자만 입력하세요">&nbsp;*
	<input type="text" name="gob2" placeholder="숫자만 입력하세요">
	<input type="submit" value="정답은??">
</form>
</body>
</html>