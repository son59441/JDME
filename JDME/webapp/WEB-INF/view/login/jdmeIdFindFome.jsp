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
				alert("알러트");
				$("#mcomfirm").click(function(){
					alert("mcomfirm 버튼 확인 ");
					
					if(isEmpty($('#jmname').val())||isEmpty($('#jmemail').val())){
						alert("이름칸 혹은 이메일칸이 비어있습니다.");
					}else{
					let urlc = "email_authentication.jdme";						
					let jmnameVal = $("#jmname").val();			
					let jmemailVal = $("#jmemail").val();			
							
					$.ajax({
						url:urlc,
						type:"POST",
						data: {"jmname":jmnameVal, "jmemail":jmemailVal},
						async: false,
						success:whenSuccess,
						error:whenError
					});
					function whenSuccess(data){
						var sVal = $(data).find("result").text();	
						alert("메일을 성공적으로 보냈습니다!");
						
					}
					function whenError(e){
						alert("e >>> : " + e.responseText);
					}
					
					}
				});
				
				$("#idbtn").click(function(){
					console.log("idbtn >>> : ");
					alert("idbtn >>> : ");		
					if(isEmpty($('#jmname').val())||isEmpty($('#jmemail').val())||isEmpty($('#authnum').val())){
					alert("정보란을 모두 채워주세요");
					}else{
					alert("submit버튼");
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
	  	<form id="idForm" name="idForm">
		        <div class="login">
		    
		            <h2>아이디찾기 - 이메일인증</h2>
		            <div class="login_sns">
					<!--삭제처리-->
		            </div>
		            <div class="login_id">
		                <h4>이름</h4>
		                <input type="text" name="jmname" id="jmname" placeholder="name">
		            </div>
		            <div class="login_pw">
		                <h4>E-MAIL</h4>
		                <input type="text" name="jmemail" id="jmemail" placeholder="email">
		            </div>
		            <div class="submit">
		                <input type="button" id="mcomfirm" name="mcomfirm" value="Auth">
		            </div>
		            <div class="login_pw">
		                <h4>AUTH-NUMBER</h4>
		                <input type="text" name="authnum" id="authnum" placeholder="authnum">
		            </div>
		          
		            <div class="submit">
		                <input type="submit" id="idbtn" name="idbtn" value="submit">
		            </div>
		         
		        </div>
	        </form>
	    </div>
	</body>
</html>