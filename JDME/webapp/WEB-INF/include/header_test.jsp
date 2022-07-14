<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
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
			
			function login(){
				//window.open("jdmeLoginForm.jdme");
				window.open("jdmeLoginForm.jdme","_blank","height=500,width=500, status=yes,toolbar=no,menubar=no,location=no");
				setTimeout(function() {
			    opener.location.reload(); //부모창 리프레쉬
			    self.close(); //현재창 닫기
			    }, 1000); // 2초후 실행 1000당 1초
				return false	
			}
		</script>
		<link href="css/header.css" rel="stylesheet">
		<style type="text/css">
		
			.content{
				text-align:center;
			}
		
		</style>
	</head>
	<body>
		<header>
			<h3>나에게로 와인</h3>
			<nav>
		<!-- 언어설정 -->
				
				<div id="lang_sel">
					<form id="lang_sel_form">
					  <select id="lang" name="lang" >
					    <option value="none">=== 선택 ===</option>
					    <option value="korean">한국어</option>
					    <option value="english">영어</option>
					    <option value="japanese">일본어</option>
					  </select>
					</form>
				</div>
		<!-- 로그인 / 로그아웃 -->
				<span id="login_condition">
					<%if(session.getAttribute("KID")!=null){ 
					%>
					<%=session.getAttribute("KID") %>님 환영합니다.
					<a href="javascript:logout_confirm()" style="cursor:pointer;">로그아웃</a>
					<%
					}else{
					%><a href="javascript:login()" style="cursor:pointer;">로그인</a>
					<%} %>
				</span>
		<!-- 회원가입 -->
				<span id="sign_up">
					<%if(session.getAttribute("KID")!=null){ 
					%>
					<a href="#" style="cursor:pointer;">My Page</a>
					<%
					}else{
					%><a href="jdmeMemberInsertForm.jdme" style="cursor:pointer;">회원가입</a>
					<%} %>
				</span>
			</nav>
		</header>
		
				

<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<!-- 헤더 각 연결 -->

	<!-- 장바구니 -->
			<div id="cart_btn">
				<%if(session.getAttribute("KID")!=null){ 
				%>
				<a href="">장바구니</a>
				<%
				}else{
				%><!-- 세션을 가지지 않을 경우 장바구니를 보여주지 않음 -->
				<%} %>
			</div>
			<div id="subs_meta" class="content">
					<h2><a href="/JDME/index.jsp">사이드바</a></h2>
					</div>
					
					<div id="wine_reco_meta" class="content">
						<h2>쇼핑몰</h2>
					</div>
					
					<div id="shop_meta" class="content">
						<h2>맛집</h2>
					</div>
					
					<div id="comm_meta" class="content">
						<h2>커뮤니티</h2>
					</div>
			<script>
				const modal = document.getElementById("modal")
	
				function modalOn() {
				    modal.style.display = "flex"
				}
	
				function isModalOn() {
				    return modal.style.display === "flex"
				}
	
				function modalOff() {
				    modal.style.display = "none"
				}
	
	
				const btnModal = document.getElementById("btn-modal")
				btnModal.addEventListener("click", e => {
				    modalOn()
				})
	
				const closeBtn = modal.querySelector(".close-area")
				closeBtn.addEventListener("click", e => {
				    modalOff()
				})
	
				modal.addEventListener("click", e => {
				    const evTarget = e.target
				    if(evTarget.classList.contains("modal-overlay")) {
				        modalOff()
				    }
				})
	
				window.addEventListener("keyup", e => {
				    if(isModalOn() && e.key === "Escape") {
				        modalOff()
				    }
				})
			</script>
			
	</body>
</html>

