<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" initial-scal="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/board.css">
<link rel="stylesheet" href="css/layout.css">
<title>BoardRead.jsp</title>
<script language=javascript>

function sendUpdate(){
		document.requestForm.command.value ="updateForm";
		document.requestForm.submit();
}

function sendDelete(){
	document.requestForm.submit();
}	

function likeToggle() {
	document.requestForm.submit();
}


</script>
<style>
footer {
	height: auto;
	background: none;
}
.ft-wrap {
	border-top: 1px solid #ccc;
	text-align: center;
	padding: 2em 0em 2em 0em;
}

@charset "UTF-8";
	
	.board-text-flex {
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding: 3em 0 1em 0;
	}
	.board-text-flex h3 {
		margin: 0px;
	}	
	.board-text-flex p {
		margin: 0px;
	}
	.form-wrap {
		width: 100%;
		max-width: 1000px;
		margin: 0 auto;
	}
	.board-in-text {
		margin: 0px;
		font-size: 1.2em;
		margin-left: 1em;
		padding: 10px 0px 10px 0px;
	}
	.category {
		width: 25%;
		margin-left: 0.5em;
	}	
	.title {
		width: 50%;
		margin-left: 0.5em;
	}
	
	.mainImg {
	width: 100%;
	height: auto;
	filter: brightness(95%);
	}
	
	.mainImg img{
	width: 100%;
	height: auto;
	}

	.btn-wrap {
		text-align: right;
	}
	.submit {
		margin-top: 0.5em;
		width: 15%;
	}
	.left-td {
		width: 10em;
	}
	.comment {
		width: 100%;
		height: 5em;
		resize: none;
	}
	
	.max-wrap{
		width:100%;
		max-width:1000px;
		margin: 0 auto;
	}
	
	.board-wrap {
		margin-top: 5em;
	}
	
	.read-title {
		border-top: 1px solid #ccc;
		border-bottom: 1px solid #ccc;
		background-color: #f0f0f0;
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding: 1em 0.5em 1em 0.5em;
	}
	
	.read-title p{
		margin: 0;
	}
	.read-conwrap {
		margin: 0px;
		padding: 1em 0.3em 1em 0.3em;
		border-bottom: 1px solid #ccc;
		display: flex;
		justify-content: space-between;
	}
	
	.ename {
		margin: 0px;
	}
	
	.read-con {
		margin: 0px;
		display: flex;
		align-items: center;
	}
	
	.read-con li {
		list-style: none;
		margin-left: 0.5em;
	}
	
	.data-btn {
		padding-top: 2em;
		margin-bottom: 1em;
	}
	
	.upload-wrap {
		width: 100%;
		margin-top: 2em;
		padding: 0.5em 0.3em 0.5em 0.3em;
		border-bottom: 1px solid #ccc;
		border-top: 1px solid #ccc;	
		background: #f0f0f0;		
	}
	
	.btn-wrap {
		margin-top: 5em;
	}
	.btn-wrap button {
		background: #f0f0f0;
		border: 1px solid #ccc;
		border-radius: 5px;
		padding: 0.3em 2em 0.3em 2em;
	}
	.upload-wrap {
		width: 100%;
		margin-top: 1em;
		padding: 0.5em 0.3em 0.5em 0.3em;
		border-bottom: 1px solid #ccc;
		border-top: 1px solid #ccc;	
		background: #f0f0f0;		
	}
	
	.data-btn {
		display: flex;
		padding-top: 1em;
	}
	
	.data-btn > * {
		margin-left: 0px;
		margin-right: 5px;
	}
	
	.board {
		padding: 1em 0.3em 1em 0.3em;
		font-size: 1.1em;
		line-height: 32px;
	}
	
	#data-form {

	}
	
	#data-form input {
		background: #f0f0f0;
		border: 1px solid #ccc;
		padding: 0.3em 2em 0.3em 2em;
		margin-right: 0.5em;
	}	
	
	#data-form input:hover {
		transition: 0.5s;
		background: #f9f9f9;
	}
	
	#data-form input:active {
		background: #e9e9e9;
	}
	
	#loginForm {
		text-align: right;
	}
	
	#loginForm button {
		background: #f0f0f0;
		border: 1px solid #ccc;
		padding: 0.3em 2em 0.3em 2em;
	}
	
	#loginForm button:hover {
		transition: 0.5s;
		background: #f9f9f9;
	}
	
	#loginForm button:active {
		background: #e9e9e9;
	}
	
	#add {
		margin-top: 0.5em;
		background: #fff;
		border: 1px solid #ccc;
		padding: 0.3em 5em 0.3em 5em;
	}
	
	.in-btn button {
		background: #fff;
		border: 1px solid #ccc;
		margin-left: 0.7em;
	}
	
	.in-btn button:hover {
		transition: 0.5s;
		opacity: 0.5;
	}
	
	.comment-wrap {
		width: 100%;
		margin-top: 1em;
		padding: 0.5em 1em 0.5em 1em;
		border-bottom: 1px solid #ccc;
		border-radius: 0px;
	}
	
	.comment-wrap h3 {
		font-size: 1.5em;
	}
	
	.comment-wrap p {
		margin: 0px;
		padding: 0.5em 0em 0.5em 0em;
	}
	
	.comment-wrap span {
		color: #ccc;
		font-size: 0.6em;
		margin-left: 1em;
	}
	
	.comment-add {
		margin-top: 5em;
	}
	
	.comment-add p {
		font-size: 1.5em;
	}
	
	.comment {
		height: 10em;
	}
	
	.in-content {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	
	.add-wrap {
		text-align: right;
	}
	
	

</style>
</head>
<body>

<!-- 네비게이션 -->
<nav class="navbar navbar-default">
	<div class="max-wrap">
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
			<!-- <a class="navbar-brand" href="main.jsp"> -->
			<a class="navbar-brand" href="board.do">
				PP 게시판 웹 사이트
			</a>			
		</div>
		
		<!-- 메뉴 영역 깃허브 링크 이동 -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">강보라</a></li>
				<li><a href="#">김현민</a></li>
				<li><a href="#">김민욱</a></li>
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
					${sessionScope.ename} 님
	
					<span class="caret"></span>
					</a>
					
				<!-- 드랍다운 아이템 영역 -->
				<ul class="dropdown-menu">
				
					<c:choose>
						<c:when test="${sessionScope.empno == 1001}">
							<li class="active"> 
								<a href="adminPage.jsp">관리자 페이지 이동</a>
							</li>
							<li> 
								<a href="logoutAction.jsp">로그아웃</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="active"> 
								<a href="logoutAction.jsp">로그아웃</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</li>
		</ul>
	</div>
	</div>
</nav>
	<!-- 메인 이미지 -->
<div class="mainImg">
	<img src="images/team.jpg">
</div>

<div class="board-wrap">
	<div class="max-wrap">
		<div class="read-title">
			
			<p><span>${requestScope.resultContent.category}</span> ${requestScope.resultContent.title}</p>
            <p>${requestScope.resultContent.write_date}</p>
    	</div>
		<div class="read-conwrap">
			<p class="ename">${requestScope.resultContent.ename}</p>
			
			<ul class="read-con">
				<li>조회: ${requestScope.resultContent.readnum} </li>
				<li>좋아요: </li>
				<li>댓글: </li>
			</ul>
		</div>    
		
		<div class="board">
			${requestScope.resultContent.content}
		</div>	
		
		
	<!-- 좋아요 눌럿는지 안눌럿는지 -->
<%-- 	<select id="findLike" resultType="int">
		select count(*) from vegan_like where board_no = #{board_cnum} and user_no = #{user_no}
	</select> --%>
	
	<div class="btn-wrap">
		<button onClick="likeToggle()">좋아요: </button>
		<button>신고</button>
	</div>
	
	<div class="upload-wrap">
		<div class="upload-fail">업로드 파일:</div> 
	</div>
     	
    <% String board_cnum = (String) request.getParameter("board_cnum"); %>
    <div class="data-btn">
    	<div style="display: flex;">
    	<form id="data-form" name="requestForm" method=post action="board.do?command=updateForm&board_cnum=<%=board_cnum %>">
			<input type=hidden name=board_cnum value="${requestScope.resultContent.board_cnum}">
			<input type=hidden name="command" value="read">
			<input type="hidden" name="title" value="${requestScope.resultContent.title}">
			<input type="hidden" name="content" value="${requestScope.resultContent.content}>">
			<input type="hidden" name="ename" value="${requestScope.resultContent.ename}">
			<c:choose>
				<c:when test="${sessionScope.empno == 1001}">
					<input type=button value="수정하기" onClick="sendUpdate()">
				</c:when>
				<c:when test="${sessionScope.empno == param.empno}">
					<input type=button value="수정하기" onClick="sendUpdate()">
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
		</form>
	
		<form id="data-form" method="post" action="board.do?command=delete&board_cnum=<%=board_cnum %>">
			<c:choose>
				<c:when test="${sessionScope.empno == 1001}">
					<input type="submit" value="삭제하기" onClick="sendDelete()">
				</c:when>
				<c:when test="${sessionScope.empno == param.empno}">
					<input type="submit" value="삭제하기" onClick="sendDelete()">
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
			<input type=hidden name="command" value="delete" />
			<input type=hidden name="empno" value="${empno}"/>
			<input type="hidden" name="board_cnum" value="<%=board_cnum %>" />
		</form>
		</div>
		
		<div>
		<form id="loginForm" name="emp" action="board.do" method="post">
			<button type="submit">목록으로 ></button><br/>
		</form>
		</div>
		</div>

	
		<c:forEach items="${requestScope.coms}" var ="data">
		<div class="comment-wrap">
			<div class="in-content">
				<div>
					<h3>${data.ename} <span>${data.co_write_date}</span></h3>
				</div>
				<div>
					<form class="in-btn">
						<button onClick="commentDelete()">삭제하기</button>
						<button onClick="commentDelete()">수정하기</button>
						<button>신고하기</button>
					</form>
				</div>
			</div>
			
			<p>${data.co_content}</p>
		</div>
	</c:forEach>
	
	<div class="comment-add">
		<p>댓글 작성</p>
	</div>
	<div class="add-wrap">
	<form action="board.do" method="post">
		<input type="hidden" name="command" value="comment">
		<input type="hidden" name="empno"  value="${empno}">
		<input type="hidden" name="ename" value="${requestScope.resultContent.ename}">
		<input type="hidden" name="board_cnum" value="${param.board_cnum}"></input> 
		<textarea class="comment" name="co_content" cols="50" rows="10"></textarea>
		<input id="add" type="submit" value="등록">
	</form>	
	<div>
	</div>
	</div>
	</div>
</div>
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
