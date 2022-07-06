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
	<title>나에게로 와인 조건 조회 커뮤니티 게시판</title>
	
	
	
	
	
	
	
	
	<style type="text/css">
		
		body{
			background:#ebe7b9;
		}
		
		div {		 
			margin: 0 auto; 		
			border:1px solid #6d82f3;
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
			background:#f7f4cd;
		}
	
		textarea{
			background:#f7f4cd;
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
				<td colspan="2" align="center">
					<button type="button" id="insertbtn">글 쓰기</button>
					<button type="button" id="selectAllBtn">글 목록</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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