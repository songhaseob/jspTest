<%@page import="java.util.Scanner"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connection pooling </title>
</head>
<body>
	<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 30; i++){
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
											"hssong",
											"java");
		conn.close();
		}
		long endTime = System.currentTimeMillis();
		out.print("duration:" + (endTime- startTime));
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
	
}


	%>
</body>
</html>