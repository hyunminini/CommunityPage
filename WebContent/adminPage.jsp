<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
	.max-wrap{
		width:100%;
		max-width:1000px;
		margin: 0 auto;
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
</style>


</head>
<body>

   <!-- 네비게이션 -->
   <nav class="navbar navbar-default">
   	<div class="max-wrap">
      <!-- 네비게이션 상단 Header  -->
      <div class="navnar-header">
         <button type="button" class="navbar-toggle collapese"
            data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
            aria-expanded="false">

            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
               class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="main.jsp"> PP 게시판 웹 사이트 </a>
      </div>

      <!-- 메뉴 영역 깃허브 링크 이동 -->
      <div class="collapse navbar-collapse"
         id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            <li><a href="#">강보라</a></li>
            <li><a href="#">김현민</a></li>
            <li><a href="#">김민욱</a></li>
         </ul>

         <!-- 메뉴 드랍다운 영역 -->
         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a href="#" class="dropdown-toggle"
               data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false"> ${sessionScope.ename}님 <span
                  class="caret"></span>
            </a> <!-- 드랍다운 아이템 영역 -->
               <ul class="dropdown-menu">
                  <c:choose>
                     <c:when test="${sessionScope.empno == 1001}">
                        <li class="active"><a href="logoutAction.jsp">관리자 페이지
                              이동</a></li>
                        <li><a href="logoutAction.jsp">로그아웃</a></li>
                     </c:when>
                     <c:otherwise>
                        <li class="active"><a href="logoutAction.jsp">로그아웃</a></li>
                     </c:otherwise>
                  </c:choose>
               </ul></li>
         </ul>
      </div>
      </div>
   </nav>

   <!-- 메인 이미지 -->
   <div class="mainImg">
   		<img src="images/team.jpg">
   </div>



   <div class="max-wrap">
   <table align="center" border="0" cellpadding="5" cellspacing="2"
      width="100%" bordercolordark="white" bordercolorlight="black">

      <tr class="list-title">
         <td><input type="checkbox"></td>
         <td>
            <p>이름</p>
         </td>
         <td>
            <p>직급</p>
         </td>
         <td>
            <p>부서</p>
         </td>
         <td>
            <p>입사일</p>
         </td>
      </tr>

      <%-- ArrayList에  BoardDTO 객체를 하나하나 data라는 반복 대입해서 사용 --%>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>신용기</p>
         </td>

         <td>
            <p>관리자</p>
         </td>

         <td>
            <p>ADMIN</p>
         </td>
         <td>
            <p>2022-01-01</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>강권모</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>QualityTeam</p>
         </td>
         <td>
            <p>2022-02-07</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>강보라</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>ProductionTeam</p>
         </td>
         <td>
            <p>2022-08-06</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>김경률</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>MaterialTeam</p>
         </td>
         <td>
            <p>2022-07-16</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>김경욱</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>SalesTeam</p>
         </td>
         <td>
            <p>2022-11-13</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>김민욱</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>MaterialTeam</p>
         </td>
         <td>
            <p>2022-03-11</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>김재선</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>SalesTeam</p>
         </td>
         <td>
            <p>2022-03-03</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>김현민</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>SalesTeam</p>
         </td>
         <td>
            <p>2022-08-19</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>박상민</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>ProductionTeam</p>
         </td>
         <td>
            <p>2022-02-21</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>박수용</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>ProductionTeam</p>
         </td>
         <td>
            <p>2022-03-16</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>배병서</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>ProductionTeam</p>
         </td>
         <td>
            <p>2022-11-16</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>배진경</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>QualityTeam</p>
         </td>
         <td>
            <p>2022-12-27</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>손용민</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>SalesTeam</p>
         </td>
         <td>
            <p>2022-09-30</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>이광석</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>QualityTeam</p>
         </td>
         <td>
            <p>2022-10-10</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>이동훈</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>SalesTeam</p>
         </td>
         <td>
            <p>2022-06-23</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>정주현</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>ProductionTeam</p>
         </td>
         <td>
            <p>2022-07-13</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>정혜지</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>ProductionTeam</p>
         </td>
         <td>
            <p>2022-03-24</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>주동석</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>QualityTeam</p>
         </td>
         <td>
            <p>2022-03-30</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>최정현</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>QualityTeam</p>
         </td>
         <td>
            <p>2022-09-09</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>홍민향</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>QualityTeam</p>
         </td>
         <td>
            <p>2022-10-23</p>
         </td>
      </tr>
      <tr class="board-list">
         <td><input type="checkbox"></td>

         <td>
            <p>황동하</p>
         </td>

         <td>
            <p>사원</p>
         </td>

         <td>
            <p>SalesTeam</p>
         </td>
         <td>
            <p>2022-04-08</p>
         </td>
      </tr>


   </table>
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