<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>    
<%@ page import="jdme.board.qna.vo.JDMEBoardQnaVO" %>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("JDMEBoardQnaSelect.jsp 페이지 진입");
	
	String jqnum = request.getParameter("jqnum");
	String jmnum = request.getParameter("jmnum");

	// 컨트롤러에서 보내준 listS를 받아줘서 형변환을 해줄 것
		Object obj = request.getAttribute("listS");
		if (obj == null) return;

		// 불러온 값을 List를 사용하여 받아준다.
		List<JDMEBoardQnaVO> list = (List<JDMEBoardQnaVO>)obj;	
		int nCnt = list.size();
		
		// 담겨 있던 _kbvo에 값들을 list에 담고 뽑아올 것
		JDMEBoardQnaVO _jbqvo = null;
		if (nCnt == 1){
			_jbqvo = list.get(0);
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
				let input_jqpw = prompt("비밀번호를 입력해주세요.");
				
				if(input_jqpw.length > 0){
					console.log(input_jqpw);
					
					let pwcheckURL = "JDMEBoardQnaPwcheck.jdme";
					let reqType = "POST";
					let dataParam = {
						jqnum: $("#jqnum").val(),
						jqpw: input_jqpw,
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
						if ("PW_YES" == resData){					
							alert("비밀번호가 일치합니다.");												
							$("#updateBtn").css('background-color','#a9ded6');	
							if($("#updateBtn").prop("disabled")==true){
								  $("#updateBtn").attr("disabled", false);
							}
						}else if ("PW_NO" == resData){
							alert("비밀번호가 일치하지 않습니다.");
							return;
						};				
					}
					function whenError(e){
						console.log("e --> : " + e.responseText);
					}
					
				} // end of if
				
				
			}) // end of pwChk
			
			
			// insert버튼
			$(document).on('click','#insertbtn',function(){
				location.href="JDMEBoardQnaInsertForm.jdme"
			});
					
			// update버튼
			$(document).on('click','#updateBtn',function(){
				
				$("#boardQnaUpdateForm").attr({
					
					"action":"JDMEBoardQnaUpdate.jdme",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
					
				}).submit();
				
			});
			
			
		}); // end of ready
	
		
	
	</script>
	<link href="css/sidebar.css" rel="stylesheet" />
	<style type="text/css">
		
		.qna{
		
			margin: auto; 		
			border:5px solid #116091;
			display:table;
			
		}
		
		.qnareply{
			margin: auto; 		
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
                    <a href="/JDME/index.jsp" class="active">
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
		<div class="qna">
			<form name="boardQnaUpdateForm" id="boardQnaUpdateForm">
			<table>
			<thead>
			<tr>
				<td align="center">
				<font size="4" style="color:blue;"><%= _jbqvo.getJqsubject() %></font><hr>
				<input type="hidden" name="jqnum" id="jqnum" value="<%= _jbqvo.getJqnum() %>"/>
				<input type="hidden" name="jmnum" id="jmnum" value="<%= jmnum%>"/>
				</td>
			</tr>
			<tr>
				<td align="left">
				<font size="3" style="color:black">
				최초 작성일 : <%= _jbqvo.getJqidate() %>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				수정일 : <%= _jbqvo.getJqudate() %>
				</font>
				</td>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td align="center">
				<img class="photo" src="/JDME/upload/qna/<%= _jbqvo.getJqfile()%>" border="1" width="150" height="100" alt="image">
			</tr>
			<tr>
				<td align="center">
					<textarea name="jqcontent" id="jqcontent" rows="5" cols="50" ><%= _jbqvo.getJqcontent() %></textarea>
				</td>
			</tr>
			<tr>
				<td align="left">
				<font size="3" style="color:black;">
				작성자 : <%= _jbqvo.getJmid() %>
				</font>
				</td>
			</tbody>
			<tfoot>
			<tr>
				<td colspan="3" align="center">
					<button type="button" id="insertbtn">커뮤니티 쓰러가기</button>
					<button type="button" id="updateBtn" disabled>수정</button>
					<button type="button" id="pwBtn">비밀번호 확인</button>
				</td>
			</tr>
			</tfoot>
			</table>
			</form>
		</div>
		<div class="qnareply">
		<!-- 댓글 처리 해주는 루틴 -->
		<jsp:include page="/JDMEBoardQnaReplyInsertForm.jdme">
			<jsp:param value="<%=_jbqvo.getJqnum()%>" name="jqnum"/>
		</jsp:include>
		</div>
	</body>
</html>