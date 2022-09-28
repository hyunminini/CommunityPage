<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
		
		var password = prompt("삭제할 게시물의 사원번호 입력하세요(테스)");	
		if(password){
			document.requestForm.command.value ="delete";
			document.requestForm.empno.value = empno;
			document.requestForm.submit();			
		}else{
			return false;
		}
}

</script>
<style>
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
		justify-content: space-between;
		padding-top: 1em;
	}
	
	.data-btn > * {
		margin-left: 5px;
		margin-right: 5px;
	}
	
	.board {
		padding: 1em 0.3em 1em 0.3em;
		font-size: 1.1em;
		line-height: 32px;
	}
	.comment-wrap {
		width: 100%;
		margin-top: 1em;
		padding: 0.5em 0.3em 0.5em 0.3em;
		border-radius: 15px;
	}
	
	.comment-wrap p {
		margin: 0px;
	}
	
	.comment {
		height: 10em;
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
			<a class="navbar-brand" href="main.jsp">
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
					사번  ${empno}
	
					<span class="caret"></span>
					</a>
					
				<!-- 드랍다운 아이템 영역 -->
				<ul class="dropdown-menu">
					<li class="active"> 
						<a href="logoutAction.jsp">로그아웃</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>
	
	<!-- 메인 이미지 -->
<div class="mainImg"></div>

<div class="board-wrap">
	<div class="max-wrap">
		<div class="read-title">
			
			<p><span>${requestScope.resultContent.category} </span> ${requestScope.resultContent.title}</p>
            <p>작성일: ${requestScope.resultContent.write_date}</p>
    	</div>
		<div class="read-conwrap">
			<p class="ename">작성자: ${requestScope.resultContent.ename} </p> 
			
			<ul class="read-con">
				<li>조회: ${requestScope.resultContent.readnum} </li>
				<li>좋아요: </li>
				<li>댓글: </li>
			</ul>
		</div>    
		
		<div class="board">
			${requestScope.resultContent.content}
		</div>
	
	<div class="btn-wrap">
		<button>좋아요: </button>
		<button>신고</button>
	</div>
	
	<div class="upload-wrap">
		<div class="upload-fail">업로드 파일:</div> 
	</div>
    	
    <% String board_cnum = (String) request.getParameter("board_cnum"); %>
    <div class="data-btn">
    	<form name="requestForm" method=post action="board.do?command=updateForm&board_cnum=<%=board_cnum %>">
			<input type=hidden name=board_cnum value="${requestScope.resultContent.board_cnum}">
			<input type=hidden name="command" value="read">
			<input type="hidden" name="ename" value="${requestScope.resultContent.ename}">
			<input type="hidden" name="title" value="${requestScope.resultContent.title}">
			<input type="hidden" name="content" value="${requestScope.resultContent.content}">	
			<input type=button value="수정하기" onClick="sendUpdate()">
			<input type=button value="삭제하기" onClick="sendDelete()">
		</form>

		<form id="loginForm" name="emp" action="board.do?command=backDrop" method="post">
			<button type="submit">목록으로 ></button><br/>
		</form>
	
	</div>
	
	<div class="comment-wrap">
		<p>댓글: </p>
	</div>
	
	<div>
	<c:forEach items="${requestScope.coms}" var ="data">
		<h2>${data.board_cnum}</h2>
		<tr>
			<td><p>${data.co_write_date}</p></td>
			<td>
				<p>${data.co_content}</p>
			</td>
			
		</tr>
	</c:forEach>
	</div>
	
	<form action="comment.do" method="post">
		<input type="hidden" name="command" value="comment">
		<input type="hidden" name="empno"  value="${requestScope.resultContent.empno}">
		<input type="hidden" name="ename" value="${requestScope.resultContent.ename}">
		<input type="hidden" name="co_write_date" value="${requestScope.resultContent.co_write_date}">
		<input type="hidden" name="board_cnum" value="${requestScope.resultContent.board_cnum}"></input> 
		<textarea class="comment" name="co_content" cols="50" rows="10"></textarea>
		<input type="submit" value="저장">
	</form>	
	
	</div>
</div>
		
<footer>
	<div class="max-wrap">
	
	</div>
</footer>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
