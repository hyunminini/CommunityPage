<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" initial-scal="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/board-list.css">
<title>Main.jsp</title>

<style>
	
.add-btn {
	border: none;
	background: none;
	width: auto;
	height: auto;
}

.add-btn a{
	text-decoration: none;
}

.add-btn a:hover {
	transition: 0.5s;
	background: #f9f9f9;
}
	
.add-btn a:active {
	background: #e9e9e9;
}

.max-wrap {
	width: 100%;
	max-width: 800px;
	margin: 0 auto;
}

footer {
	height: auto;
	background: none;
}

.ft-wrap {
	border-top: 1px solid #ccc;
	text-align: center;
	padding: 2em 0em 2em 0em;
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



<div class="max-wrap">
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	
	<tr class="list-title">
        <td>
        	<p>번호</p>
        </td>
        <td>
			<p>분류</p>
        </td>
        <td>
			<p>제목</p>
        </td>
        <td>
			<p>작성자</p>
        </td>
        <td>
			<p>작성일</p>
        </td>
        <td>
			<p>조회</p>
        </td>
    </tr>
    
 	<c:if test="${empty Main || fn:length(Main) == 0}">
		<tr>
	        <td colspan="5">
	            <p align="center"><b><span style="font-size:9pt;">등록된 방명록이 없습니다.</span></b></p>
	        </td>
	    </tr>
	</c:if>

	<%-- ArrayList에  BoardDTO 객체를 하나하나 data라는 반복 대입해서 사용 --%>
	<c:forEach items="${requestScope.Main}" var="data">
		    <tr class="board-list">
		        <td>
		            <p>${data.board_cnum}</p>
		        </td>
		        
		        <td>
		            <p>${data.category}</p>
		        </td>
		        
		        
	     		<td >
		            <p>
		           		<a href="board.do?command=read&board_cnum=${data.board_cnum}&empno=${empno}">${data.title}</a>
		            </p>
		        </td>

		       <td>
		            <p>${data.ename}</p>
		        </td>
		        <td >
		            <p>${data.write_date}</p>
		        </td>
		        <td>
		            <p>${data.readnum}</p>
		        </td>
		    </tr>
	</c:forEach>
</table>

<div class="add-wrap">	
	<form action="board.do" method="post">
		<button class="add-btn" type="submit"><a href="board.do?command=write&empno=${empno}">게시글 작성</a></button>
		<input type="hidden" name="empno" value="${empno}"></input>
	</form>
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
