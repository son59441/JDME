<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/loginform.css">
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <!-- Jquery & JavaScript -->
		<script type="text/javascript">
			$(document).ready(function(){

				//submit 클릭 시 form태그 데이터 보내기
				$("#submit").on('click',function(){
					alert("버튼클릭 감지");
					if(isEmpty($('#jmid').val())||isEmpty($('#jmpw').val())){
						alert("아이디 혹은 비밀번호가 비어있습니다.");
					}else{
						$('#loginForm').attr({
							'action':"jdmeLoginCheck.jdme",
							'method':'GET'
						}).submit();//endofattrsubmit
					}
				});//endof loginbtn on 'click'
				
				//엔터쳤을 때 submit
				$("#submit").keyup(function(e){
					if(e.which == 13){
						if(isEmpty($('#jmid').val())||isEmpty($('#jmpw').val())){
							alert("아이디 혹은 비밀번호가 비어있습니다.");
						}else{
							$('#loginForm').attr({
							'action':"jdmeLoginCheck.jdme",
							'method':'GET'
							}).submit();//endofattrsubmit
						}
					}
				});
				
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
    <div class="wrap">
	    <form id="loginForm" name="loginForm">
	        <div class="login">
	            <h2>Log-in</h2>
	            <div class="login_sns">
	           	<!-- SNS를 이용한 것 삭제 -->
	            </div>
	            
	            <div class="login_id">
	                <h4>ID</h4>
	                <input type="text" name="jmid" id="jmid" placeholder="아이디">
	            </div>
	            
	            <div class="login_pw">
	                <h4>Password</h4>
	                <input type="password" name="jmpw" id="jmpw" placeholder="비밀번호">
	            </div>
	            
	            <div class="login_etc">
	                <div class="forgot_id">
	                	<a href="idFindForm.jdme"> Forgot ID?</a>
	                </div>
	                <div class="forgot_pw">
	                	<a href="pwFindForm.jdme">Forgot Password?</a>
	            	</div>
	            </div>
	            
	            <div class="submit">
	                <input type="submit" id="submit" value="submit">
	            </div>
	        </div>
	      </form>
    </div>
</body>
</html>