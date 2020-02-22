<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 쓰기</title>
<script type="text/javascript">
	function check(){
		var form = document.frm;
		if(!form.title.value){
			alert("제목을 입력해 주세요.");
			form.title.focus();
			return false;
		}
		
		/*if(!form.content.value){
			var concon = confirm("내용을 입력하지 않았습니다. 그래도 등록하시겠습니까?");
			if(concon){
				form.submit();
			} else {
				return false;
			}
		}*/
		
		var con =  confirm("입력한 내용으로 공지사항을 등록하시겠습니까?");
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
		<h1>공지사항 쓰기</h1>
		<hr size="1" width="800">
	</div>
	
	<div>
		<form id="frm" name="frm" action="noticeInsert.do" method="post" enctype="multipart/form-data">
			<input type="hidden" id="mid" name="mid" value="${id}">
			<table border="1">
				<tr>
					<th width="100" bgcolor="#BDBDBD"><font color="white">작성자</font></th>
					<!-- 세션에서 name을 갖고와 readonly로 지정 -->
					<td width="300"><input type="text" id="writer" name="writer" value="${name}" readonly="readonly"></td>
					<th width="100" bgcolor="#BDBDBD"><font color="white">작성일</font></th>
					<td width="300"><input type="date" id="wdate" name="wdate"></td>
				</tr>
				<tr>
					<th bgcolor="#BDBDBD"><font color="white">제목</font></th>
					<td colspan="3"><input type="text" id="title" name="title" size="100"></td>
				</tr>
				<tr>
					<th bgcolor="#BDBDBD"><font color="white">내용</font></th>
					<td colspan="3"><textarea rows="10" cols="100" id="content" name="content"></textarea> </td>
				</tr>
				
				<!-- 첨부파일 만들기 -->
				<tr>
					<th bgcolor="#BDBDBD"><font color="white">첨부파일</font></th>
					<td colspan="3"><input type="file" id="fileName" name="fileName" size="100"></td>
				</tr>
			</table><p>
			<input type="button" onclick="check()" value="등록"> &nbsp;&nbsp;
			<input type="reset" value="취소"> &nbsp;&nbsp;
			<input type="button" onClick="location.href='borderList.do'" value="목록 보기"><p>
		</form>
	</div>
</div>

<!-- 작성일을 현재 날짜로 기본설정하는 스크립트 -->
<script>
	console.log(new Date().toISOString());
	document.getElementById('wdate').value = new Date().toISOString().substring(0,10);
</script>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>