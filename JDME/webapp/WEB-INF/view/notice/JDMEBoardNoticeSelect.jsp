<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>    
<%@ page import="jdme.board.notice.vo.JDMEBoardNoticeVO" %>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="jdme.common.K_Session" %>
<%@ page import="java.io.PrintWriter" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("JDMEBoardNoticeSelectAll.jsp 페이지 진입");
	
	String jnnum = request.getParameter("jnnum");
	String admin = request.getParameter("admin");

	// 컨트롤러에서 보내준 listS를 받아줘서 형변환을 해줄 것
		Object obj = request.getAttribute("listS");
		if (obj == null) return;

		// 불러온 값을 List를 사용하여 받아준다.
		List<JDMEBoardNoticeVO> list = (List<JDMEBoardNoticeVO>)obj;	
		int nCnt = list.size();
		
		// 담겨 있던 _kbvo에 값들을 list에 담고 뽑아올 것
		JDMEBoardNoticeVO _jbnvo = null;
		if (nCnt == 1){
			_jbnvo = list.get(0);
		}	
		
		
		K_Session ks = K_Session.getInstance();

		logger.info("ks >>> " + ks);

		logger.info("세션키 확인  >>> : "+session.getAttribute("KID"));


		String KID = null;
		
		if(session.getAttribute("KID")!=null){
			
			KID = (String)session.getAttribute("KID");
			logger.info("KID >>> : " + KID);
			
		}else {
			
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('관리자 전용 페이지입니다.');");
			pw.println("location.href='/JDME/JDMEBoardNoticeSelectAll.jdme'");
			pw.println("</script>");
		}

		
		
		
		

%>

 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>나에게로 와인 조건 조회 공지사항 게시판</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
		
			
			// insert버튼
			$(document).on('click','#insertbtn',function(){
				location.href="JDMEBoardNoticeInsertForm.jdme";
			});
					
			// update버튼
			$(document).on('click','#updateBtn',function(){
				
				$("#boardNoticeUpdateForm").attr({
					
					"action":"JDMEBoardNoticeUpdate.jdme",
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
		<div>
			<form name="boardNoticeUpdateForm" id="boardNoticeUpdateForm">
			<table border="1">
			<thead>
			<tr>
				<td align="center">
				<font size="4" style="color:blue;"><%= _jbnvo.getJnsubject() %></font>
				<input type="hidden" name="jnnum" id="jnnum" value="<%= _jbnvo.getJnnum() %>"/>
				<input type="hidden" name="admin" id="admin" value="<%= admin%>"/>
				</td>
			</tr>
			<tr>
				<td align="left">
				<font size="1" style="color:gray;">
				최초 작성일 : <%= _jbnvo.getJnidate() %>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				수정일 : <%= _jbnvo.getJnudate() %>
				</font>
				</td>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td align="center">
				<img class="photo" src="/JDME/upload/notice/<%= _jbnvo.getJnfile()%>" border="1" width="150" height="100" alt="image">
			</tr>
			<tr>
				<td align="center">
					<textarea name="jncontent" id="jncontent" rows="5" cols="50"><%= _jbnvo.getJncontent() %></textarea>
				</td>
			</tr>
			</tbody>
			<tfoot>
			<tr>
				<td align="left">
				<font size="1" style="color:black;">
				작성자 : <%= _jbnvo.getAdmin() %>
				</font>
				</td>
			<tr>
				<td colspan="3" align="center">
					<button type="button" id="insertbtn">공지사항 입력</button>
					<button type="button" id="updateBtn">수정</button>
				</td>
			</tr>
			</tfoot>
			</table>
			</form>
		</div>
	</body>
</html>