<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
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
<link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
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
							<h1>사용자현황</h1>
							<br>
							<table class="table table-striped">
								<tr>
									<th class="th">아이디</th>
									<th class="th">이름</th>
									<th class="th">별명</th>
									<th class="th">날짜</th>
								</tr>
								<% 
								List<UserVo> list = (List<UserVo>)request.getAttribute("list");
								
								
								
								for(int i = 0; i<list.size(); i++){
										UserVo vo = list.get(i);
								%>
								<tr>
									<td><%=vo.getUserid() %></td>
									<td><%=vo.getUsernm() %></td>
									<td><%=vo.getAlias() %></td>
									<td><%=vo.getReg_dt_fmt()%></td>
								</tr>
							<%
									}
							%>
						</table>
						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<%--
									
								 --%>
								<%
									for(int i = 1; i <= (int)request.getAttribute("pagination"); i++){
								%>
								<li><a href="<%=request.getContextPath() %>/pagingUser?page=<%=i %>&pageSize=5"><%=i %></a></li>
								<%} %>
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