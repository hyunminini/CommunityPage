<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Insert title here</title>

<style>

.navbar {
	margin: 0;
}

.mainImg {
	width: 100%;
	height: 365px;
	background: #ccc;
	position: relative;;
}

.mainImg .max-wrap {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

section {
	width: 100%;
	height: 60vh;
}

.page-1 {
	background: #f0f0f0;
}

.page-2 {
	background: #e9e9e9;
}

.ft-wrap {
	border-top: 1px solid #ccc;
	text-align: center;
	padding: 2em 0em 2em 0em;
}



footer {
	height: auto;
	background: none;
}


</style>

</head>
<body>
<!-- 네비게이션 -->
<nav class="navbar navbar-default">
		<!-- 네비게이션 상단 Header  --> 
		<div class="navnar-header">
			<button 
				type="button"
				class="navbar-toggle collapese"
				data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="board.do?command=backDrop">
				PP 게시판 웹 사이트
			</a>			
		</div>
		
		<!-- 메뉴 영역 깃허브 링크 이동 -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="https://github.com/Bora0k" target="_blacnk">강보라</a></li>
				<li><a href="https://github.com/hyunminini" target="_blacnk">김현민</a></li>
				<li><a href="https://github.com/poviea" target="_blacnk">김민욱</a></li>
			</ul>		
		
			<!-- 메뉴 드랍다운 영역 -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#"
						class="dropdown-toggle"
						data-toggle="dropdown"
						role="button"
						aria-haspopup="true"
						aria-expanded="false"
					>
					관리자페이지 접속
					<span class="caret"></span>
					</a>
					
				<!-- 드랍다운 아이템 영역 -->
				<ul class="dropdown-menu">
					<li class="active"> 
						<a href="Login.jsp">접속하기</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>
	
	<!-- 메인 이미지 -->
<div class="mainImg">
	<div class="max-wrap">
		<h2>PP Java Project <br /> Company Page</h2>
		<p> <p/>
	</div>
</div>


<section class="page-1">
	<div class="max-wrap">
	
	</div>
</section>

<section class="page-2">
	<div class="max-wrap">
	
	</div>
</section>

<br />
<br />
	
<footer>
	<div class="max-wrap">
		<div class="ft-wrap">
			<h3>PP_Project</h3>
			<p>Team: Bora0k, hyunminini, poviea</p>
			<p>©2022 Java Mini Project</p>
		</div>
	</div>
</footer>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>