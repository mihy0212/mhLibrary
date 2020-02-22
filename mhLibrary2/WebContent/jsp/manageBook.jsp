<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	
	//맨 윗줄 체크하면 전체 체크 
    function allChk() {
		if( $(this).is(":checked") ){
			$('#chk').prop('checked',true);
		} else {
			$('#chk').prop('checked',false);
		}
	}
	
	//해당 줄을 클릭하면 체크됨
	$(document).on("click","tr",function(){
		console.log($(this).children().eq(0).text()); //찍은 tr의 자식들 중 첫번째 text(=bookNum)
		var $id = $(this).children().eq(0).text();
		if( $(this).is(":checked") ){
			$(this).prop('checked',false);
		} else {
			$(this).prop('checked',true);
		}
	});
	
	//'삭제'버튼을 클릭하면 체크된 요소 모두 삭제
    function del(){
        if( $('input').is(":checked") ){
        	var $id = $('input:checked').parent().parent();
        	console.log($id);
        	//console.log($id.eq(0));
        	//console.log($id.length);

        	for(var i=0; i<$id.length; i++){
        		var delId = $id.eq(i).children().eq(0).text();
        		console.log(delId);
            	document.location.href="bookDel.do?key="+delId;
        		//$('#'+$delId).remove();
        	}
        }
    }
	
	//'수정'버튼 클릭
	
	
	
</script>
</head>
<body>


<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- 본문 -->
<div align="center">

	<div>
		<h2>등록된 도서 목록</h2>
		<hr size="1" width="800">
	</div><br>

	<c:choose>
	<c:when test="${grant == 'S'}">
	<br>
	<div id='show'>
		<table border="1">
			<tr bgcolor="#BDBDBD">
				<th width="50"><font color="white">도서순번</font></th>
				<th width="100"><font color="white">서지번호</font></th>
				<th width="300"><font color="white">도서명</font></th>
				<th width="50"><font color="white">중복수</font></th>
				<th width="200"><font color="white">저자</font></th>
				<th width="200"><font color="white">출판사</font></th>
				<th width="150"><font color="white">등록 일자</font></th>
				<th width="150"><font color="white">대출일</font></th>
				<th width="150"><font color="white">반납 예정일</font></th>
				<th width="150"><font color="white">반납일</font></th>
				<th width="150"><font color="white">대출 회원ID</font></th>
				<th width="150"><input type="checkbox" onclick="allChk()" id="allchk" name="allchk" value="AllChecked"/></th>
			</tr>
			
			<!-- DB 목록을 가져와서 뿌려주는 곳 : 등록된 글이 없을 때와 있을 때 구분해서 작성-->
			<c:if test="${blist.isEmpty()}">
				<tr>
					<td colspan="12" align="center">등록된 도서가 존재하지 않습니다.</td>
				</tr>
			</c:if>
			
			<c:forEach items="${ blist }" var="bdto">
				<tr id="${bdto.bookNum}"
					 onmouseover="this.style.background='#F2F2F2'"
					 onmouseout="this.style.background='white'">
					<td align="center">${bdto.bookNum}</td><!-- 도서순번 -->
					<td>&nbsp;&nbsp; ${bdto.bookId}</td><!-- 서지번호 -->
					<td align="center">${bdto.bookTitle}</td><!-- 도서명 -->
					<td align="center">${bdto.bookDupl}</td><!-- 중복번호 -->
					<td align="center">${bdto.bookAuthor}</td><!-- 저자 -->
					<td align="center">${bdto.bookPublisher}</td><!-- 출판사 -->
					<td align="center">${bdto.bookRegidate}</td><!-- 등록일자 -->
					<td align="center">${bdto.bookOutday}</td><!-- 대출일 -->
					<td align="center">${bdto.bookDueday}</td><!-- 반납예정일 -->
					<td align="center">${bdto.bookInday}</td><!-- 반납일 -->
					<td align="center">${bdto.memberId}</td><!-- 대출 회원ID -->
					<td align="center"><input type="checkbox" id="chk" name="chk" value="checked"/></td><!-- 선택박스 -->
				</tr>
			</c:forEach><!-- DB 목록을 가져와서 뿌려주는 곳 end -->
		</table>
	</div><br>
	
	<div id='show1'>
		<input type="button" onclick="location.href='bookAddForm.do'" id="insertBtn" name="insertBtn" value="도서 등록">&nbsp;&nbsp;&nbsp;
		<!-- input type="hidden" onclick="" id="updateBtn" name="updateBtn" value="도서 수정"> &nbsp;&nbsp; -->
		<input type="button" onclick="del()" id="deleteBtn" name="deleteBtn" value="도서 삭제">
	</div>
	
	</c:when>
	
	<c:otherwise>
		<h2>이 페이지는 관리자만 볼 수 있습니다.</h2>
	</c:otherwise>
	</c:choose>
</div><br><br>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>