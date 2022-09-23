<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.DBUtill" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConnectinoTest</title>
</head>
<body>

	<%-- DB 연결 테스트dd --%>
	<%
		out.println(DBUtill.getConnection());
	%>	
	
</body>
</html>