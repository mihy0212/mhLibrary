<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용 중인 아이디</title>
<script type="text/javascript">
	function send(){
		opener.document.frm.mid.value="";
		opener.document.frm.mid.focus();
		opener.document.frm.idDupl.value = "uncheck";
		window.close();
	}
</script>
</head>
<body>
<div align="center">
	<h2>${ param.mid }는 사용 중인 아이디입니다.<br></h2>
	<input type="button" onclick="send()" value="확인">
</div>
</body>
</html>