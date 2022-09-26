<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.DBUtill" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connectionTest.jsp</title>
</head>
<body>
	<%-- DB 연결 테스트 --%>
	<%
		// DB 연결 직접적으로 하는 것 권장하지 않음!
		out.println(DBUtill.getConnection());
	
	%>

</body>

</html>