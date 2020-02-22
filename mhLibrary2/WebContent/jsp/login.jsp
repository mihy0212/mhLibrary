<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">

	function checkIdPw(){
		var check = document.frm;
		if(check.loginid.value == ""){
			alert("아이디를 입력하세요.");
			check.loginid.focus();
			return false;
		}
		else if(check.loginpw.value ==""){
			alert("비밀번호를 입력하세요.");
			check.loginpw.focus();
			return false;
		}
		check.submit();
	}

</script>
</head>

<body>

<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- 본문 -->
<div align="center">

<div>
	<h1>로그인</h1>
	<hr size="1" width="800">
</div>

<c:choose>
	<c:when test="${ empty id }">
		<br>
		<c:if test="${ login == 'loginFail' }">
			<font size="2" color="red">로그인에 실패했습니다. 아이디와 비밀번호를 다시 확인해 주세요.</font>
			<% session.invalidate(); %>
		</c:if><br><br>
		<div>
		<form id="frm" name="frm" action="login.do" method="post">
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td><input type="text" id="loginid" name="loginid" size="20"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="loginpw" name="loginpw" size="20"></td>
				</tr>
			</table><br>
			<input type="button" onclick="checkIdPw()" value="로그인"> &nbsp;&nbsp;
			<input type="reset" value="취소"> &nbsp;&nbsp;
			<input type="button" onclick="location.href='joinForm.do'" value="회원가입">
		</form>	
		</div>
	</c:when>
	
	<c:otherwise>
		<div>
		<h1> ${ id }님은 이미 로그인했습니다.</h1>
		<!-- 로그아웃 -->
		<form id="frm1" name="frm1" action="logout.do" method="post">
			<input type="submit" value="logout">
		</form>
		</div>
	</c:otherwise>
</c:choose>

</div><br><br>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>