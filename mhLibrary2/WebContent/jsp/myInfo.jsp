<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 정보</title>
<script type="text/javascript">
	function myInfoDel(){
		var mid = document.frm.mid.value;
		console.log(mid);
		var con = confirm("정말로 탈퇴하시겠습니까?");
		if(con){
			document.location.href="myInfoDel.do?key="+mid;
		}
	}
</script>
</head>
<body>

<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- 본문 -->
<div align="center">
	
	<div>
		<h1>${ mlist.memberId } 님의 정보</h1>
		<hr size="1" width="800">
	</div><br>
	
	<c:choose>
	<c:when test="${ id == mlist.memberId }">
		<div>
		<form id="frm" name="frm" action="myInfoForm.do?key=${ id }" method="post">
			<table border="1">
				<tr>
					<th width="150">아이디</th>
					<td align="center"><font color="gray"><b>${ mlist.memberId }</b></font>
						<input type="hidden" id="mid" name="mid" value=${ mlist.memberId }>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td align="center"><input type="password" id="mpwOld" name="mpwOld" size="20" value=${ mlist.memberPw } readonly="readonly" style="text-align=center;"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td align="center"><font color="gray"><b>${ mlist.memberName }</b></font></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td align="center"><font color="gray"><b>${ mlist.memberTel }</b></font></td>
				
			</table>
			<br>
			<input type="submit" value="수정"> &nbsp;&nbsp;
			<input type="button" onclick="myInfoDel()" value="회원 탈퇴"><br>
			<br>
		</form>
		</div>
	</c:when>
	
	<c:when test="${ grant == 'S' }">
		<div>
		<form id="frm" name="frm" action="myInfoForm.do?key=${ id }" method="post">
			<table border="1">
				<tr>
					<th width="150">아이디</th>
					<td align="center"><font color="gray"><b>${ mlist.memberId }</b></font>
						<input type="hidden" id="mid" name="mid" value=${ mlist.memberId }>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td align="center"><input type="password" id="mpwOld" name="mpwOld" size="20" value=${ mlist.memberPw } readonly="readonly" style="text-align=center;"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td align="center"><font color="gray"><b>${ mlist.memberName }</b></font></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td align="center"><font color="gray"><b>${ mlist.memberTel }</b></font></td>
				
			</table>
			<br>
			<input type="submit" value="수정"> &nbsp;&nbsp;
			<input type="button" onclick="myInfoDel()" value="회원 탈퇴"><br>
			<br>
		</form>
		</div>
	</c:when>
	
	<c:otherwise>
		<h3>잘못된 접근입니다.</h3>
		<input type="button" onclick="location.href='index.do'" value="홈으로"><br><br>
	</c:otherwise>
	</c:choose>
</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>