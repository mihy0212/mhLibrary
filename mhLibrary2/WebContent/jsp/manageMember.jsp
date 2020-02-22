<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용자 관리</title>
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
            	document.location.href="memDel.do?key="+delId;
        		//$('#'+$delId).remove();
        	}
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
		<h1>이용자 목록</h1>
		<hr size="1" width="800">
	</div>
	
	<c:choose>
	<c:when test="${grant == 'S'}">
	<br><div>
		<table border="1">
			<tr bgcolor="#BDBDBD">
				<th width="150"><font color="white">이용자ID</font></th>
				<th width="150"><font color="white">이름</font></th>
				<th width="150"><font color="white">전화번호</font></th>
				<th width="150"><font color="white">권한</font></th>
				<th width="50"><font color="white">선택</font></th>
			</tr>
			
			<!-- DB 목록을 가져와서 뿌려주는 곳 : 등록된 글이 없을 때와 있을 때 구분해서 작성-->
			<c:if test="${nlist.isEmpty()}">
				<tr>
					<td colspan="6" align="center">등록된 회원이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			
			<c:forEach items="${ mlist }" var="mdto">
				<!-- 마우스로 행을 클릭하면 글 조회 가능하도록 설정 -->
				<!-- tr onclick="location.href='myInfo.do?key=${ mdto.memberId }'"
					 onmouseover="this.style.background='#F2F2F2'"
					 onmouseout="this.style.background='white'"-->
				<tr onmouseover="this.style.background='#F2F2F2'"
					 onmouseout="this.style.background='white'">
					<td align="center">${mdto.memberId}</td><!-- 이용자ID -->
					<td align="center">${mdto.memberName}</td><!-- 이름 -->
					<td align="center">${mdto.memberTel}</td><!-- 전화번호 -->
					<td align="center">${mdto.memberGrant}</td><!-- 권한 -->
					<td align="center"><input type="checkbox" id="chk" name="chk" value="checked"/></td><!-- 선택박스 -->
				</tr>
			</c:forEach><!-- DB 목록을 가져와서 뿌려주는 곳 end -->
		</table>
	</div><br>
	
	<div id='show1'>
		<input type="button" onclick="del()" id="deleteBtn" name="deleteBtn" value="회원 삭제">
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