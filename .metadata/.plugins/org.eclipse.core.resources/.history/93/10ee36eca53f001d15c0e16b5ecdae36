<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" initial-scal="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/board.css">
<link rel="stylesheet" href="css/layout.css">
<title>BoardWrite.jsp</title>

<style>
.back-btn a{
	color: #000;
	padding: 0.3em 3em 0.3em 3em;
	background: #f0f0f0;
	border: 1px solid #ccc;
	text-decoration: none;
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

<script language=javascript>
function checkValid() {
    var f = window.document.writeForm;
 	if ( f.select.value == "" ) {
		alert( "분류를 선택해 주세요." );
		return false;
	} 
	if ( f.title.value == "" ) {
		alert( "제목을 입력해 주세요." );
		return false;
	}
    return true;
}
</script>
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

<div class="form-wrap">
<form name="writeForm" method="post" action="board.do" onSubmit='checkValid()'>
	<input type="hidden" name="command" value="write">
	<table align="center" cellpadding="5" cellspacing="2" width="100%" border="1">
      	<div class="board-text-flex">
      		<h3 class="board-name">게시글 작성</h3>
      		<p class="back-btn"><a href="javascript:history.back();">뒤로가기</a></p>
      	</div>
    	<tr>
       	 	<td class="left-td">
            	<p class="board-in-text">분류</p>
        	</td>	
        	<td class="right-td">
				<select class="category" name="category">
					<option value="자유게시판">자유게시판</option>
					<option value="점메추">점메추</option>
					<option value="유머">유머</option>
				</select>
			</td>
    	</tr>
    	<tr>
        	<td class="left-td">
            	<p class="board-in-text">제목</p>
       		</td>
        	<td class="right-td">
				<input class="title" type=text name="title" placeholder="제목을 입력해주세요">
			</td>
   		</tr>
    
   		<tr>
       		<td class="left-td">
            	<p class="board-in-text">내 용</p>
        	</td>
        	<td class="right-td">
				<textarea name="content" cols="50" rows="10"></textarea>
			</td>
    	</tr>
	</table>
	<input type="hidden" name="board_cnum" value="${board_cnum}"></input>
	<input type="hidden" name="empno" value="${empno}"></input>

	<div class="btn-wrap">
		<input class="submit" type="submit" value="게시글 작성"> 
	</div>
</form>
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