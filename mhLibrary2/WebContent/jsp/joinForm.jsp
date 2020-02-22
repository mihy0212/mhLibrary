<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>미현동 도서관 가입 신청서</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	/*function getXMLHttpRequest(){
		var httpRequest = null;
	
		if(window.ActiveXObject){
			try{
				httpRequest = new ActiveXObject("Msxml2.XMLHTTP");	
			} catch(e) {
				try{
					httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e2) { httpRequest = null; }
			}
		}
		else if(window.XMLHttpRequest){
			httpRequest = new window.XMLHttpRequest();
		}
		return httpRequest;	
	}
	
	function idCheck(){
		var checkid = document.frm.mid;
		console.log(checkid.value);
		if(!checkid.value){
			alert("아이디를 입력해 주세요.");
			checkid.focus();
			return false;
		} else {
			var param="mid="+checkid.value;
			httpRequest = getXMLHttpRequest();
			httpRequest.onreadystatechange = callback;
			httpRequest.open("POST", "idCheck.do", true);	
			httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
			httpRequest.send(param);
		}
	}
	
	function callback(){
		if(httpRequest.readyState == 4){
			// 결과값을 가져온다.
			var resultText = httpRequest.responseText;
			if(resultText == 1){
				alert("사용할 수 없는 아이디입니다.");
				checkid.value = "";
				checkid.focus();
				return false;
			} 
			else if(resultText == 1){ 
				confirm("사용 가능한 아이디입니다. 사용하시겠습니까?");
				if(confirm){
					idDupl.value = "check";
				} else{
					checkid.value = "";
					checkid.focus();
					return false;
				}
			}
		}
	}*/
		
		
		/* $.ajax({
			url: "MainController/idCheck.do",
			dataType: "json",
			data: {
				mid: $('#checkid').val()
			},
			success: function(result){
				console.log(result);
				if(result){
					confirm("사용 가능한 아이디입니다.");
					if(conform){
						$('#idDupl').val('check');
					}
				} else {
					alert("다른 이용자가 사용 중인 아이디입니다.")
				}
			} 
		});*/
	
	function idCheck(){
		var checkid = document.frm.mid;
		console.log(checkid.value);
		if(!checkid.value){
			alert("아이디를 입력해 주세요.");
			checkid.focus();
			return false;
		} 
		
		window.open("idCheck.do?mid="+checkid.value, "" ,"width=400,height=400");
	}
	
	//신청서 필수입력란 체크
	function checkForm(){
		var check = document.frm;
		if(!check.mid.value){
			alert("아이디를 입력해 주세요.");
			check.mid.focus();
			return false;
		}
		
		if(check.idDupl.value == 'uncheck'){
			alert("아이디 중복체크를 해주세요.");
			return false;
		}
		
		if(!check.mpw.value){
			alert("비밀번호를 입력해 주세요.");
			check.mpw.focus();
			return false;
		}
		
		if(!check.mpwck.value){
			alert("비밀번호 확인을 입력해 주세요.");
			check.mpwck.focus();
			return false;
		}
		
		if( check.mpwck.value != check.mpw.value){
			alert("비밀번호를 동일하게 입력해 주세요.");
			check.mpwck.value = "";
			check.mpwck.focus();
			return false;
		}
		
		if(!check.mname.value){
			alert("이름을 입력해 주세요.");
			check.mname.focus();
			return false;
		}
		
		check.submit();
	}

</script>
</head>
<body>

<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- 본문 -->
<div align="center">

	<div>
	<h1> 미현동 도서관 가입 신청 </h1>
	<hr size="1" width="800">
	</div><br>
	
	<div>
	<form id="frm" name="frm" action="join.do" method="post">
		<table border="1">
			<tr>
				<th width="150">아이디 <font color="red">*</font></th>
				<td><input type="text" id="mid" name="mid" size="20"> &nbsp;
					<input type="button" onclick="idCheck()" value="중복체크">&nbsp;
					<input type="hidden" id="idDupl" name="idDupl" value="uncheck"></td>
			</tr>
			<tr>
				<th width="100">비밀번호 <font color="red">*</font></th>
				<td><input type="password" id="mpw" name="mpw" size="20"></td>
			</tr>
			<tr>
				<th width="100">비밀번호 확인 <font color="red">*</font></th>
				<td><input type="password" id="mpwck" name="mpwck" size="20"></td>
			</tr>
			<tr>
				<th width="100">이름 <font color="red">*</font></th>
				<td><input type="text" id="mname" name="mname" size="20"></td>
			</tr>
			<tr>
				<th width="100">전화번호 </th>
				<td><input type="text" id="mtel" name="mtel" size="20"></td>
			</tr>
		</table>
		<br>
		<input type="button" onclick="checkForm()" value="신청서 제출"/>
		<input type="reset" onclick="location.href='loginForm.do'" value="취소">
	</form>
	</div>

</div><br>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>