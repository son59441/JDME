<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>TEMP PW</title>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			alert(">>> : ");
			
			$("#emailbtn").click(function(){
				alert("emailbtn >>> : ");
				
				let url = "id_email_authentication.jdme";
				let midVal = $("#jmid").val();			
				let memailVal = $("#jmemail").val();
				
				$.get(url
					 ,{"jmid": midVal, "jmemail": memailVal}
					 ,function(data){	
						
						var sVal = $(data).find("result").text();	
						alert("이메일을 확인 바랍니다");					
					 }
				);			
			});
		
			$("#pwbtn").click(function(){
				console.log("pwbtn >>> : ");
				$('#pwForm').attr({
					'action':'pwCreateForm.jdme',
					'method':'GET',
					'enctype':'application/x-www-form-urlencoded'
				}).submit();
			});
			
		});
		
	</script>
	<link rel="stylesheet" href="resources/css/login_css/loginform.css">
	</head>


	<body>
	    <div class="wrap">
		    <form id="pwForm" name="pwForm">
		        <div class="login">
		            <h2>Log-in</h2>
		            <div class="login_sns">
					<!--삭제처리-->
		            </div>
		            <div class="login_id">
		                <h4>ID</h4>
		                <input type="text" name="jmid" id="jmid" placeholder="아이디">
		            </div>
		            <div class="login_pw">
		                <h4>E-MAIL</h4>
		                <input type="text" name="jmemail" id="jmemail" placeholder="email">
		            </div>
		            <div class="submit">
		                <input type="button" id="emailbtn" value="Auth">
		            </div>
		            <p>인증 버튼을 누른 후 잠시만 기다리시면 인증확인 창이 뜹니다.</p>
		            <div class="submit">
		                <input type="button" id="pwbtn" value="Submit">
		            </div>
		        </div>
		    </form>
	    </div>
	</body>