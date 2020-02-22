<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
</head>
<body>

<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- 본문 -->
<div align="center">

	<div>
		<h1>공지 사항 목록</h1>
		<hr size="1" width="800">
	</div>
	
	<br><div>
		<table border="1">
			<tr bgcolor="#BDBDBD">
				<th width="50"><font color="white">번호</font></th>
				<th width="400"><font color="white">제목</font></th>
				<th width="100"><font color="white">작성자</font></th>
				<th width="100"><font color="white">작성일</font></th>
				<th width="100"><font color="white">첨부파일</font></th>
				<th width="50"><font color="white">조회수</font></th>
			</tr>
			
			<!-- DB 목록을 가져와서 뿌려주는 곳 : 등록된 글이 없을 때와 있을 때 구분해서 작성-->
			<c:if test="${nlist.isEmpty()}">
				<tr>
					<td colspan="6" align="center">등록된 글이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			
			<c:forEach items="${ nlist }" var="ndto">
				<!-- 마우스로 행을 클릭하면 글 조회 가능하도록 설정 -->
				<tr onclick="location.href='noticeRead.do?key=${ndto.noticeNum}&key2=${ ndto.memberId }'"
					 onmouseover="this.style.background='#F2F2F2'"
					 onmouseout="this.style.background='white'">
					<td align="center">${ndto.noticeNum}</td><!-- 글번호 -->
					<td>&nbsp;&nbsp; ${ndto.noticeTitle}</td><!-- 글제목 -->
					<td align="center">${ndto.memberName}</td><!-- 글쓴이 -->
					<td align="center">${ndto.noticeDate}</td><!-- 글쓴일자 -->
					<td align="center">${ndto.noticeFileName}</td><!-- 첨부파일 -->
					<td align="center">${ndto.noticeHit}</td><!-- 조회수 -->
				</tr>
			</c:forEach><!-- DB 목록을 가져와서 뿌려주는 곳 end -->
		</table>
	</div><br>
	
	<div>
		<!-- 관리자일 경우만 글쓰기가 가능하도록 설정 -->
		<c:if test="${grant == 'S'}">
			<input type="button" onclick="location.href='noticeForm.do'" value="새글 쓰기">
		</c:if>
	</div><br>

</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>