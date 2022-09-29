<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login.jsp</title>
<link rel="stylesheet" href="css/login.css">
<script>
    // 유효성 검증 예정
    window.onload = function() {
        document.login.onsubmit = function() {
        	var empno = document.login.empno;
    		var pw = document.login.pw;
    		
            if(!empno.value) {
                alert("사원번호를 입력하세요")
                empno.focus();
                return false;
            }
            if(!pw.value) {
                alert("비밀번호를 입력하세요")
                pw.focus();
                return false;
            }
        }
    }
</script>

<style>

body {
	width: 100%;
	height: 100vh;
	position: relative;
	background: #f0f0f0;
}

h1 {
	margin: 0;
}

h3 {
	margin: 0em 0em 1em 0em;
	padding: 0;
}

.container {
	line-height: 10px;
}

.login-wrap {
	width: 25em;
	height: auto;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

#loginForm > input {
	background: #474955;
	width: 100%;
	height: 3em;
	border-radius: 0.5em;
	text-align: left;
	padding: 2px;
	box-sizing: border-box;
	color: #fff;
}

#loginForm > input::placeholder {
	color: #fff;
	margin-left: 0.5em;
}

#loginForm > input:focus {
	color: #fff;
}

#loginForm > input:focus::placeholder {
	color: transparent;
}

#loginForm > button {
	background: #F42424;
	width: 100%;
	height: 2.5em;
	border-radius: 0.5em;
	border: none;
	color: #fff;
	font-size: 1em;
	padding: 2px;
	cursor: pointer;
}

#loginForm > button:hover {
	background: #F44949;
	transition: 0.5s;
}

#loginForm > button:active {
	background: #E00000;
}

.move-page {
	margin: 0;
	background: #D81919;
	width: 100%;
	height: 2.5em;
	border-radius: 0.5em;
	border: none;
	color: #fff;
	font-size: 1em;
	padding: 2px;
	cursor: pointer;
}

.move-page a {
	line-height: 42px;
	text-decoration: none;
	color: #fff; 
	display: block;
	width: 100%;   
}
	
</style>

</head>
<body>
	<div class="login-wrap">
	<h1 align="center">Team PP</h1>
	<h3 align="center">Bora, Hyunmin, Minuk</h3>
	<div class="container">
		<div class="login" align="center" >
			<form id="loginForm" name="login" action="login" method="post">
				<input type="text" id="empno" name="empno" placeholder="사원번호를 입력하세요"></br><br/>
				<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요"><br/><br/>
				<button type="submit">사원 로그인</button><br/><br />
			</form>
				<div class="move-page">
				<a href="ppHomepage.jsp">회사 홈페이지 이동</a>
				</div>
			</div>
	</div>
	</div>
</body>
</html>