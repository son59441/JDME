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

	
	//페이지 이동 할 수 있는 변수를 세팅하기
	int pageSize = 0;
	int groupSize = 0;
	int curPage = 0;
	int totalCount = 0;

	// 객체 받아와주기 , 페이지 넘길 수 있게 하기
	Object objPaging = request.getAttribute("pagingCom");
	JDMEBoardComVO pagingCom = (JDMEBoardComVO)objPaging;
	
	Object obj = request.getAttribute("listAll");
	List<JDMEBoardComVO> list = (List<JDMEBoardComVO>)obj;
	
	int nCnt = list.size();
	logger.info("nCnt --> : " + nCnt);
	String nCntS = "전체 조회 건수  " + nCnt + " 건";	

%>  
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>나에게로 와인 커뮤니티 게시판 전체조회</title>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
					alert("글 쓰기 페이지로 이동합니다.");
					
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
				
				if(select && $('.jbnum:checked').length == 1){
					alert("해당 글로 이동합니다.");
					
					$("#boardComList").attr({
						
						"action":"JDMEBoardComSelect.jdme",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
						
					}).submit();
					
				}else if(!select){
					alert("취소하였습니다.");
					return false;
				}
				
				if($('.jbnum:checked').length == 0){
					alert("조회 할 게시글을 선택해주세요");
					return;
					
				}
				
			}); // end of 조건 조회 
			
		}) // end of ready
	
	</script>
	<link href="css/sidebar.css" rel="stylesheet" />
	<style type="text/css">
	
		td, th {
			padding: 5px;
		}
	
		h3 {
			text-align: center;
		}
		.tt {
			text-align: center;
		}
		
		table.type09 {
		    border-collapse: collapse;
		  text-align: center;
		  line-height: 1.5;
		  margin: auto;
		}
		
		table.type09 thead th {
		  padding: 10px;
		  font-weight: bold;
		  vertical-align: top;
		  color: #369;
		  border-bottom: 3px solid #036;
		 
		}
		table.type09 tbody th {
		  width: 150px;
		  padding: 10px;
		  font-weight: bold;
		  vertical-align: top;
		  border-bottom: 1px solid #ccc;
		  background: #f3f6f7;
		}
		table.type09 td {
		  width: 200px;
		  padding: 10px;
		  vertical-align: center;
		  border-bottom: 1px solid #ccc;
		 
		}
		
		
	</style>
	
	</head>
	<body>
	<h3>커뮤니티 게시판</h3>
		<%@include file ="/WEB-INF/include/header_test.jsp" %>
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
	    
	    <div class="test">
		<form name="boardComList" id="boardComList">
			<table class="type09">
				<thead>
				  <tr>
					<td colspan="9"><%= nCntS %></td>
				  </tr>	
				  <tr>
				  	<th><input type="checkbox" name="chkAll" id="chkAll"/></th>
				    <th scope="cols">게시글</th>
				    <th scope="cols">글 번호</th>
				    <th scope="cols">글 제목</th>
				    <th scope="cols">글 내용</th>
				    <th scope="cols">사진</th>
				  </tr>
			  </thead>
			<%
			
				for(int i=0; i< nCnt; i++){
					JDMEBoardComVO _jbcvo = list.get(i);
					
					// 페이징 세팅
					pageSize = Integer.parseInt(pagingCom.getPageSize());
					groupSize = Integer.parseInt(pagingCom.getGroupSize());
					curPage = Integer.parseInt(pagingCom.getCurPage());
					totalCount = Integer.parseInt(_jbcvo.getTotalCount());
					
				
					
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
			<tfoot>
				<tr>
					<td colspan ="10">
						<jsp:include page="JDMEBoardComPaging.jsp" flush="true">
							<jsp:param value="JDMEBoardComSelectAll.jdme" name="url"/>
							<jsp:param value="" name="str"/>
							<jsp:param value="<%= pageSize %>" name="pageSize"/>
							<jsp:param value="<%= groupSize %>" name="groupSize"/>
							<jsp:param value="<%= curPage %>" name="curPage"/>
							<jsp:param value="<%= totalCount %>" name="totalCount"/>
						</jsp:include>
					</td>
				</tr>
			</tfoot>
			</table>
		</form>
		</div>
	</body>
</html>