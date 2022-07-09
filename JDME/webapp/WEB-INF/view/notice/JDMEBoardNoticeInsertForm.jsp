<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	                <img src="https://img.sbs.co.kr/newimg/news/20220503/201660848_1280.jpg" alt="profile_picture">
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
		<h3 align="center">공지사항 게시판 등록</h3>
		<hr>
		<form name="boardNoticeForm" id="boardNoticeForm">
		<table border="3" class="wrap">
		<tr>
			<td colspan="2" align="center">공지사항 게시판</td>				
		</tr>
		<tr>
			<td class="tt">글번호</td>
			<td><input type="text" name="jnnum" id="jnnum" size="30" readonly></td>
		</tr>
		<tr>
			<td class="tt">제목</td>
			<td><input type="text" name="jnsubject" id="jnsubject" size="30"></td>
		</tr>
		<tr>
			<td class="tt">내용</td>
			<td>
			<textarea name="jncontent" id="jncontent" cols="50" rows="10"></textarea>
		</td>
		</tr>
		<tr>
			<td class="tt">사진</td>
			<td>
			<input type="file" name="jnfile" id="jnfile">
		</td>
		</tr>
		<tr>
			<td colspan="2" align="center">				
				<input type="button" value="글쓰기" id="jnBtn">
				<input type="hidden" name="admin" id="admin" value="admin"/>
				<input type="reset" value="취소">
			</td>			
		</tr>
		</table>
		</form>
	</body>
</html>