<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//로그인 팝업창으로 진행
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LOGOUT</title>
	<script type="text/javascript">
		//메인페이지 강제이동
		function timer(){
			setTimeout("locate()",1000);
			
		}
		function locate(){
			
			
			location.href="jdmeMainPage.jdme"
		}
	</script>
	<style type="text/css">
		h3 {
			 text-align: center;
		}	
	</style>
	</head>
		<body onload="timer()">
		<h3>Login Session Testing :: LOGOUT SUCCESS</h3>
			1초 후 페이지 이동
		<hr>
	</body>
</html>