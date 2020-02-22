<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
</head>
<body>
<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- 본문 -->
<div align="center">

	<div>
		<h2>도서 등록</h2>
		<hr size="1" width="800"><br><br>
	</div>
	<div>
		<form id="frm" name="frm" action="bookAdd.do" method="post">
		
		<table border="1">
			<tr>
				<th width="150">서지번호</th>
				<td><input type="text" id="bookId" name="bookId" size="50"></td>
			</tr>
			<tr>
				<th width="100">도서명</th>
				<td><input type="text" id="bookTitle" name="bookTitle" size="50"></td>
			</tr>
			<tr>
				<th width="100">저자</th>
				<td><input type="text" id="bookAuthor" name="bookAuthor" size="50"></td>
			</tr>
			<tr>
				<th width="100">출판사 </th>
				<td><input type="text" id="bookPublisher" name="bookPublisher" size="50"></td>
			</tr>
			<tr>
				<th width="100">도서중복수</th>
				<td><input type="text" id="bookDupl" name="bookDupl" size="50"></td>
			</tr>
		</table><br>
		
		<input type="submit" value="도서 등록"> &nbsp;&nbsp;
		<input type="reset" value="입력 취소">
		</form>
	</div><br>
</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

	
</body>
</html>