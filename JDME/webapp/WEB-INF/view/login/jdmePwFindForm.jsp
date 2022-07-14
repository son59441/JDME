<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PWFIND_ID</title>
		 <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				$("#jmid").attr('placeholder', '아이디');		
				
				$("#pwIdFindbtn").click(function(){
					console.log("pwFindbtn >>> : ");
					if(isEmpty($('#jmid').val())){
						alert("아이디란을 채워주세요");}
					else{
					$('#pwIdFindForm').attr({
						'action':'pwIdFind.jdme',
						'method':'GET',
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
					}
				});//endof click
			});//endof ready
			
			//ID || PW 빈문자열/unidentifed 처리
			function isEmpty(str){
				if(typeof str == "undefined" || str == null || str == ""){
					return true;}
				else{
					return false ;}
			}
		</script>
		<link rel="stylesheet" href="resources/css/login_css/loginform.css">
	</head>
	<body>
	    <div class="wrap">
		    <form name="pwIdFindForm" id="pwIdFindForm">
		        <div class="login">
		            <h2>Log-in</h2>
		            <div class="login_sns">
					<!--삭제처리-->
		            </div>
		            <div class="login_id">
		                <h4>ID</h4>
		                <input type="text" name="jmid" id="jmid" placeholder="아이디">
		            </div>
		            <div class="submit">
		                <input type="button" id="pwIdFindbtn" value="submit">
		            </div>
		        </div>
		    </form>
	    </div>
	</body>
</html>