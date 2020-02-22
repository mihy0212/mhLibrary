<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>

<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- 본문 -->
<div align="center">

	<div>
		<h1>글 수 정</h1>
		<hr size="1" width="800">
	</div>

	<!-- secure문제 해결하기 : 세션으로 로그인한 아이디와 글 작성자의 아이디가 같지 않으면 글 수정 창을 보여주지 않도록 설정 -->
	<c:choose>
	<c:when test="${id == ndto.memberId }">
		<div>
			<form id="frm" name="frm" action="noticeUpdate.do?key=${ndto.noticeNum }" method="post">
				<input type="hidden" id="mid" name="mid" value="${id}">
				<table border="1">
					<tr>
						<th width="100" bgcolor="#BDBDBD"><font color="white">글번호</font></th>
						<td colspan="5">${ndto.noticeNum }</td>
					</tr>
					<tr>
						<th width="100" bgcolor="#BDBDBD"><font color="white">작성자</font></th>
						<!-- 세션에서 name을 갖고와 readonly로 지정 -->
						<td width="150"><input type="text" id="writer" name="writer" value="${name}" readonly="readonly"></td>
						<th width="100" bgcolor="#BDBDBD"><font color="white">작성일</font></th>
						<td width="300" colspan="3"><input type="date" id="wdate" name="wdate" value="${ndto.noticeDate}"></td>
					</tr>
					<tr>
						<th width="100" bgcolor="#BDBDBD"><font color="white">제목</font></th>
						<td colspan="5"><input type="text" id="title" name="title" size="80" value="${ndto.noticeTitle}"></td>
					</tr>
					<tr height="300">
						<th width="100" bgcolor="#BDBDBD"><font color="white">내용</font></th>
						<td colspan="5"><textarea rows="20" cols="81" id="content" name="content">${ndto.noticeContent}</textarea></td>
					</tr>
					<tr>
						<th width="100" bgcolor="#BDBDBD"><font color="white">첨부파일</font></th>
						<td colspan="5"><input type="file" id="fileName" name="fileName" size="100"></td>
					</tr>
				</table><br>
					<input type="submit" value="등록"> &nbsp;&nbsp;
					<input type="reset" value="취소"> &nbsp;&nbsp;
					<input type="button" onClick="location.href='noticeList.do'" value="목록 보기">
			</form>
		</div><br>
	</c:when>
	
	<c:otherwise>
		<h1> 잘못된 접근입니다.</h1>
		<input type="button" onclick="location.href='index.do'" value="홈으로">
	<br><br>
	</c:otherwise>
	</c:choose>
</div>


<script>

// 작성일을 현재 날짜로 기본설정하는 스크립트
	document.getElementById('wdate').value = new Date().toISOString().substring(0,10);
	
//이미 첨부된 첨부파일을 보이게 하기

</script>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>