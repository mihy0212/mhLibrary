<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<script type="text/javascript">

	function checkfrm(){
		var form = document.frm;
		
		if(!form.mpwOld.value){
			alert("기존 비밀번호를 입력해 주세요.");
			form.mpwOld.focus();
			return false;
		}
		
		if( form.mpwOld.value != form.mpw.value ){
			alert("기존 비밀번호와 일치하지 않습니다. 다시 입력해 주세요.")
			form.mpwOld.value = "";
			form.mpwOld.focus();
			return false;
		}
		
		if(!form.mpwNew.value){
			alert("새로운 비밀번호를 입력해 주세요.");
			form.mpwNew.focus();
			return false;
		}
		
		if(!form.mpwNewCk.value){
			alert("비밀번호 확인을 입력해 주세요.");
			form.mpwNewCk.focus();
			return false;
		}
		
		if(form.mpwNew.value != form.mpwNewCk.value) {
			alert("새로운 비밀번호가 서로 일치하지 않습니다. 다시 입력해 주세요.");
			form.mpwNewCk.value = "";
			form.mpwNew.value = "";
			form.mpwNew.focus();
			return false;
		}
		
		var con = confirm("입력한 내용으로 정보를 수정하시겠습니까?");
		if(con){
			form.submit();			
		} else {
			return false;
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
		<h1>내 정보 수정</h1>
		<hr size="1" width="800">
	</div><br>
	
	<c:choose>
	<c:when test="${ id == mlist.memberId }">
		<div>
		<form id="frm" name="frm" action="myInfoUpdate.do" method="post">
			<table border="1">
				<tr>
					<th width="150">아이디 <font color="red">*</font></th>
					<td><font color="gray"><b>&nbsp; ${ mlist.memberId }</b></font>
						<input type="hidden" id="mid" name="mid" value=${ mlist.memberId }>
					</td>
				</tr>
				<tr>
					<th>기존 비밀번호 <font color="red">*</font></th>
					<td><input type="password" id="mpwOld" name="mpwOld" size="20">
					<input type="hidden" id="mpw" name="mpw" value=${ mlist.memberPw }>
					</td>
				</tr>
				<tr>
					<th>새로운 비밀번호 <font color="red">*</font></th>
					<td><input type="password" id="mpwNew" name="mpwNew" size="20"></td>
				</tr>
				<tr>
					<th>비밀번호 확인 <font color="red">*</font></th>
					<td><input type="password" id="mpwNewCk" name="mpwNewCk" size="20"></td>
				</tr>
				<tr>
					<th>이름 <font color="red">*</font></th>
					<td><input type="text" id="mname" name="mname" size="20" value="${ mlist.memberName }"></td>
				</tr>
				<tr>
					<th>전화번호 </th>
					<td><input type="text" id="mtel" name="mtel" size="20" value="${ mlist.memberTel }"></td>
				
			</table>
			<br>
			<input type="button" onclick="checkfrm()" value="수정"> &nbsp;&nbsp;
			<input type="button" onclick="location.href='myInfo.do?key=${mlist.memberId}'" value="취소">
			<br><br>
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