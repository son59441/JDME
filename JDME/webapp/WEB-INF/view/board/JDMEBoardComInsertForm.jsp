<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>나에게로 와인 커뮤니티 게시판 등록</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			$(document).on('click', '#jbBtn', function(){
				alert("등록 하시겠습니까?");
				$("#boardComForm").attr({
					
					"action":"jdmeBoardComInsert.jdme",
					"method":"POST",
					"enctype":"multipart/form-data"
					
					
				}).submit();
				
				
			}); // end of click 
			
			
		}) // end of ready
	
	
	</script>
	<style type="text/css">
		
		.wrap{
			margin:auto;
		}
		
		.tt {
			text-align: center;
		}
		
		body{
			background:#ebe7b9;
		}
		
		input{
			background:#f7f4cd;
		}
		
		textarea{
			background:#f7f4cd;
		}
		
		
	</style>
	</head>
	<body>
		
		<h3 align="center">게시판 등록</h3>
		<hr>
		<form name="boardComForm" id="boardComForm">
		<table border="3" class="wrap">
		<tr>
			<td colspan="2" align="center">게시판</td>				
		</tr>
		<tr>
			<td class="tt">글번호</td>
			<td><input type="text" name="jbnum" id="jbnum" size="30" readonly></td>
		</tr>
		<tr>
			<td class="tt">제목</td>
			<td><input type="text" name="jbsubject" id="jbsubject" size="30"></td>
		</tr>
		<tr>
			<td class="tt">내용</td>
			<td>
			<textarea name="jbcontent" id="jbcontent" cols="50" rows="10"></textarea>
		</td>
		</tr>
		<tr>
			<td class="tt">비밀번호</td>
			<td><input type="password" name="jbpw" id="jbpw" maxlength="11"></td>
		</tr>
		<tr>
			<td class="tt">사진</td>
			<td>
			<input type="file" name="jbfile" id="jbfile">
		</td>
		</tr>
		<tr>
			<td colspan="2" align="center">				
				<input type="button" value="글쓰기" id="jbBtn">
				<input type="hidden" name="jmnum" id="jmnum" value="M0001"/>
				<input type="hidden" name="jmid" id="jmid" value="sonny"/>
				<input type="reset" value="취소">
			</td>			
		</tr>
		</table>
		</form>
	</body>
</html>