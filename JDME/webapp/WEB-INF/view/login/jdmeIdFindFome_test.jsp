<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>IDFIND</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<script type="text/javascript">
		
			$(document).ready(function(){	
				
				$("#mcomfirm").click(function(){
					alert("mcomfirm 버튼 확인 ");
					if(isEmpty($('#jmname').val())||isEmpty($('#jmemail').val())){
						alert("이름칸 혹은 이메일칸이 비어있습니다.");
					}else{
					let url = "email_authentication.jdme";						
					let jmnameVal = $("#jmname").val();			
					let jmemailVal = $("#jmemail").val();			
								
					$.get(url
						 ,{ "jmname":jmnameVal, "jmemail":jmemailVal }			
						 ,function(data){	
							var sVal = $(data).find("result").text();	
							alert("메일을 성공적으로 보냈습니다!");					
						 }
					);
					}
				});
				
				$("#idbtn").click(function(){
					console.log("idbtn >>> : ");
					alert("idbtn >>> : ");		
					if(isEmpty($('#jmname').val())||isEmpty($('#jmemail').val())||isEmpty($('#"authnum"').val())){
					alert("정보란을 모두 채워주세요");
					}else{
					$('#idForm').attr({
						'action':'idFind.jdme',
						'method':'GET',
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
					}
				});
			});//end of ready
			
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
	        <div class="login">
	            <h2>아이디찾기 - 이메일인증</h2>
	            <div class="login_sns">
				<!--삭제처리-->
	            </div>
	            <div class="login_id">
	                <h4>ID</h4>
	                <input type="text" name="jmname" id="jmname" placeholder="id">
	            </div>
	            <div class="login_pw">
	                <h4>E-MAIL</h4>
	                <input type="email" name="jmemail" id="jmemail" placeholder="email">
	            </div>
	            <div class="submit">
	                <input type="submit" id ="mcomfirm" value="Auth">
	            </div>
	            <div class="login_pw">
	                <h4>AUTH-NUMBER</h4>
	                <input type="text" name="authnum" id="authnum" placeholder="authnum">
	            </div>
	           
	            <div class="submit">
	                <input type="submit" value="submit">
	            </div>
	        </div>
	    </div>
	</body>
</html>