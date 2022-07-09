<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>    
<%@ page import="jdme.board.com.vo.JDMEBoardComVO" %>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("kosmoBoardSelectAll.jsp 페이지 진입");
	
	String jbnum = request.getParameter("jbnum");
	String jmnum = request.getParameter("jmnum");

	// 컨트롤러에서 보내준 listS를 받아줘서 형변환을 해줄 것
		Object obj = request.getAttribute("listS");
		if (obj == null) return;

		// 불러온 값을 List를 사용하여 받아준다.
		List<JDMEBoardComVO> list = (List<JDMEBoardComVO>)obj;	
		int nCnt = list.size();
		
		// 담겨 있던 _kbvo에 값들을 list에 담고 뽑아올 것
		JDMEBoardComVO _jbcvo = null;
		if (nCnt == 1){
			_jbcvo = list.get(0);
		}	

%>

 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>나에게로 와인 조건 조회 커뮤니티 게시판</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			// 비밀번호 확인해주기
			$(document).on('click','#pwBtn',function(){
				let input_kbpw = prompt("비밀번호를 입력해주세요.");
				
				if(input_kbpw.length > 0){
					console.log(input_kbpw);
					
					let pwcheckURL = "kosmoBoardPwCheck.s";
					let reqType = "POST";
					let dataParam = {
						kbnum: $("#kbnum").val(),
						kbpw: input_kbpw,
					};
					
					console.log("dataParam --> : " + dataParam);
					
					$.ajax({
						
						url: pwcheckURL,
						type : reqType,
						data: dataParam,
						success : whenSuccess,
						error : whenError
						
						
					});
					
					function whenSuccess(resData){	
						console.log("resData --> : " + resData);					
						if ("ID_YES" == resData){					
							alert("비밀번호 GOOD.");												
							$("#updateBtn").css('background-color','yellow');	
							if($("#updateBtn").prop("disabled")==true){
								  $("#updateBtn").attr("disabled", false);
							}
						}else if ("ID_NO" == resDataFlag){
							alert("비밀번호 BAD.");
							return;
						};				
					}
					function whenError(e){
						console.log("e --> : " + e.responseText);
					}
					
				} // end of if
				
				
			}) // end of pwChk
			
			$.ajax({
				url:"kosmoGetKmnum.s",
				type:"POST",				
				success:whenSuccess,
				error:whenError
			});
			
			function whenSuccess(resData){
				console.log("resData >>> " + resData);		
				$("#kmnum").val(resData);
				//alert($("#kmnum").val());
			}
			
			function whenError(e){
				console.log("e >>> " + e.responseText);
			}
			
			
			// insert버튼
			$(document).on('click','#insertbtn',function(){
				location.href="JDMEBoardComInsertForm.jdme"
			});
					
			// update버튼
			$(document).on('click','#updateBtn',function(){
				
				$("#boardComUpdateForm").attr({
					
					"action":"JDMEBoardComUpdate.jdme",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
					
				}).submit();
				
			});
			
			
		}); // end of ready
	
		
	
	</script>
	<link href="css/sidebar.css" rel="stylesheet" />
	<style type="text/css">
		
		
		
		div {		 
			margin: 0 auto; 		
			border:0px solid #6d82f3;
			display:table;
		}			
		
		td, th {
			 padding: 5px;
		}
		
		h3 {
			text-align: center;
		}
		
		.mem {
			text-align: center;
		}
		
		input{
			background:#b7e0ed;
		}
	
		textarea{
			background:#b7e0ed;
		}
		
		.photo{
			width:150px;
			height:150px;
			border-radius:50%;
			background:#87c990;
			display:block;
			margin:0px auto;
		}
	
	</style>
	</head>
	<body>
		<h3>게시 글 내용</h3>
		<hr>
		<div class="wrapper">
	        <!--Top menu -->
	        <div class="sidebar">
	           <!--profile image & text-->
	           <div class="profile">
	                <img src="/JDME/img/son.jpg" alt="profile_picture">
	                <h3>Sonny</h3>
	                <p>SoccerPlayer</p>
         		</div>
	            <!--menu item-->
	            <ul>
                <li>
                    <a href="test.jdme" class="active">
                        <span class="icon"><i class="fas fa-home"></i></span>
                        <span class="item">Main</span>
                    </a>
                </li>
                <li>
                    <a href="JDMEBoardComInsertForm.jdme">
                        <span class="icon"><i class="fas fa-desktop"></i></span>
                        <span class="item">커뮤니티 글 쓰기</span>
                    </a>
                </li>
                <li>
                    <a href="JDMEBoardComSelectAll.jdme">
                        <span class="icon"><i class="fas fa-user-friends"></i></span>
                        <span class="item">커뮤니티 전체 게시글</span>
                    </a>
                </li>
                <li>
                    <a href="JDMEBoardNoticeInsertForm.jdme">
                        <span class="icon"><i class="fas fa-user-friends"></i></span>
                        <span class="item">공지사항 쓰기</span>
                    </a>
                </li>
                <li>
                    <a href="JDMEBoardNoticeSelectAll.jdme">
                        <span class="icon"><i class="fas fa-user-friends"></i></span>
                        <span class="item">공지사항</span>
                    </a>
                </li>
                 <li>
                    <a href="JDMEBoardQnaInsertForm.jdme">
                        <span class="icon"><i class="fas fa-user-friends"></i></span>
                        <span class="item">Q&A 질문</span>
                    </a>
                </li>
                <li>
                    <a href="JDMEBoardQnaSelectAll.jdme">
                        <span class="icon"><i class="fas fa-user-friends"></i></span>
                        <span class="item">Q&A</span>
                    </a>
                </li>
            </ul>
        </div>
	    </div>
		<div>
			<form name="boardComUpdateForm" id="boardComUpdateForm">
			<table border="1">
			<tr>
				<td align="center">
				<font size="4" style="color:blue;"><%= _jbcvo.getJbsubject() %></font>
				<input type="hidden" name="jbnum" id="jbnum" value="<%= _jbcvo.getJbnum() %>"/>
				<input type="hidden" name="jmnum" id="jmnum" value="<%= jmnum%>"/>
				</td>
			</tr>
			<tr>
				<td align="left">
				<font size="1" style="color:gray;">
				최초 작성일 : <%= _jbcvo.getJbidate() %>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				수정일 : <%= _jbcvo.getJbudate() %>
				</font>
				</td>
			</tr>
			<tr>
				<td align="center">
				<img class="photo" src="/JDME/upload/board/<%= _jbcvo.getJbfile()%>" border="1" width="150" height="100" alt="image">
			</tr>
			<tr>
				<td align="center">
					<textarea name="jbcontent" id="jbcontent" rows="5" cols="50"><%= _jbcvo.getJbcontent() %></textarea>
				</td>
			</tr>
			<tr>
				<td align="left">
				<font size="1" style="color:black;">
				작성자 : <%= _jbcvo.getJmid() %>
				</font>
				</td>
			<tr>
				<td colspan="3" align="center">
					<button type="button" id="insertbtn">커뮤니티 쓰러가기</button>
					<button type="button" id="updateBtn" disabled>수정</button>
					<button type="button" id="pwBtn">비밀번호 확인</button>
				</td>
			</tr>
			</table>
			</form>
		</div>
		<!-- 댓글 처리 해주는 루틴 -->
		<jsp:include page="/JDMEBoardReplyInsertForm.jdme">
			<jsp:param value="<%=_jbcvo.getJbnum()%>" name="jbnum"/>
		</jsp:include>
	</body>
</html>