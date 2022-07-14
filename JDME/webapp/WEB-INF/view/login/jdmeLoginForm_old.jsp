<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<!-- Jquery & JavaScript -->
		<script type="text/javascript">
			$(document).ready(function(){
				alert("ready");
				
				//form태그 데이터 보내기
				$("#loginbtn").on('click',function(){
					alert("버튼클릭 감지");
					console.log("$('#jmid').val() >>> : " + $('#jmid').val());
					console.log("$('#jmpw').val() >>> : " + $('#jmpw').val());
					if(isEmpty($('#jmid').val())||isEmpty($('#jmpw').val())){
						
					}else{
						$('#loginForm').attr({
						'action':"jdmeLoginCheck.jdme",
						'method':'GET'
						}).submit();//endofattrsubmit
					}
				});//endof loginbtn on 'click'
			});//endof ready
			
			//ID || PW 빈문자열/unidentifed 처리
			function isEmpty(str){
				if(typeof str == "undefined" || str == null || str == ""){
					return true;}
				else{
					return false ;}
			}
			
		</script>
		
	</head>
	<body>
		<h3>로그인테스트</h3>
		<div id="loginCon">
			<form id="loginForm" name="loginForm">
				<input type="text" name="jmid" id="jmid" style="width:200px;" placeholder="아이디">
				<!-- password로 바꿀 것 -->
				<input type="text" name="jmpw" id="jmpw" style="width:200px;"placeholder="비밀번호">
				<input type="button" id="loginbtn" value="로그인" style="width:208px; background-color:yellow;">	
			</form>
			<a href="idFindForm.jdme"><font size="2">아이디찾기</font></a><br>
			<a href="pwFindForm.jdme"><font size="2">비밀번호찾기</font></a><br>
		</div>
	</body>
</html>