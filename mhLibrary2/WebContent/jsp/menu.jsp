<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상단 메뉴</title>
<link style="text/css" rel="stylesheet" href="css/menu.css"></link>
</head>
<body>

<div class="menubar">

	<img src="img/open-book.png">
	<h2>미/현/동/도/서/관</h2>
	<c:if test="${ name  != null }">
		<h4>${ name }님 반갑습니다.</h4>
	</c:if>
	<ul>
	
		<li><a href="index.do">홈</a></li>
		
		
		<li><a href="#">도서관 정보</a>
			<ul>
				<li><a href="#">도서관 안내(준비 중)</a></li>
				<li><a href="noticeList.do">공지 사항</a></li>
				<li><a href="#">질문과 답변(준비 중)</a></li>
			</ul>
		</li>
		
		
		<li><a href="searchForm.do">도서 검색</a></li>
		
		<!-- 로그인 모드 -->
		<c:if test="${ id != null }">
		<li><a href="#">나의 이력</a>
			<ul>
				<li><a href="#">나의 대출 내역(준비 중)</a></li>
				<li><a href="myInfo.do?key=${ id }">내 정보 수정</a></li>
			</ul>
		</li>
		</c:if>
		<!-- 로그인 모드 -->
		
		<!-- 관리자 모드  -->
		<c:if test="${ (id != null) && (grant == 'S') }">
		<li><a href="#">관리자</a>
			<ul>
				<li><a href="manageBook.do">도서 관리</a></li>
				<li><a href="manageMem.do">회원 관리</a></li>
			</ul>
		</li>
		</c:if>
		<!-- 관리자 모드  -->
		
		<!-- 로그인/로그아웃 -->
		<c:choose>
		<c:when test="${ empty id }">
			<li id="right"><a href="loginForm.do">로그인</a></li>
		</c:when><c:otherwise>
			<li id="right"><a href="logout.do" onclick="return confirm('정말 로그아웃 하시겠습니까?');">로그아웃</a></li>
		</c:otherwise>
		</c:choose>
		<!-- 로그인/로그아웃 -->
	</ul>
</div>

</body>
</html>