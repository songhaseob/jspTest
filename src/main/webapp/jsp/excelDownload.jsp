<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Content-Disposition header : 파일다운로드, 업로드 시 사용하는 파일과 관련된 헤더
	response.setHeader("Content-Disposition", "attachement; filename=excel.xls");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>excelDownload</title>
<style>
	table{
		background: yellow;
			}
</style>
</head>
<body>
	<table border='1'>
	
		<tr>
			<th>userid</th>
			<th>이름</th>
		</tr>
		
		<tr>
			<td>brown</td>
			<td>브라운</td>
		</tr>
		
		<tr>
			<td>sally</td>
			<td>셀리</td>
		</tr>
		
		<tr>
			<td>cony</td>
			<td>코니</td>
		</tr>
				
	</table>
</body>
</html>