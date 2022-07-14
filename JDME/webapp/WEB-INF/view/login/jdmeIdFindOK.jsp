<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@page import="jdme.member.vo.JDMEMemberVO"%>  
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>IDFIND OK</title>
		<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    	<script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
		
			$(document).ready(function(){	
		
				$("#login").click(function(){
					console.log("login >>> : ");			
					$('#idfindokForm').attr({
						'action':'jdmeLoginForm.jdme',
						'method':'GET',
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
				});
				
				$("#pwFine").click(function(){
					console.log("pwFine >>> : ");			
					$('#idfindokForm').attr({
						'action':'jdmeLoginForm.jdme',
						'method':'GET',
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
				});
			});
		</script>
		<link rel="stylesheet" href="resources/css/login_css/jdmeFindFome_test.css">
	</head>
	<%	
		Object obj = request.getAttribute("listIdFind");
		if (obj == null) return;
	
		ArrayList<JDMEMemberVO> aList = (ArrayList<JDMEMemberVO>)obj;
		JDMEMemberVO jmvo = aList.get(0);
		String jmid = jmvo.getJmid();
		String insertdate = jmvo.getInsertdate();
		
		System.out.println("idEmailCheck mid >>> : " + jmid);
		System.out.println("idEmailCheck insertdate >>> : " + insertdate);
		
	%>	
    
	<body>
	    <div class="wrap">
	        <div class="login">
	            <h2>아이디 찾기</h2>
	            <div class="login_sns">
				<!--삭제처리-->
	            </div>
	            <div class="login_id">
	                <h4>회원님의 아이디</h4>
	                <input type="text" name="jmid" id="jmid" value="<%=jmid%>" readonly>
	        	</div>
	        </div>
	    </div>
	</body>
</html>