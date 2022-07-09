<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>나에게로 와인 커뮤니티 게시판 등록</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			$(document).on('click', '#jqBtn', function(){
				
				var insert = confirm("등록하시겠습니까?");
				
				if(insert){
					$("#boardQnaForm").attr({
						
						"action":"JDMEBoardQnaInsert.jdme",
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
		<h3 align="center">Q&A 글 쓰기</h3>
		<hr>
		<form name="boardQnaForm" id="boardQnaForm">
		<table border="3" class="wrap">
		<tr>
			<td colspan="2" align="center">Q&A</td>				
		</tr>
		<tr>
			<td class="tt">글번호</td>
			<td><input type="text" name="jqnum" id="jqnum" size="30" readonly></td>
		</tr>
		<tr>
			<td class="tt">제목</td>
			<td><input type="text" name="jqsubject" id="jqsubject" size="30"></td>
		</tr>
		<tr>
			<td class="tt">내용</td>
			<td>
			<textarea name="jqcontent" id="jqcontent" cols="50" rows="10"></textarea>
		</td>
		</tr>
		<tr>
			<td class="tt">사진</td>
			<td>
			<input type="file" name="jqfile" id="jqfile">
		</td>
		</tr>
		<tr>
			<td colspan="2" align="center">				
				<input type="button" value="글쓰기" id="jqBtn">
				<input type="hidden" name="jmnum" id="jmnum" value="M0003"/>
				<input type="hidden" name="jmid" id="jmid" value="Son"/>
				<input type="reset" value="취소">
			</td>			
		</tr>
		</table>
		</form>
	</body>
</html>