<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

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
<%-- ${requestScope.resultContent.board_cnum} --%>
<style>
	
	
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
			<a class="navbar-brand" href="Main.jsp">
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
<div class="mainImg"></div>

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
    	
    </div>
    <%
		String board_cnum = (String) request.getParameter("board_cnum");
	%>
    <div class="data-btn">
    	<form name="requestForm" method=post action="board.do?command=updateForm&board_cnum=<%=board_cnum %>">
			<input type=hidden name=board_cnum value="${requestScope.resultContent.board_cnum}">
			<input type=hidden name="command" value="read">
			
			<input type="hidden" name="title" value="${requestScope.resultContent.title}">
			<input type="hidden" name="content" value="${requestScope.resultContent.content}">	
			
			<input type=button value="수정하기" onClick="sendUpdate()">
			<input type=button value="삭제하기" onClick="sendDelete()">
		</form>
	</div>
    
</div>

<button><a href="javascript:history.back();"> 목록으로 > </a></button>

<footer>
	<div class="max-wrap">
	
	</div>
</footer>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
