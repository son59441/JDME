<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
 		<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			
			$(document).ready(function(){
				$("#lang").change(function(){
					var lang = $('#lang option:checked').val();
					console.log("lang >>> : " + lang);
				if(lang==="korean"){
					$("#lang_sel_form").attr({
						'action':'jdmeMainPage.jdme',
						'method':'GET'
					}).submit();}
				if(lang==="english"){
					$("#lang_sel_form").attr({
						'action':'jdmeEnMainPage.jdme',
						'method':'GET'
					}).submit();}
				if(lang==="japanese"){
					$("#lang_sel_form").attr({
						'action':'jdmeJaMainPage.jdme',
						'method':'GET'
					}).submit();}
				});//endofchange
			});//endof ready
			
			//로그아웃 컨펌 
			function logout_confirm(){
				if (!confirm("정말 로그아웃 하시겠습니까?")) {
			       // 취소(아니오) 버튼 클릭 시 이벤트
			    } else {
			       // 확인(예) 버튼 클릭 시 이벤트
			       location.href="jdmeLogout.jdme";
			    }
			}
			
			//로그인 팝업창
			function login(){
				//window.open("jdmeLoginForm.jdme");
				window.open("jdmeLoginForm.jdme","_blank","height=600,width=600, status=yes,toolbar=no,menubar=no,location=no");
				setTimeout(function() {
			    opener.location.reload(); //부모창 리프레쉬
			    self.close(); //현재창 닫기
			    }, 1000); // 1초후 실행 1000당 1초
				return false	
			}
			
		</script>
		
		<link href="css/header_test2.css" rel="stylesheet">
		
				</head>
				<body >
				<div class="test">
						    <input type="checkbox"  id="active">
			    <label for="active" class="menu-btn"><i class="fas fa-bars"></i></label>
			    <div class="wrapper">
			      <ul>
						<li>
						<%if(session.getAttribute("KID")!=null){ 
						%>
						<%=session.getAttribute("KID") %>님 환영합니다.<br>
							<a href="javascript:logout_confirm()" style="cursor:pointer;">로그아웃</a>
						<%
						}else{
						%><a href="javascript:login()" style="cursor:pointer;">로그인</a>
						<%} %></li>
						<li><%if(session.getAttribute("KID")!=null){ 
						%>
						<a href="" style="cursor:pointer;">My Page</a>
						<%
						}else{
						%><a href="jdmeMemberInsertForm.jdme" style="cursor:pointer;">회원가입</a>
						<%} %></li>
						<li>
							<form id="lang_sel_form">
							  <select id="lang" name="lang" >
							    <option value="none">=== 선택 ===</option>
							    <option value="korean">한국어</option>
							    <option value="english">영어</option>
							    <option value="japanese">일본어</option>
							  </select>
							</form>
						</li>
</ul>
</div>
</div>
	</body>
</html>

