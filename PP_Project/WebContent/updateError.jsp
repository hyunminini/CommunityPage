<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	width: 100%;
	height: 100vh;
	position: relative;
	background: #f0f0f0;
}

h2{
	margin: 0px;
}

p {
    margin-bottom: 26px;
}
.error-wrap {
	width: 25em;
	height: auto;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	background: #fff;
	padding: 5em 0em 5em 0em;
	border: 1px solid #b9b9b9;
	margin: 0px;
	border-radius: 10px;
}

.error-wrap a {
	text-decoration: none;
	color: #fff;
	background: #159DFF;
	border-radius: 8px;
	padding: 0.5em 5em 0.5em 5em;
	margin: 0;
}
</style>
</head>
<body>

	${requestScope.error}  
	<br>
	
	<div class="error-wrap">
		<h2>수정이 불가 합니다.</h2>
		<p>본인 계정으로 수정해주세요</p>
		
		<a href="javascript:history.back();"> 돌아가기</a>
	</div>
	
	

</body>
</html>