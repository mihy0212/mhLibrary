<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 읽기</title>
<script type="text/javascript">
	function fileDown(){
		document.location.href="download.do?fileName=${ndto.noticeFileName}";
	}
	
	function checkDel(){
		var con = confirm("정말 삭제하시겠습니까?")
		if(con){
			document.location.href="noticeDel.do?key=${ndto.noticeNum}";
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
		<h1>공지사항</h1>
		<hr size="1" width="800">
	</div>
	
	<div>
		<table border="1">
			<tr>
				<th width="100" bgcolor="#BDBDBD"><font color="white">글 번호</font></th>
				<td colspan="5">${ndto.noticeNum}</td>
			</tr>
			<tr>
				<th width="100" bgcolor="#BDBDBD"><font color="white">작성자</font></th>
				<td width="150" align="center">${ndto.memberName}</td>
				<th width="100" bgcolor="#BDBDBD"><font color="white">작성일</font></th>
				<td width="100" align="center">${ndto.noticeDate}</td>
				<th width="100" bgcolor="#BDBDBD"><font color="white">조회수</font></th>
				<td width="100" align="center">${ndto.noticeHit}</td>
			</tr>
			<tr>
				<th width="100" bgcolor="#BDBDBD"><font color="white">제목</font></th>
				<td width="550" colspan="5">${ndto.noticeTitle}</td>
			</tr>
			<tr height="300">
				<th width="100" bgcolor="#BDBDBD"><font color="white">내용</font></th>
				<td width="550" colspan="5" valign="top"><pre>${ndto.noticeContent}</pre></td>
			</tr>
			<tr>
				<th width="100" bgcolor="#BDBDBD"><font color="white">첨부파일</font></th>
				<td width="550" colspan="5" valign="top">${ndto.noticeFileName} &nbsp;&nbsp;
					<c:if test="${ndto.noticeFileName} != null ">
						<input type="button" onclick="fileDown()" value="다운로드">
					</c:if>
				</td>
				
			</tr>
		</table>
	</div><br>
	
	<div>		
		<!-- 로그인한 사용자가 쓴 것만 수정,삭제 -->
		<c:if test="${ndto.memberId == id and not empty ndto.memberId and not empty id}">
			<input type="button" onclick="location.href='noticeUpForm.do?key=${ndto.noticeNum}'" value="글 수정"> &nbsp;&nbsp;
			<input type="button" onclick="checkDel()" value="글 삭제"> &nbsp;&nbsp;
		</c:if>
		<!-- 로그인한 사용자가 쓴 것만 수정,삭제 -->
	
		<input type="button" onclick="location.href='noticeList.do'" value="목록 보기">
	</div><br>
</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>