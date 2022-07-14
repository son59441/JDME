<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="jdme.common.K_Session" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("JDMEBoardNoticeInsertForm.jsp 페이지 진입");
	
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
		pw.println("location.href='/JDME/jdmeLoginForm.jdme'");
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
	<title>나에게로 와인 커뮤니티  공지사항 게시판 등록</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			$(document).on('click', '#jnBtn', function(){
				
				var insert = confirm("등록하시겠습니까?");
				
				if(insert){
					$("#boardNoticeForm").attr({
						
						"action":"JDMEBoardNoticeInsert.jdme",
						"method":"POST",
						"enctype":"multipart/form-data"
						
						
					}).submit();
					
				}else{
					alert("취소하였습니다.");
					return;
				}
				
			}); // end of click 
			
			
		}) // end of ready

	
	</script>
	<link href="css/sidebar.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="css/ui.css">
	<style type="text/css">
		
		.wrap{
			margin:auto;
		}
		
		.tt {
			text-align: center;
		}
		
		body{
			background:#82b0cf;
		}
		
		input{
			background:#b7e0ed;
		}
		
		textarea{
			background:#b7e0ed;
		}
		
		
	</style>
	</head>
	<body>
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
	    <section id="container">
		<div class="conbox">
 	 		<section class="content_wrap">
 	 			<h3 class="form_tit">공지사항 !!</h3>
				<form name="boardNoticeForm" id="boardNoticeForm">
				<fieldset>
					<div class="formlist">
	                  <ul>
	                    <li>
	                      <label for="number" >글번호 : </label>
	                      <span class="inputbox">
	                      	<input type="text" id="jnnum" name="jnnum" readonly placeholder="빈 칸으로 두세요."/>
	                      </span>
	                    </li>
	                    <li>
	                      <label for="subject">제목 : </label>
	                      <span class="inputbox">
	                      	<input type="text" id="jnsubject" name="jnsubject" placeholder="제목을 작성해주세요." />
	                      </span>
	                    </li>
	                    <li>
	                      <label for="content">내용 :</label>
	                      <span class="textbox">
	                        <textarea id="jncontent" name="jncontent" placeholder="내용을 작성해 주세요"></textarea>
	                      </span>
	                    </li>
	                    <li>
	                      <label for="photo">사진</label>
	                      <span class="imgbox">
	                        <input type="file" name="jnfile" />
	                      </span>
	                    </li>
	                  </ul>
	                  <div class="btn_box">
	                      <input type="button" value="글쓰기" id="jnBtn">
						  <input type="hidden" name="jmnum" id="jmnum" value="M0003"/>
						  <input type="hidden" name="jmid" id="jmid" value="Son"/>
						  <input type="reset" value="취소">
	                  </div>
	                </div>
				</fieldset>
			</form>
 	 		</section>
		</div>
		</section>
	</body>
</html>