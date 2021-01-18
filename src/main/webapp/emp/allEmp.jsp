<%@page import="kr.or.ddit.user.model.EmpVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Main</title>

<style>
	table{
		text-align: center;
	}
	.th{
		text-align: center;
	}
</style>
<!-- Bootstrap core CSS -->
<%@include file="/common/common_lib.jsp"%>
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">
</head>

<body>
	<!-- header -->
	<%@include file="/common/header.jsp"%>
	
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
			<!-- left -->
			<%@include file="/common/left.jsp"%>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="blog-header">
					
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
						<h1>직원현황</h1>
						<br>
							<table class="table table-striped">
								<tr>
									<th class="th">empno</th>
									<th class="th">ename</th>
									<th class="th">job</th>
									<th class="th">mgr</th>
									<th class="th">hiredate</th>
									<th class="th">sal</th>
									<th class="th">comm</th>
									<th class="th">deptno</th>
								</tr>
								<% 
								List<EmpVo> list = (List<EmpVo>)request.getAttribute("list");
								for(int i = 0; i<list.size(); i++){
										EmpVo vo = list.get(i);
								%>
								<tr>
									<td><%=vo.getEMPNO() %></td>
									<td><%=vo.getENAME() %></td>
									<td><%=vo.getJOB() %></td>
									<td><%=vo.getMGR() %></td>
									<td><%=vo.getHIREDATE() %></td>
									<td><%=vo.getSAL() %></td>
									<td><%=vo.getCOMM() %></td>
									<td><%=vo.getDEPTNO() %></td>
								</tr>
							<%
									}
							%>
						</table>
					<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>