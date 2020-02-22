<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 검색</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function searchCon(){
		//frm.textValue.value = frm.selectBox.options[frm.selectBox.selectedIndex].text;
		 //frm.optionValue.value = frm.selectBox.options[frm.selectBox.selectedIndex].value;

		var target = document.getElementById("selectBox");
		var wh = target.options[target.selectedIndex].value;
		var cond = document.getElementById("condition").value;
		console.log(cond);
		
		document.location.href="searchForm.do?where="+wh+"&condition="+cond;
	}
	
    function rent(val){
    	var mid = document.getElementById('mid').value;
		console.log(mid + "세션 아이디");
		
		if(!mid){
			alert("먼저 로그인을 해 주세요.");
			return false;
		}

       	document.location.href="rent.do?bookNum="+val+"&mid="+mid;
       	//$('#'+$delId).remove();
    }
    
    function ret(){
    	var mid = document.getElementById('mid').value;
		console.log(mid + "세션 아이디");
		
		if(!mid){
			alert("먼저 로그인을 해 주세요.");
			return false;			
		}
		
        if( $('input').is(":checked") ){
        	var $id = $('input:checked').parent().parent();
        	console.log($id);
        	
        	for(var i=0; i<$id.length; i++){
        		var retId = $id.eq(i).children().eq(0).text();
        		console.log(retId);
            	document.location.href="return.do?bookNum="+retId+"&mid="+mid;
        		//$('#'+$delId).remove();
        	}
        }
    }
    
    /*
    function rent(){
    	var mid = document.getElementById('mid').value;
    	var form = document.frm;
		console.log(mid + "세션 아이디");
		
		if(!mid){
			alert("먼저 로그인을 해 주세요.");
			return false;			
		}
		
        form.submit();
    }
    
    function ret(){
    	var mid = document.getElementById('mid').value;
		console.log(mid + "세션 아이디");
		
		if(!mid){
			alert("먼저 로그인을 해 주세요.");
			return false;			
		}
		
        form.submit();
    }*/
	
</script>
</head>
<body>

<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- 본문 -->
<div align="center">
<input type="hidden" id="mid" name="mid" value=${ id }>
	<div>
		<h2>도서 조회</h2>
		<hr size="1" width="800">
	</div><br>
	
	<!-- 검색창 -->
	<div>
	<form id='frm' name="frm">
		<select name="selectBox" id="selectBox">
			<option value="selectAll" selected="selected">전체</option>
			<option value="bookId">서지번호</option>
			<option value="bookTitle">도서명</option>
			<option value="bookAuthor">저자</option>
			<option value="bookPublisher">출판사</option>
		</select> &nbsp; &nbsp;
		<input type="text" name="condition" id="condition">&nbsp; &nbsp;
		<input type="button" name="searchBtn" id="searchBtn" onclick="searchCon()" value="조회">
	</form>
	</div><br><br>
	
	<!-- 조회 결과 리스트 창 -->
	<form id='frm' name="frm" action="" method="post">
	<div id='show'>
	<input type="hidden" id="mid" name="mid" value=${ id }>
		<table border="1">
			<tr bgcolor="#BDBDBD">
				<th width="50"><font color="white">도서순번</font></th>
				<th width="100"><font color="white">서지번호</font></th>
				<th width="300"><font color="white">도서명</font></th>
				<th width="50"><font color="white">권수</font></th>
				<th width="200"><font color="white">저자</font></th>
				<th width="200"><font color="white">출판사</font></th>
				<th width="150"><font color="white">대출 가능</font></th>
				<th width="150"><font color="white">반납 예정일</font></th>
				<th width="150"><font color="white">대출하기</font></th>
			</tr>
			
			<!-- DB 목록을 가져와서 뿌려주는 곳 : 등록된 글이 없을 때와 있을 때 구분해서 작성-->
			<c:if test="${list.isEmpty()}">
				<tr>
					<td colspan="9" align="center">조회 결과가 없습니다.</td>
				</tr>
			</c:if>
			
			<c:forEach items="${ list }" var="bdto">
				<tr id="${bdto.bookNum}"
					 onmouseover="this.style.background='#F2F2F2'"
					 onmouseout="this.style.background='white'">
					<td align="center">${bdto.bookNum}</td><!-- 도서순번 -->
					<td align="center">${bdto.bookId}</td><!-- 서지번호 -->
					<td align="center">${bdto.bookTitle}</td><!-- 도서명 -->
					<td align="center">${bdto.bookDupl}</td><!-- 중복번호 -->
					<td align="center">${bdto.bookAuthor}</td><!-- 저자 -->
					<td align="center">${bdto.bookPublisher}</td><!-- 출판사 -->
					<td align="center"><!-- 대출 가능 여부 -->
						<c:choose>
							<c:when test="${ (bdto.bookOutday != null)&&( empty bdto.bookInday) }">
								<font color="red">대출 불가</font></c:when>
							<c:otherwise>
								<font color="blue">대출 가능</font>
							</c:otherwise>
						</c:choose>
					</td>
					<td align="center">${bdto.bookDueday}</td><!-- 반납예정일 -->
					<td align="center">
							<c:choose>
							<c:when test="${ (bdto.bookOutday != null)&&( empty bdto.bookInday) }">
							</c:when>
							<c:otherwise>
								<button type="button" onclick="rent(this.value)" id="rentBtn" name="rentBtn" value="${ bdto.bookNum }">대출하기</button>
								<input type="hidden" id="chkrent" name="chkrent" value="${ bdto.bookNum }"/>
							</c:otherwise>
						</c:choose>
					</td><!-- 대출하기 -->
				</tr>
			</c:forEach><!-- DB 목록을 가져와서 뿌려주는 곳 end -->
		</table>
	</div><br>
	</form>
	
</div><br><br>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>