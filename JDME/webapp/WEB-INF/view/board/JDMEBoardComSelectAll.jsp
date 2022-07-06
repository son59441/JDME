<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="jdme.board.com.vo.JDMEBoardComVO" %>     
<%@ page import="java.util.List" %> 

<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
 
<% request.setCharacterEncoding("UTF-8");%>   
<%

	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("JDMEBoardComSelectAll.jsp 페이지 진입");

	Object obj = request.getAttribute("listAll");
	List<JDMEBoardComVO> list = (List<JDMEBoardComVO>)obj;
	
	int nCnt = list.size();
	String nCntS = "전체 조회 건수  " + nCnt + " 건";	

%>  
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>나에게로 와인 커뮤니티 게시판 전체조회</title>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			// jbnum 체크 박스 확인하기
			$(document).on("click","#jbnum",function(){
				
				if($(this).prop('checked')){
					$(".jbnum").prop('checked',false);
					$(this).prop('checked',true);
				}
			})
			
			// 커뮤니티 게시판 글 쓰러가기
			$(document).on("click","#insertBtn",function(){
				
				var insert = confirm("글 쓰기 페이지로 이동하시겠습니까?"); 
				
				if(insert){
					alert("글 쓰게 페이지로 이동합니다.");
					
					location.href="/JDME/JDMEBoardComInsertForm.jdme";
					return true;
				}else{
					alert("취소하셨습니다.");
					return false;
				}
				
			}); // end of 글쓰기 페이지
			
			
			// 조건 조회로 글 보러가기 로그인 되었을 시 가능
			$(document).on("click","#selectBtn",function(){
				
				var select = confirm("게시글을 보러가시겠습니까?");
				
				if($('.jbnum:checked').length == 0){
					alert("조회 할 게시글을 선택해주세요");
					return;
					
				}else if(select){
					alert("해당 글로 이동합니다.");
					
					$("#boardComList").attr({
						
						"action":"JDMEBoardComSelect.jdme",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
						
					}).submit();
					
				}else{
					alert("취소하셨습니다.");
					return false;
				}
				
			}); // end of 조건 조회 
			
		}) // end of ready
	
	</script>
	<style type="text/css">
	
		td, th {
			padding: 5px;
		}
	
		h3, th {
			text-align: center;
		}
		.tt {
			text-align: center;
		}
		
		body{
			background:#ebe7b9;
		}
		
	
	</style>
	</head>
	<body>
		<h3>게시판 글 목록</h3>
		<hr>
		<form name="boardComList" id="boardComList">
			<table border="3" align="center">
			<thead>
				<tr>
					<td colspan="9"><%= nCntS %></td>
				</tr>	
				<tr>
					<th><input type="checkbox" name="chkAll" id="chkAll"/></th>
					<th>게시글</th>
					<th>글 번호</th>
					<th>글 제목</th>
					<th>글 내용</th>
					<th>사진</th>		
				</tr>
			</thead>
			<%
			
				for(int i=0; i<nCnt; i++){
					JDMEBoardComVO _jbcvo = list.get(i);
				%>
			<tbody>
				<tr>
					<td class="tt">
						<input type="checkbox" id="jbnum" name="jbnum" class="jbnum"
						value=<%= _jbcvo.getJbnum() %> />
						<input type="hidden" value="<%= _jbcvo.getJmnum() %>"/>	
						<input type="hidden" value="<%= _jbcvo.getJmid() %>"/>	 	
					</td>
					<td class="tt"><%= i + 1 %></td>
					<td class="tt"><%= _jbcvo.getJbnum() %></td>
					<td class="tt"><%= _jbcvo.getJbsubject() %></td>
					<td class="tt"><%= _jbcvo.getJbcontent() %></td>
					<td class="tt"><img src="/JDME/upload/board/<%= _jbcvo.getJbfile() %>" border="1" width="100" height="100" alt="image"></td>
				</tr>
			<%
				} // end of for
			%>
			<tr>
				<td colspan="9" align="center">				
					<input type="button" value="글쓰기" id="insertBtn">
					<input type="button" value="글내용보기" id="selectBtn">								
				</td>
			</tr>	
			</tbody>
			</table>
		</form>
	</body>
</html>